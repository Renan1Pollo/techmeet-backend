package com.techmeetbackend.dtos;

import com.techmeetbackend.domain.user.User;

public record ResponseDTO (UserRole role, String token) { }
