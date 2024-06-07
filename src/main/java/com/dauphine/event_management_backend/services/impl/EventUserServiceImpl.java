package com.dauphine.event_management_backend.services.impl;

import com.dauphine.event_management_backend.config.SecurityConfig;
import com.dauphine.event_management_backend.dto.EventUserRequest;
import com.dauphine.event_management_backend.models.EventUser;
import com.dauphine.event_management_backend.repositories.EventUserRepository;
import com.dauphine.event_management_backend.services.EventUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EventUserServiceImpl implements EventUserService {
    private final EventUserRepository eventUserRepository;

    public EventUserServiceImpl(EventUserRepository eventUserRepository) {
        this.eventUserRepository = eventUserRepository;
    }

    @Override
    public EventUser retrieveUserById(UUID id) {
        return null;
    }

    @Override
    public List<EventUser> retrieveAllUsersByEventId(UUID id) {
        return List.of();
    }

    @Override
    public EventUser createUser(EventUserRequest eventUserRequest) {

        if(eventUserRepository.findByUsername(eventUserRequest.getPseudo()) != null){
            return null;
        }

        String encodedPassword = SecurityConfig.hashPassword((eventUserRequest.getPassword()));
        EventUser eventUser = new EventUser(UUID.randomUUID(), eventUserRequest.getUsername(), eventUserRequest.getPseudo(), encodedPassword, eventUserRequest.getEmail());
        return eventUserRepository.save(eventUser);
    }

    @Override
    public EventUser updateUser(UUID id, EventUserRequest eventUserRequest) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }


}
