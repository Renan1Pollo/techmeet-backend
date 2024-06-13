package com.techmeetbackend.controllers;


import com.techmeetbackend.dtos.LoginRequestDTO;
import com.techmeetbackend.dtos.LoginResponseDTO;
import com.techmeetbackend.dtos.RegisterRequestDTO;
import com.techmeetbackend.domain.user.User;
import com.techmeetbackend.services.TokenService;

import com.techmeetbackend.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginRequestDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO data) {
        if (this.userService.findUserByEmail(data.email()) != null) return ResponseEntity.badRequest().build();
        this.userService.createUser(new RegisterRequestDTO(data.name(), data.email(), data.password(), data.userRole()));

        return ResponseEntity.ok().build();
    }
}
