package com.lifeinweeks.backend.controller;


import com.lifeinweeks.backend.dtos.LoginRequestDto;
import com.lifeinweeks.backend.dtos.RegisterRequestDto;
import com.lifeinweeks.backend.dtos.UserResponseDto;
import com.lifeinweeks.backend.entity.User;
import com.lifeinweeks.backend.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")//for frontend angular
@RestController
@RequestMapping("/api/user")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@Valid @RequestBody RegisterRequestDto dto) {
        User user = userService.register(dto);
        UserResponseDto response = new UserResponseDto(user.getId(), user.getUsername(), user.getEmail(), user.getBirthDate());
        return ResponseEntity.ok(response);
    }
/*
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDto dto) {
        return userService.login(dto.getUsername(), dto.getPassword())
                .map(user -> {
                    UserResponseDto response = new UserResponseDto(user.getId(), user.getUsername(), user.getEmail(), user.getBirthDate());
                    return ResponseEntity.ok(response);
                })
                .orElse(ResponseEntity.status(401).body("Invalid credentials"));
    }@PostMapping("/login")
    */
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDto dto) {
        return userService.login(dto.getUsername(), dto.getPassword())
                .<ResponseEntity<?>>map(user -> {
                    UserResponseDto response = new UserResponseDto(
                            user.getId(),
                            user.getUsername(),
                            user.getEmail(),
                            user.getBirthDate()
                    );
                    return ResponseEntity.ok(response);
                })
                .orElseGet(() -> ResponseEntity.status(401).body("Invalid credentials"));
    }


    
}


