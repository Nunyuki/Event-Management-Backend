package com.dauphine.event_management_backend.exceptions.registrations;

import java.util.UUID;

public class RegistrationNotFoundByIdException extends  Exception {
    public RegistrationNotFoundByIdException(UUID id) {
        super("No registration with the id : " + id + "have been found!!!");
    }
}