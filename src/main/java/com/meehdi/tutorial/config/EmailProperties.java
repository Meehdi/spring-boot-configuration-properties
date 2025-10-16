package com.meehdi.tutorial.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@ConfigurationProperties(prefix = "email")
@Validated
@Data
public class EmailProperties {

    @NotBlank(message = "From address is required")
    private String from;

    @Valid
    private Smtp smtp = new Smtp();

    @Data
    public static class Smtp {
        @NotBlank(message = "SMTP host is required")
        private String host;

        @Min(1)
        @Max(65535)
        private int port = 587;

        @NotBlank
        private String username;

        @NotBlank
        private String password;
    }
}