package eu.stefanangelov.event.services.mapper;


import eu.stefanangelov.common.kafka.dto.RoomDTO;
import eu.stefanangelov.event.persistence.entity.Room;

public enum  RoomMapper {
    F;
    public RoomDTO toDTO(Room room) {
        return new RoomDTO(room.getId(), room.getName());
    }
}
