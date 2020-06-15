package eu.stefanangelov.event.services;

import eu.stefanangelov.common.kafka.Topics;
import eu.stefanangelov.common.kafka.dto.CreateUpdateEvent;
import eu.stefanangelov.event.persistence.entity.Availability;
import eu.stefanangelov.event.persistence.entity.Event;
import eu.stefanangelov.event.persistence.repository.RoomRepository;
import eu.stefanangelov.event.persistence.repository.UserRepository;
import eu.stefanangelov.event.services.exception.EventConflictException;
import eu.stefanangelov.event.services.exception.NotFoundException;
import eu.stefanangelov.event.services.mapper.EventMapper;
import java.time.LocalDateTime;
import java.util.List;

import eu.stefanangelov.event.persistence.repository.EventRepository;
import eu.stefanangelov.common.kafka.dto.EventDTO;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class EventService {

	private final EventRepository eventRepository;
	private final UserRepository userRepository;
	private final RoomRepository roomRepository;
	private final KafkaTemplate<String, Object> kafkaTemplate;

	public List<EventDTO> getAll(LocalDateTime from, LocalDateTime to) {
		return eventRepository.findAllByAvailabilityFromDateLessThanEqualAndAvailabilityToDateGreaterThanEqual(from, to)
			.stream()
			.map(EventMapper.F::toDTO)
			.collect(Collectors.toList());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
    public EventDTO createEvent(CreateUpdateEvent createUpdateEvent) {
		var roomAvailable = eventRepository.existsByAvailabilityFromDateLessThanEqualAndAvailabilityToDateGreaterThanEqualAndRoomId(createUpdateEvent.getFrom(),
			createUpdateEvent.getTo(), createUpdateEvent.getRoom());
		if(roomAvailable){
			throw new EventConflictException("Room is not available at that interval");
		}
		var availableUsers = createUpdateEvent.getParticipants().stream()
			.map(userRepository::findById)
			.flatMap(Optional::stream)
			.map(user -> {
			if(eventRepository
					.existsByAvailabilityFromDateLessThanEqualAndAvailabilityToDateGreaterThanEqualAndParticipantsId(createUpdateEvent.getFrom(), createUpdateEvent.getTo(), user.getId())
				.isPresent()){
				return null;
			}
			return user;
			})
			.filter(Objects::nonNull)
			.collect(Collectors.toList());
		var room = roomRepository.findById(createUpdateEvent.getRoom()).orElseThrow(
			NotFoundException::new);
		var event = new Event(createUpdateEvent.getTitle(),
			new Availability(createUpdateEvent.getFrom(), createUpdateEvent.getTo()),
			null, LocalDateTime.now(),room,availableUsers);
		var eventDTO = EventMapper.F.toDTO(event);
		kafkaTemplate.send(Topics.CALENDAR_EVENT, eventDTO);
		return eventDTO;
	}
}
