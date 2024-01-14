package com.example.kr.errors;

import org.springframework.http.HttpStatus;

/**
 * Represents a validation error response with an HTTP status and a corresponding error message.
 */
public class ValidationErrorResponse {

    /**
     * The HTTP status code of the response.
     */
    private HttpStatus status;

    /**
     * The error message associated with the response.
     */
    private String message;

    /**
     * Constructs a new ValidationErrorResponse with the specified HTTP status and error message.
     *
     * @param status  The HTTP status code of the response.
     * @param message The error message associated with the response.
     */
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
