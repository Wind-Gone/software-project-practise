package com.example.g5project.exception;

public class EntitySoftDeleteException extends Exception {

    public EntitySoftDeleteException(){

    }

    public EntitySoftDeleteException(String msg) {
        super(msg);
    }

}
