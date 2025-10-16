package com.meehdi.tutorial.service;

import com.meehdi.tutorial.config.EmailProperties;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailServiceTest {

    @Test
    void shouldSendEmailWithConfiguration() {
        EmailProperties props = new EmailProperties();
        props.setFrom("test@example.com");
        props.getSmtp().setHost("localhost");
        props.getSmtp().setPort(1025);
        props.getSmtp().setUsername("testuser");
        props.getSmtp().setPassword("testpass");

        EmailService service = new EmailService(props);

        assertDoesNotThrow(() -> {
            service.sendEmail("recipient@example.com", "Test", "Hello");
        });
    }
}