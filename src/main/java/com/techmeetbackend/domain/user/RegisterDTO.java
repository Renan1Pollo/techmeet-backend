package com.techmeetbackend.domain.user;

public record RegisterDTO(String login, String password, UserRole role) {}
