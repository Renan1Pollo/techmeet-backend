package com.techmeetbackend.domain.user;

import com.techmeetbackend.dtos.RegisterRequestDTO;
import com.techmeetbackend.dtos.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public User (RegisterRequestDTO data) {
        this.email = data.email();
        this.name = data.name();
        this.password = data.password();
        this.role = data.role();
    }
}
