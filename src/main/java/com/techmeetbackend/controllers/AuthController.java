package com.techmeetbackend.controllers;

import com.techmeetbackend.dtos.ResponseDTO;
import com.techmeetbackend.domain.user.User;
import com.techmeetbackend.dtos.RegisterRequestDTO;
import com.techmeetbackend.dtos.LoginRequestDTO;
import com.techmeetbackend.infra.security.TokenService;
import com.techmeetbackend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body) {
        Optional<User> userOptional = this.userService.findUserByEmail(body.email());

        if (userOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("User not found");
        }

        User user = userOptional.get();
        if (passwordEncoder.matches(body.password(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getRole(), token));
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO data) {
        Optional<User> user = this.userService.findUserByEmail(data.email());

        if (!user.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        User newUser = new User(data);
        newUser.setPassword(passwordEncoder.encode(data.password()));
        this.userService.saveUser(newUser);

        String token = this.tokenService.generateToken(newUser);
        return ResponseEntity.ok(new ResponseDTO(newUser.getRole(), token));
    }
}
