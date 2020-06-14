package com.stefanangelov.authentication.services.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class LoginRequestDTO {
    private String username;
    private String password;
}
