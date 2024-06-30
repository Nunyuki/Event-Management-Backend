package com.dauphine.event_management_backend.services;

import com.dauphine.event_management_backend.dto.EventUserRequest;
import com.dauphine.event_management_backend.exceptions.events.EventNotFoundByIdException;
import com.dauphine.event_management_backend.exceptions.eventusers.*;
import com.dauphine.event_management_backend.models.EventUser;

import java.util.List;
import java.util.UUID;

public interface EventUserService {
    EventUser retrieveUserById(UUID id) throws UserNotFoundByIdException;
    EventUser createUser(EventUserRequest eventUserRequest) throws InvalidEmailException, PseudoAlreadyExistsException, EmptyDataException;
    EventUser updateUser(UUID id, EventUserRequest eventUserRequest) throws EmptyDataException, UserNotFoundByIdException;
    void deleteUserById(UUID id) throws UserNotFoundByIdException;
    EventUser authenticateUser(String pseudo, String password) throws AuthenticationException;
    List<EventUser> retrieveAllUsers();
    List<EventUser> retrieveAllUsersByEventId(UUID eventId) throws UserNotFoundByIdException;

}
