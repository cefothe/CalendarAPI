package eu.stefanangelov.room.services.dto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomDTO {
    private UUID id;
    private String name;
}
