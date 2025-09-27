package com.nordic.cargo.backend.Common.Constants;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Constants {

    @Value("${email.user}")
    private String email;

    public static String username;

    @PostConstruct
    public void init() {
        username = email; // now it’s initialized after injection
    }
}

