package com.example.kr.errors;

import org.springframework.http.HttpStatus;

public class ValidationErrorResponse {

    private HttpStatus status;
    private String message;

    // Constructors, getters, and setters

    public ValidationErrorResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
