package com.springapp.StudentPortalSpring.exception.authentication;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class InvalidCredentialsException extends Exception {
    private static final long serialVersionUID =1L;

    public InvalidCredentialsException(String message) {
        super(message);
    }
}