package com.dauphine.event_management_backend.exceptions.eventusers;

public class PseudoAlreadyExistsException extends Exception {
    public PseudoAlreadyExistsException(String name){
        super("Already a user with the pseudo " + name + "exists !!!");
    }
}
