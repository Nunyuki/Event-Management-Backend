package com.dauphine.event_management_backend.exceptions.events;

import java.util.UUID;

public class EventNotFoundByIdException extends  Exception {
    public EventNotFoundByIdException(UUID id) {
        super("No event with the id : " + id + "have been found!!!");
    }
}