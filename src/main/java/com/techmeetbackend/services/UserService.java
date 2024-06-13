package com.techmeetbackend.services;

import com.techmeetbackend.dtos.RegisterRequestDTO;
import com.techmeetbackend.domain.user.User;
import com.techmeetbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User findUserById(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }

    public UserDetails findUserByEmail(String email) {
        return this.repository.findUserByEmail(email);
    }

    public User createUser(RegisterRequestDTO data) {
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers() {
        List<User> list = this.repository.findAll();
        return list;
    }

    public void saveUser(User user) {
        this.repository.save(user);
    }
}
