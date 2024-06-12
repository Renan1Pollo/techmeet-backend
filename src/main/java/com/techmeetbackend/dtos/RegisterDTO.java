package com.techmeetbackend.dtos;

import com.techmeetbackend.domain.user.UserRole;

public record RegisterDTO(String name, String email, String password, UserRole role) {}
