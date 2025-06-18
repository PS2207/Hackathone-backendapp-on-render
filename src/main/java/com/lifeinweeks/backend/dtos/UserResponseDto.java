package com.lifeinweeks.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String username;
    private String email;
    private LocalDate birthDate;
}
