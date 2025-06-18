package com.lifeinweeks.backend.services;

import com.lifeinweeks.backend.dtos.EventDto;
import com.lifeinweeks.backend.entity.Event;

import java.util.List;

public interface EventService {
    Event createEvent(Long userId, EventDto dto);
    List<Event> getEventsByUser(Long userId);
    Event updateEvent(Long eventId, EventDto dto);
    void deleteEvent(Long userId, Long eventId);
}
