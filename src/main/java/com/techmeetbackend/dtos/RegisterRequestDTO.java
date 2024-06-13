package com.techmeetbackend.dtos;

import com.techmeetbackend.domain.user.UserRole;

public record RegisterRequestDTO (String name, String email, String password, UserRole userRole) { }
