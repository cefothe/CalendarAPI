package eu.stefanangelov.event.services.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class EventDTO {
	private String id;
	private String title;
	private LocalDateTime from;
	private LocalDateTime to;
	private UserDTO createdBy;
	private LocalDateTime createdAt;
	private RoomDTO room;
	private List<UserDTO> participants;
}
