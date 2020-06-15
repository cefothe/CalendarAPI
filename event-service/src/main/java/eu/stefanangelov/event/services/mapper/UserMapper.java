package eu.stefanangelov.event.services.mapper;

import eu.stefanangelov.event.persistence.entity.User;
import eu.stefanangelov.common.kafka.dto.UserDTO;

public enum UserMapper {
    F;
    public UserDTO toDTO(User user){
        return new UserDTO(user.getId(), user.getUsername());
    }

}
