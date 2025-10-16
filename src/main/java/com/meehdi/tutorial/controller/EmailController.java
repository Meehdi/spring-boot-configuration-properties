package com.meehdi.tutorial.controller;

import com.meehdi.tutorial.service.EmailService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailRequest request) {
        return emailService.sendEmail(
                request.getTo(),
                request.getSubject(),
                request.getBody()
        );
    }

    @Data
    public static class EmailRequest {
        private String to;
        private String subject;
        private String body;
    }
}