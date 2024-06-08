package com.dauphine.event_management_backend.services.impl;

import com.dauphine.event_management_backend.dto.RegistrationRequest;
import com.dauphine.event_management_backend.models.Registration;
import com.dauphine.event_management_backend.services.RegistrationService;

import java.util.List;
import java.util.UUID;

public class RegistrationServiceImpl implements RegistrationService {
    @Override
    public List<Registration> retrieveAllRegistrations() {
        return List.of();
    }

    @Override
    public Registration retrieveFeedbackById(UUID id) {
        return null;
    }

    @Override
    public List<Registration> retrieveAllRegistrationByEventId(UUID id) {
        return List.of();
    }

    @Override
    public List<Registration> retrieveAllRegistrationByUserId(UUID id) {
        return List.of();
    }

    @Override
    public Registration createRegistration(RegistrationRequest registrationRequest) {
        return null;
    }

    @Override
    public void deleteRegistrationById(UUID id) {

    }
}
