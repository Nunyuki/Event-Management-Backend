package com.dauphine.event_management_backend.exceptions.eventusers;

import java.util.UUID;

public class UserNotFoundByIdException extends  Exception {
    public UserNotFoundByIdException(UUID id) {
        super("No user with the id : " + id + "have been found!!!");
    }
}