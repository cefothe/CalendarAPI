package eu.stefanangelov.common.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserCreateDTO {
    private String id;
    private String username;
}
