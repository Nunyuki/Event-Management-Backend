package com.dauphine.event_management_backend.services;

import com.dauphine.event_management_backend.dto.RegistrationRequest;
import com.dauphine.event_management_backend.exceptions.registrations.RegistrationAlreadyExistsException;
import com.dauphine.event_management_backend.exceptions.registrations.RegistrationNotFoundByIdException;
import com.dauphine.event_management_backend.models.Registration;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface RegistrationService {
    Registration retrieveRegistrationById(UUID id) throws RegistrationNotFoundByIdException;
    List<Registration> retrieveAllRegistrationsByEventId(UUID id);
    List<Registration> retrieveAllRegistrationsByUserId(UUID eventUserId);
    Registration createRegistration(RegistrationRequest registrationRequest) throws RegistrationAlreadyExistsException;
    void deleteRegistrationById(UUID id) throws RegistrationNotFoundByIdException;
}
