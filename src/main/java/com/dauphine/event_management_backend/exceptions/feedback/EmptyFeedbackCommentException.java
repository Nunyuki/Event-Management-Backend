package com.dauphine.event_management_backend.exceptions.feedback;

public class EmptyFeedbackCommentException extends Exception{
    public EmptyFeedbackCommentException(){
        super("Feedback comment is required !!!");
    }
}
