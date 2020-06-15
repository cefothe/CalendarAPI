package eu.stefanangelov.event.services.mapper;


import eu.stefanangelov.event.persistence.entity.Event;
import eu.stefanangelov.common.kafka.dto.EventDTO;
import java.util.stream.Collectors;

public enum EventMapper {
    F;
    public EventDTO toDTO(Event event){
        var eventDTO = new EventDTO();
        eventDTO.setId(event.getId());
        eventDTO.setTitle(event.getTitle());
        eventDTO.setFrom(event.getAvailability().getFromDate());
        eventDTO.setTo(event.getAvailability().getToDate());
        eventDTO.setRoom(RoomMapper.F.toDTO(event.getRoom()));
        eventDTO.setParticipants(
            event.getParticipants().stream().map(UserMapper.F::toDTO).collect(Collectors.toList())
        );
        return eventDTO;
    }
}
