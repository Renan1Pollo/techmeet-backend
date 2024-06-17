package com.techmeetbackend.controllers;

import com.techmeetbackend.domain.event.Event;
import com.techmeetbackend.dtos.EventDTO;
import com.techmeetbackend.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        List<Event> users = this.eventService.getAllEvents();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
