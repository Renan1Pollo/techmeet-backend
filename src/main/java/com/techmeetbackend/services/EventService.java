package com.techmeetbackend.services;

import com.techmeetbackend.domain.event.Event;
import com.techmeetbackend.dtos.EventDTO;
import com.techmeetbackend.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public List<Event> getAllEvents() {
        return this.repository.findAll();
    }

    public Event findEventById(Long id) throws Exception {
        return this.repository.findEventById(id).orElseThrow(() -> new Exception("Evento não encontrado"));
    }

    public Event createEvent(EventDTO data) {
        Event newEvent = new Event(data);
        this.repository.save(newEvent);
        return newEvent;
    }

    public Boolean deleteEventByName(String name) {
        Optional<List<Event>> eventsOptional = this.repository.findEventByName(name);

        if(eventsOptional.isPresent()) {
            List<Event> events = eventsOptional.get();
            repository.deleteById(events.get(0).getId());
            return true;
        }

        return false;
    }
}
