package com.lifeinweeks.backend.services;

import com.lifeinweeks.backend.dtos.RegisterRequestDto;
import com.lifeinweeks.backend.entity.User;

import java.util.Optional;

public interface UserService {
    User register(RegisterRequestDto dto);
    Optional<User> login(String username, String password);
    Optional<User> getUserById(Long id);
}
