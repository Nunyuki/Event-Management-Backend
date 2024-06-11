package com.dauphine.event_management_backend.controllers;

import com.dauphine.event_management_backend.exceptions.categories.CategoryNameAlreadyExistsException;
import com.dauphine.event_management_backend.exceptions.categories.CategoryNotFoundByIdException;
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
    })

    public ResponseEntity<String> handlerNotFoundException(Exception e){
        logger.warn("[NOT FOUND] {}", e.getMessage());
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler({
            CategoryNameAlreadyExistsException.class
    })

    public ResponseEntity<String> handleBadRequestException(Exception e){
        return ResponseEntity.status(401).body(e.getMessage());
    }
}
