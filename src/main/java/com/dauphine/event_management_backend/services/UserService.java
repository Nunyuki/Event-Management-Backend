package com.dauphine.event_management_backend.services;

import com.dauphine.event_management_backend.models.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User retrieveUserById(UUID id);
    List<User> retrieveAllUsersByEventId(UUID id);
    User createUser(String username, String pseudo, String password, String email);
    User updateUser(UUID id, String pseudo, String password, String email);
    void deleteById(UUID id);
}
