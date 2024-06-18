package com.dauphine.event_management_backend.services;

import com.dauphine.event_management_backend.dto.EventRequest;
import com.dauphine.event_management_backend.exceptions.events.*;
import com.dauphine.event_management_backend.exceptions.eventusers.UserNotFoundByIdException;
import com.dauphine.event_management_backend.models.Event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface EventService {
    List<Event> retrieveAllEvents();
    Event retrieveEventById(UUID id) throws EventNotFoundByIdException;
    Event createEvent(EventRequest eventRequest) throws EventAlreadyExistsException, EmptyDescriptionException;
    Event updateEvent(UUID id, EventRequest eventRequest) throws EventNotFoundByIdException;
    void deleteEventById(UUID id) throws EventNotFoundByIdException;
    List<Event> filterByString(String search,String filter) throws UserNotFoundByIdException;
    List<Event> findByCreatedBy(UUID createdBy);
}
