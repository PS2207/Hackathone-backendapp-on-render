package com.lifeinweeks.backend.servicesImpl;


import com.lifeinweeks.backend.dtos.RegisterRequestDto;
import com.lifeinweeks.backend.entity.User;
import com.lifeinweeks.backend.exception.ResourceNotFoundException;
import com.lifeinweeks.backend.repo.UserRepo;
import com.lifeinweeks.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepository;

    @Override
    public User register(RegisterRequestDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setBirthDate(dto.getBirthDate());
        return userRepository.save(user);
    }

    @Override
    public Optional<User> login(String username, String password) {
        return userRepository.findByUsername(username)
                .filter(u -> u.getPassword().equals(password));
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}
