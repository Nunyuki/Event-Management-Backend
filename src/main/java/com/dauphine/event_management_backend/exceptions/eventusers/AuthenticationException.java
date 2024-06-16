package com.dauphine.event_management_backend.exceptions.eventusers;

public class AuthenticationException extends Exception {
    public AuthenticationException(){
        super("Incorrect pseudo or password !!!");
    }
}
