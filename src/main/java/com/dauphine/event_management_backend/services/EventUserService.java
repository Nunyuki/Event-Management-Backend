package com.dauphine.event_management_backend.services;

import com.dauphine.event_management_backend.dto.EventUserRequest;
import com.dauphine.event_management_backend.models.EventUser;

import java.util.List;
import java.util.UUID;

public interface EventUserService {
    EventUser retrieveUserById(UUID id);
    List<EventUser> retrieveAllUsersByEventId(UUID id);
    EventUser createUser(EventUserRequest eventUserRequest);
    EventUser updateUser(UUID id, EventUserRequest eventUserRequest);
    void deleteUserById(UUID id);
    EventUser authenticateUser(String pseudo, String password);
}
