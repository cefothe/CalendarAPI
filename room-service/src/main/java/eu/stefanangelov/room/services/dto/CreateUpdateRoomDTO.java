package eu.stefanangelov.room.services.dto;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateUpdateRoomDTO {
    @NotBlank
    private String name;
}
