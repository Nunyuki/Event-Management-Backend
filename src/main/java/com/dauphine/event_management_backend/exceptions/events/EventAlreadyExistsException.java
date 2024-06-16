package com.dauphine.event_management_backend.exceptions.events;

public class EventAlreadyExistsException extends Exception {
    public EventAlreadyExistsException(){
        super("You've already create the same event !!!");
    }
}
