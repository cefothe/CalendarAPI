package eu.stefanangelov.common.kafka.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class CreateUpdateEvent {
    private String title;
    private LocalDateTime from;
    private LocalDateTime to;
    private String room;
    private List<String> participants;
}
