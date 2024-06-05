package com.dauphine.event_management_backend.services;

import com.dauphine.event_management_backend.models.Event;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface EventService {
    List<Event> retrieveAllEvents();
    Event retrieveEventById(UUID id);
    Event createEvent(String EventName, UUID createdBy, UUID categoryId, Date eventDate, Time eventTime, String eventLocation, String eventDescription);
    Event updateEvent(UUID id, String eventName, Date eventDate, Time eventTime, String eventLocation, String eventDescription);
    void deleteById(UUID id);
}
