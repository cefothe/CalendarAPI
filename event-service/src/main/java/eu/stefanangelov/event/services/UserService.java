package eu.stefanangelov.event.services;

import eu.stefanangelov.common.kafka.dto.UserCreateDTO;
import eu.stefanangelov.event.persistence.entity.User;
import eu.stefanangelov.event.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    public final UserRepository userRepository;

    @Transactional
    public void createOrUpdate(UserCreateDTO userCreateDTO) {
        userRepository.findById(userCreateDTO.getId())
            .ifPresentOrElse(user -> {
                user.setUsername(user.getUsername());
                userRepository.save(user);
            },()->{
                var user = new User(userCreateDTO.getId(),userCreateDTO.getUsername());
                userRepository.save(user);
            });
    }
}
