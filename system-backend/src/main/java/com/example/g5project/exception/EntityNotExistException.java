package com.example.g5project.exception;

public class EntityNotExistException extends Exception {

    public EntityNotExistException(){

    }

    public EntityNotExistException(String msg) {
        super(msg);
    }

}
