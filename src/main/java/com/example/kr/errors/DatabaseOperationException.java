package com.example.kr.errors;

/**
 * Exception thrown when an operation on the database encounters an error.
 */
public class DatabaseOperationException extends RuntimeException {
    /**
     * Constructs a new DatabaseOperationException with the specified error message.
     *
     * @param message The detail message.
     */
    public DatabaseOperationException(String message) {
        super(message);
    }
}
