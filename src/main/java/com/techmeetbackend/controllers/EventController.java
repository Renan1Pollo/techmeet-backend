package com.techmeetbackend.controllers;

import com.techmeetbackend.domain.event.Event;
import com.techmeetbackend.dtos.EventDTO;
import com.techmeetbackend.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody EventDTO event) {
        Event newEvent = eventService.createEvent(event);
        return new ResponseEntity<>(newEvent, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents(){
        List<Event> events = this.eventService.getAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<?> deleteEventByName(@PathVariable String name) {
        Boolean isDeleted  = this.eventService.deleteEventByName(name);
        if (isDeleted) return ResponseEntity.noContent().build();
        else return ResponseEntity.status(404).body("Event not found");
    }
}

