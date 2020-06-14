package com.stefanangelov.authentication.services;

import com.stefanangelov.authentication.persistence.entity.Role;
import com.stefanangelov.authentication.persistence.entity.Role.RoleType;
import com.stefanangelov.authentication.persistence.entity.User;
import com.stefanangelov.authentication.persistence.repository.RoleRepository;
import com.stefanangelov.authentication.persistence.repository.UserRepository;
import com.stefanangelov.authentication.services.dto.JwtResponseDTO;
import com.stefanangelov.authentication.services.dto.LoginRequestDTO;
import com.stefanangelov.authentication.services.dto.SignupRequestDTO;
import com.stefanangelov.authentication.services.exception.UsernameAlreadyExist;
import com.stefanangelov.authentication.services.jwt.JwtUtils;
import eu.stefanangelov.common.kafka.Topics;
import eu.stefanangelov.common.kafka.dto.UserCreateDTO;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void signup(SignupRequestDTO createUserDto) {
        var role = roleRepository.findByName(RoleType.ROLE_CUSTOMER);
        if(userRepository.count() == 0){
            role = roleRepository.findByName(RoleType.ROLE_ADMIN);
        }
        if(userRepository.findByUsername(createUserDto.getUsername()).isPresent()){
         throw new UsernameAlreadyExist(String.format("Username %s already exist", createUserDto.getUsername()));
        }
        var user = new User(createUserDto.getUsername(), passwordEncoder.encode(createUserDto.getPassword()), createUserDto.getEmail(),
            Set.of(role));
        kafkaTemplate.send(Topics.USER_EVENT, new UserCreateDTO(user.getId(), user.getUsername()));
        userRepository.save(user);
    }

    public JwtResponseDTO signin(LoginRequestDTO loginRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new JwtResponseDTO(jwtUtils.generateJwtToken(authentication));
    }
}
