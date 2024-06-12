package com.techmeetbackend.domain.event;

import com.techmeetbackend.dtos.EventDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="events")
@Table(name="events")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "date", nullable = false)
    private String date;

    public Event(EventDTO data) {
        this.name = data.name();
        this.description = data.description();
        this.state = data.state();
        this.image = data.image();
        this.date = data.date();
    }
}
