package com.meehdi.tutorial.service;

import com.meehdi.tutorial.config.EmailProperties;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final EmailProperties emailProperties;

    public EmailService(EmailProperties emailProperties) {
        this.emailProperties = emailProperties;
    }

    public String sendEmail(String to, String subject, String body) {
        String host = emailProperties.getSmtp().getHost();
        int port = emailProperties.getSmtp().getPort();
        String from = emailProperties.getFrom();

        // Simulate sending email
        return String.format(
                "Email sent!\nFrom: %s\nTo: %s\nSubject: %s\nSMTP: %s:%d",
                from, to, subject, host, port
        );
    }
}