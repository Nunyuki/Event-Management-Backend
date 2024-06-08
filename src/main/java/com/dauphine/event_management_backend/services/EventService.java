package com.dauphine.event_management_backend.services;

import com.dauphine.event_management_backend.dto.EventRequest;
import com.dauphine.event_management_backend.models.Category;
import com.dauphine.event_management_backend.models.Event;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface EventService {
    List<Event> retrieveAllEvents();
    Event retrieveEventById(UUID id);
    Event createEvent(EventRequest eventRequest);
    Event updateEvent(UUID id, EventRequest eventRequest);
    void deleteEventById(UUID id);
}
