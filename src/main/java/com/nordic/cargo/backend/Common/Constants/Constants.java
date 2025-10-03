package com.nordic.cargo.backend.Common.Constants;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Constants {

    @Value("${email.user}")
    private String email;

    public static String username;

    /**
     * Initializes the username field with the injected email value.
     * This method is annotated with @PostConstruct, meaning it will be called after the bean has been initialized.
     */
    @PostConstruct
    public void init() {
        username = email; // now it’s initialized after injection
    }
}