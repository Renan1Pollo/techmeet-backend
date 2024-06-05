package com.techmeetbackend.domain.user;

public record RegisterDTO(String email, String password, UserRole role) {}
