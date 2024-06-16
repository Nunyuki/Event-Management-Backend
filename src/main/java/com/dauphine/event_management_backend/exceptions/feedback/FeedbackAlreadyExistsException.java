package com.dauphine.event_management_backend.exceptions.feedback;

public class FeedbackAlreadyExistsException extends Exception{
    public FeedbackAlreadyExistsException() {
        super("You've already give a feedback for this event !!!");
    }
}