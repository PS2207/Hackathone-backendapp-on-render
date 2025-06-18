package com.lifeinweeks.backend.servicesImpl;


import com.lifeinweeks.backend.dtos.EventDto;
import com.lifeinweeks.backend.entity.Event;
import com.lifeinweeks.backend.entity.User;
import com.lifeinweeks.backend.exception.ResourceNotFoundException;
import com.lifeinweeks.backend.repo.EventRepo;
import com.lifeinweeks.backend.repo.UserRepo;
import com.lifeinweeks.backend.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepo eventRepository;

    @Autowired
    private UserRepo userRepository;

    @Override
    public Event createEvent(Long userId, EventDto dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        Event event = new Event();
        event.setTitle(dto.getTitle());
        event.setCategory(dto.getCategory());
        event.setDescription(dto.getDescription());
        event.setDate(dto.getDate());
        event.setUser(user);

        return eventRepository.save(event);
    }

    @Override
    public List<Event> getEventsByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        return eventRepository.findByUser(user);
    }

    @Override
    public Event updateEvent(Long eventId, EventDto dto) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + eventId));

        event.setTitle(dto.getTitle());
        event.setCategory(dto.getCategory());
        event.setDescription(dto.getDescription());
        event.setDate(dto.getDate());
        return eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long userId, Long eventId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + eventId));

        if (!event.getUser().getId().equals(user.getId())) {
            throw new ResourceNotFoundException("Event does not belong to the specified user");
        }
        eventRepository.delete(event);
    }
}
