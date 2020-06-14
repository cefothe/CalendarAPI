package eu.stefanangelov.event.services;

import java.time.LocalDateTime;
import java.util.List;

import eu.stefanangelov.event.persistence.repository.EventRepository;
import eu.stefanangelov.event.services.dto.EventDTO;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EventService {
	private final EventRepository eventRepository;

	public List<EventDTO> getAll(LocalDateTime from, LocalDateTime to) {
		return null;
	}
}
