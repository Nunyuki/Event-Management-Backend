package com.dauphine.event_management_backend.services.impl;

import com.dauphine.event_management_backend.dto.RegistrationRequest;
import com.dauphine.event_management_backend.exceptions.registrations.RegistrationAlreadyExistsException;
import com.dauphine.event_management_backend.exceptions.registrations.RegistrationNotFoundByIdException;
import com.dauphine.event_management_backend.models.Registration;
import com.dauphine.event_management_backend.repositories.RegistrationRepository;
import com.dauphine.event_management_backend.services.RegistrationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    private final RegistrationRepository registrationRepository;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @Override
    public Registration retrieveRegistrationById(UUID id) throws RegistrationNotFoundByIdException{
        return registrationRepository.findById(id).orElseThrow(() -> new RegistrationNotFoundByIdException(id));
    }

    @Override
    public List<Registration> retrieveAllRegistrationsByEventId(UUID eventId) {
        return registrationRepository.findAllByEventId(eventId);
    }

    @Override
    public List<Registration> retrieveAllRegistrationsByUserId(UUID eventUserId) {
        return registrationRepository.findAllByEventUserId(eventUserId);
    }

    @Override
    public Registration createRegistration(RegistrationRequest registrationRequest) throws RegistrationAlreadyExistsException {
        if (registrationRepository.findByEventIdAndEventUserId(registrationRequest.getEventId(), registrationRequest.getUserId()) != null) {
            throw new RegistrationAlreadyExistsException(registrationRequest.getEventId());
        }
        Registration registration = new Registration(registrationRequest.getEventId(), registrationRequest.getUserId());
        return registrationRepository.save(registration);
    }

    @Override
    public void deleteRegistrationById(UUID id) throws RegistrationNotFoundByIdException {
        retrieveRegistrationById(id);
        registrationRepository.deleteById(id);
    }
}
