package com.example.kr.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DatabaseOperationException.class)
    public ResponseEntity<String> handleDatabaseOperationException(DatabaseOperationException ex) {
        // Handle the exception and return an appropriate response
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing the request");
    }
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ValidationErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
    	Throwable rootCause = ex.getRootCause();
        String errorMessage = (rootCause != null) ? rootCause.getMessage() : ex.getMessage();
        
        return ResponseEntity.badRequest().body(new ValidationErrorResponse(HttpStatus.BAD_REQUEST, "Invalid request body: " + errorMessage));
    }
}
