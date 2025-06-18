package com.lifeinweeks.backend.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lifeinweeks.backend.dtos.EventDto;
import com.lifeinweeks.backend.entity.Event;
import com.lifeinweeks.backend.services.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")//for frontend angular
@RestController
@RequestMapping("/api/event")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/user/{userId}/create")
    public ResponseEntity<Event> create(@PathVariable Long userId, @Valid @RequestBody EventDto dto) {
        return ResponseEntity.ok(eventService.createEvent(userId, dto));
    }

    @GetMapping("/user/{userId}/getAll")
    public ResponseEntity<List<Event>> getAll(@PathVariable Long userId) {
        return ResponseEntity.ok(eventService.getEventsByUser(userId));
    }
    /*
    @PutMapping("/{eventId}")
    public ResponseEntity<Event> update(@PathVariable Long eventId, @Valid @RequestBody EventDto dto) {
        return ResponseEntity.ok(eventService.updateEvent(eventId, dto));
    }
    */
    @PutMapping("/{eventId}")
    public ResponseEntity<EventDto> update(@PathVariable Long eventId, @Valid @RequestBody EventDto dto) {
        Event updatedEvent = eventService.updateEvent(eventId, dto);

        EventDto responseDto = new EventDto(
            updatedEvent.getTitle(),
            updatedEvent.getCategory(),
            updatedEvent.getDescription(),
            updatedEvent.getDate()
        );

        return ResponseEntity.ok(responseDto);
    }
   


    @DeleteMapping("/user/{userId}/{eventId}/delete")
    public ResponseEntity<?> delete(@PathVariable Long userId, @PathVariable Long eventId) {
        eventService.deleteEvent(userId, eventId);
        return ResponseEntity.ok("Event deleted successfully");
    }
}

