package com.techmeetbackend.repositories;

import com.techmeetbackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserById(Long id);
    Optional<User> findUserByEmail(String document);
}
