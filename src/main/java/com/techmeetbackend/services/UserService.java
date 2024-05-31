package com.techmeetbackend.services;

import com.techmeetbackend.domain.User;
import com.techmeetbackend.dtos.UserDTO;
import com.techmeetbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User findUserById(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }
    public User findUserByEmail(String email) throws Exception {
        return this.repository.findUserByEmail(email).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }

    public User createUser(UserDTO data){
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers(){
        return this.repository.findAll();
    }

    public void saveUser(User user){
        this.repository.save(user);
    }
}
