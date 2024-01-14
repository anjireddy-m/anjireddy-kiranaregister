package com.example.kr.errors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for handling various exceptions across the application.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Handles exceptions related to database operations and returns an internal server error response.
     *
     * @param ex The DatabaseOperationException that occurred.
     * @return ResponseEntity with an internal server error status and a generic error message.
     */
    @ExceptionHandler(DatabaseOperationException.class)
    public ResponseEntity<String> handleDatabaseOperationException(DatabaseOperationException ex) {
        logger.error("Database operation failed", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing the request");
    }

    /**
     * Handles exceptions related to HTTP message not being readable and returns a bad request response
     * with a custom error message indicating the reason for the failure.
     *
     * @param ex The HttpMessageNotReadableException that occurred.
     * @return ResponseEntity with a bad request status and a custom error response.
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ValidationErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        logger.error("Invalid request body", ex);

        Throwable rootCause = ex.getRootCause();
        String errorMessage = (rootCause != null) ? rootCause.getMessage() : ex.getMessage();

        return ResponseEntity.badRequest().body(new ValidationErrorResponse(HttpStatus.BAD_REQUEST, "Invalid request body: " + errorMessage));
    }
}
