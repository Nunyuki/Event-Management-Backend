package com.dauphine.event_management_backend.exceptions.events;

public class EmptyDescriptionException extends Exception{
    public EmptyDescriptionException(){
        super("Event description is required !!");
    }
}
