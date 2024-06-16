package com.dauphine.event_management_backend.exceptions.eventusers;

public class EmptyDataException extends Exception {
    public EmptyDataException(){
        super("All fields must be filled out !!!");
    }
}
