package com.example.g5project.exception;

public class ForeignKeyException extends RuntimeException {
    public ForeignKeyException() {
    }

    public ForeignKeyException(String msg) {
        super(msg);
    }
}
