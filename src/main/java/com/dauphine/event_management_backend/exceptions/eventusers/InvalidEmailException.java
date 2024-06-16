package com.dauphine.event_management_backend.exceptions.eventusers;

public class InvalidEmailException extends Exception {
    public InvalidEmailException(){
        super("Invalid email address format !!!");
    }
}
