package com.techmeetbackend.dtos;

public record RegisterRequestDTO (String name, String email, String password, UserRole role) {
}
