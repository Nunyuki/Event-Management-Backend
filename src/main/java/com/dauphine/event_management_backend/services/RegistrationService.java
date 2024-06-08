package com.dauphine.event_management_backend.services;

import com.dauphine.event_management_backend.dto.RegistrationRequest;
import com.dauphine.event_management_backend.models.Registration;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface RegistrationService {
    List<Registration> retrieveAllRegistrations();
    Registration retrieveFeedbackById(UUID id);
    List<Registration> retrieveAllRegistrationByEventId(UUID id);
    List<Registration> retrieveAllRegistrationByUserId(UUID id);
    Registration createRegistration(RegistrationRequest registrationRequest);
    void deleteRegistrationById(UUID id);
}
