package com.example.eclipseparking.exception;

public class InvalidAddressException extends RuntimeException{
    public InvalidAddressException(String message) {
            super(message);
    }
}
