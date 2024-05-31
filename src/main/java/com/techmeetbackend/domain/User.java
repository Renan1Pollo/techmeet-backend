package com.techmeetbackend.domain;

import com.techmeetbackend.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="users")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;
    private String email;
    private Boolean isAdmin;

    public User(UserDTO data){
        this.name = data.name();
        this.password = data.password();
        this.email = data.email();
    }
}
