package com.stefanangelov.authentication.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class JwtResponseDTO {
    private String token;
}
