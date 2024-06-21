package com.techmeetbackend.repositories;

import com.techmeetbackend.domain.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<Event> findEventById(Long id);
    Optional<List<Event>> findEventByName(String name);
}

