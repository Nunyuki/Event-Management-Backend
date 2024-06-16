package com.dauphine.event_management_backend.controllers.handlers;

import com.dauphine.event_management_backend.exceptions.categories.*;
import com.dauphine.event_management_backend.exceptions.events.*;
import com.dauphine.event_management_backend.exceptions.eventusers.*;
import com.dauphine.event_management_backend.exceptions.feedback.*;
import com.dauphine.event_management_backend.exceptions.registrations.RegistrationAlreadyExistsException;
import com.dauphine.event_management_backend.exceptions.registrations.RegistrationNotFoundByIdException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    @ExceptionHandler({
            CategoryNotFoundByIdException.class,
            UserNotFoundByIdException.class,
            EventAlreadyExistsException.class,
            FeedbackNotFoundByIdException.class,
            RegistrationNotFoundByIdException.class
    })

    public ResponseEntity<String> handlerNotFoundException(Exception e){
        logger.warn("[NOT FOUND] {}", e.getMessage());
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler({
            CategoryNameAlreadyExistsException.class,
            AuthenticationException.class,
            EmptyDataException.class,
            PseudoAlreadyExistsException.class,
            InvalidEmailException.class,
            EventNotFoundByIdException.class,
            EmptyDescriptionException.class,
            EmptyFeedbackCommentException.class,
            FeedbackAlreadyExistsException.class,
            RegistrationAlreadyExistsException.class
    })

    public ResponseEntity<String> handleBadRequestException(Exception e){
        return ResponseEntity.status(400).body(e.getMessage());
    }
}
