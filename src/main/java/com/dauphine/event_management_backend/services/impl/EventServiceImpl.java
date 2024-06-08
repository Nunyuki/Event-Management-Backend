package com.dauphine.event_management_backend.services.impl;

import com.dauphine.event_management_backend.dto.EventRequest;
import com.dauphine.event_management_backend.models.Category;
import com.dauphine.event_management_backend.models.Event;
import com.dauphine.event_management_backend.services.EventService;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class EventServiceImpl implements EventService {
    @Override
    public List<Event> retrieveAllEvents() {
        return List.of();
    }

    @Override
    public Event retrieveEventById(UUID id) {
        return null;
    }

    @Override
    public Event createEvent(EventRequest eventRequest) {
        return null;
    }

    @Override
    public Event updateEvent(UUID id, EventRequest eventRequest) {
        return null;
    }

    @Override
    public void deleteEventById(UUID id) {

    }
}
