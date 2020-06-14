package eu.stefanangelov.event.services;

import eu.stefanangelov.common.kafka.dto.CreateUpdateEvent;
import eu.stefanangelov.event.services.exception.EventConflictException;
import java.time.LocalDateTime;
import java.util.List;

import eu.stefanangelov.event.persistence.repository.EventRepository;
import eu.stefanangelov.event.services.dto.EventDTO;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class EventService {
	private final EventRepository eventRepository;

	public List<EventDTO> getAll(LocalDateTime from, LocalDateTime to) {
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
    public EventDTO createEvent(CreateUpdateEvent createUpdateEvent) {
		var roomAvailable = eventRepository.existsByAvailabilityFromDateLessThanEqualAndAvailabilityToDateGreaterThanEqualAndRoomId(createUpdateEvent.getFrom(),
			createUpdateEvent.getTo(), createUpdateEvent.getRoom());
		if(roomAvailable){
			throw new EventConflictException("Room is not available at that interval");
		}
		return null;
	}
}
