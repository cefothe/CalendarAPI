package com.stefanangelov.authentication.services;


import com.stefanangelov.authentication.persistence.entity.User;
import com.stefanangelov.authentication.persistence.repository.UserRepository;
import com.stefanangelov.authentication.services.dto.UserDTO;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException(String.format("User with username %s not found", username)));
    }

    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream()
            .map(user -> new UserDTO(UUID.fromString(user.getId()), user.getUsername()))
            .collect(Collectors.toList());
    }
}
