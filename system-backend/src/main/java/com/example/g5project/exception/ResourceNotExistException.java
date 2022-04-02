package com.example.g5project.exception;

public class ResourceNotExistException extends Exception {
    public ResourceNotExistException() {
    }

    public ResourceNotExistException(String msg){
        super(msg);
    }
}
