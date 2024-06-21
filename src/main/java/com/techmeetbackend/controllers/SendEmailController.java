package com.techmeetbackend.controllers;

import com.techmeetbackend.dtos.EmailRequest;
import com.techmeetbackend.services.SendEmailService;
import com.techmeetbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/sendEmail")
public class SendEmailController {

    @Autowired
    private SendEmailService emailService;

    @PostMapping
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest requestBody) {
        Boolean isSended = this.emailService.sendEmail(requestBody.toEmail(), requestBody.subject(), requestBody.subject());
        if (isSended) return ResponseEntity.ok("Email sent successfully!");
        else return ResponseEntity.badRequest().build();
    }
}
