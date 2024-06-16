package com.dauphine.event_management_backend.exceptions.registrations;

import java.util.UUID;

public class RegistrationAlreadyExistsException extends Exception{

    public RegistrationAlreadyExistsException(UUID event_id) {
        super("You've already been register for this event !!!\" " + event_id);
    }

}
