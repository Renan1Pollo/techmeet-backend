package com.techmeetbackend.dtos;

public record EmailRequest(String toEmail, String subject, String body) {
}
