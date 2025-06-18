package com.lifeinweeks.backend.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lifeinweeks.backend.entity.User;

public interface UserRepo extends JpaRepository<User,Long>{
	Optional<User> findByUsername(String username);
	Optional<User> findByEmail(String email);
}

