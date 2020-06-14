package eu.stefanangelov.event.controller;


import java.time.LocalDateTime;
import java.util.List;

import eu.stefanangelov.event.services.EventService;
import eu.stefanangelov.event.services.dto.EventDTO;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/events")
public class EventController {

	private final EventService eventService;

	@GetMapping
	public List<EventDTO> getAllEvents(@RequestParam(value = "from") LocalDateTime from,
			@RequestParam(value = "to") LocalDateTime to){
		return eventService.getAll(from, to);
	}


}
