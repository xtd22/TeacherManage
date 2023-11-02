package com.example.teachermanage.exception;

public class TokenIsEmptyException extends RuntimeException{
    public TokenIsEmptyException() {
        super();
    }

    public TokenIsEmptyException(String message) {
        super(message);
    }
}
