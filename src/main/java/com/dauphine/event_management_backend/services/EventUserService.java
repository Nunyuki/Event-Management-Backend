package com.dauphine.event_management_backend.services;

import com.dauphine.event_management_backend.models.EventUser;

import java.util.List;
import java.util.UUID;

public interface EventUserService {
    EventUser retrieveUserById(UUID id);
    List<EventUser> retrieveAllUsersByEventId(UUID id);
    EventUser createUser(String username, String pseudo, String password, String email);
    EventUser updateUser(UUID id, String pseudo, String password, String email);
    void deleteById(UUID id);
}
