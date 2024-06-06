package com.dauphine.event_management_backend.services.impl;

import com.dauphine.event_management_backend.models.EventUser;
import com.dauphine.event_management_backend.services.EventUserService;

import java.util.List;
import java.util.UUID;

public class EventUserServiceImpl implements EventUserService {
    @Override
    public EventUser retrieveUserById(UUID id) {
        return null;
    }

    @Override
    public List<EventUser> retrieveAllUsersByEventId(UUID id) {
        return List.of();
    }

    @Override
    public EventUser createUser(String username, String pseudo, String password, String email) {
        return null;
    }

    @Override
    public EventUser updateUser(UUID id, String pseudo, String password, String email) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }


}
