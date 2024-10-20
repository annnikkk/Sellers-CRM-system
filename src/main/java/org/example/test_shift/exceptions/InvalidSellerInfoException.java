package org.example.test_shift.exceptions;

public class InvalidSellerInfoException extends RuntimeException {
    public InvalidSellerInfoException(String message) {
        super(message);
    }
}