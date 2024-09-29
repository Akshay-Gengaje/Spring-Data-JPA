package com.akshay.jpa.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class AuthorExceptionHandler {

    // Handle DataIntegrityViolationException (e.g., for unique email constraint violations)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        // Check if it's a duplicate email violation
        String errorMessage = "Database error";

        if (ex.getMessage().contains("author.email")) {
            errorMessage = "Email already exists! Please use a different email.";
        }

        Map<String, String> response = new HashMap<>();
        response.put("error", errorMessage);

        return new ResponseEntity<>(response, HttpStatus.CONFLICT); // 409 Conflict
    }

    // Handle generic exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "An unexpected error occurred: " + ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); // 500 Internal Server Error
    }
}
