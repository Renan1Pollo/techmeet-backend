package com.techmeetbackend.services;

import com.techmeetbackend.domain.event.Event;
import com.techmeetbackend.dtos.EventDTO;
import com.techmeetbackend.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public Event findEventById(Long id ) throws Exception {
        return this.repository.findEventById(id).orElseThrow(() -> new Exception("Evento não encontrado"));
    }

    public Event createEvent(EventDTO data) {
        Event newEvent = new Event(data);
        this.repository.save(newEvent);
        return newEvent;
    }
}
