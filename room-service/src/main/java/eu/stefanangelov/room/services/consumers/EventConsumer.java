package eu.stefanangelov.room.services.consumers;

import static eu.stefanangelov.common.kafka.Topics.CALENDAR_EVENT;

import eu.stefanangelov.room.services.RoomService;
import eu.stefanangelov.room.services.dto.CreateUpdateRoomDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EventConsumer {

    private final RoomService roomService;

    @KafkaListener(id = "EventConsumerRoom", topics = CALENDAR_EVENT)
    public void listen(@Payload CreateUpdateRoomDTO createUpdateRoomDTO){
        roomService.updateAvailability(createUpdateRoomDTO);
    }
}
