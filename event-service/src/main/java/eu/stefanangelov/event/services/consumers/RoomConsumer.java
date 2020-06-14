package eu.stefanangelov.event.services.consumers;

import static eu.stefanangelov.common.kafka.Topics.ROOM_EVENT;
import eu.stefanangelov.common.kafka.dto.RoomDTO;
import eu.stefanangelov.event.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoomConsumer {

    private final RoomService roomService;

    @KafkaListener(id = "RoomConsumer", topics = ROOM_EVENT , containerFactory = "runningListenerContainerFactory")
    public void listen(@Payload RoomDTO roomDTO){
        roomService.createUpdate(roomDTO);
    }
}
