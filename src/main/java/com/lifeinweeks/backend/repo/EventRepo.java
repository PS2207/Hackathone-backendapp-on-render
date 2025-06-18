package com.lifeinweeks.backend.repo;

import com.lifeinweeks.backend.entity.Event;
import com.lifeinweeks.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepo extends JpaRepository<Event, Long> {
    List<Event> findByUser(User user);
}
