package eu.stefanangelov.event.services.consumers;
import static eu.stefanangelov.common.kafka.Topics.USER_EVENT;

import eu.stefanangelov.common.kafka.dto.UserCreateDTO;
import eu.stefanangelov.event.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserConsumer {

    private final UserService userService;

    @KafkaListener(id = "UserConsumer", topics = USER_EVENT, containerFactory = "runningListenerContainerFactory")
    public void listen(@Payload UserCreateDTO userCreateDTO){
        userService.createOrUpdate(userCreateDTO);
    }
}
