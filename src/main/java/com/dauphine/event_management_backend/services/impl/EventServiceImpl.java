package com.dauphine.event_management_backend.services.impl;

import com.dauphine.event_management_backend.dto.EventRequest;
import com.dauphine.event_management_backend.exceptions.events.*;
import com.dauphine.event_management_backend.exceptions.eventusers.UserNotFoundByIdException;
import com.dauphine.event_management_backend.models.Event;
import com.dauphine.event_management_backend.repositories.CategoryRepository;
import com.dauphine.event_management_backend.repositories.EventRepository;
import com.dauphine.event_management_backend.services.EventService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> retrieveAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event retrieveEventById(UUID id) throws EventNotFoundByIdException{
        return eventRepository.findById(id).orElseThrow(() -> new EventNotFoundByIdException(id));

    }

    @Override
    public Event createEvent(EventRequest eventRequest) throws EventAlreadyExistsException, EmptyDescriptionException {
        if(eventRequest.getEventDescription().trim().isEmpty()){
            throw new EmptyDescriptionException();
        }
        if(!eventRepository.findEvent(eventRequest.getCreatedBy(),eventRequest.getEventDate(),eventRequest.getCategoryName(),eventRequest.getEventLocation(),eventRequest.getEventDescription(),eventRequest.getMaxCapacity(),eventRequest.getImage()).isEmpty()) {
            throw new EventAlreadyExistsException();
        }
        Event event = new Event(eventRequest.getEventName(),eventRequest.getCreatedBy(), LocalDateTime.now(),eventRequest.getCategoryName(),eventRequest.getEventDate(),eventRequest.getEventLocation(),eventRequest.getEventDescription(),eventRequest.getMaxCapacity(),eventRequest.getImage());
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(UUID id, EventRequest eventRequest) throws EventNotFoundByIdException {
        Event event = retrieveEventById(id);
        event.setAll(eventRequest.getEventName(), eventRequest.getCategoryName(), eventRequest.getEventDate(),eventRequest.getEventLocation(),eventRequest.getEventDescription(),eventRequest.getMaxCapacity(),eventRequest.getImage());
        return eventRepository.save(event);
    }

    @Override
    public void deleteEventById(UUID id) throws EventNotFoundByIdException {
        retrieveEventById(id);
        eventRepository.deleteById(id);
    }

    @Override
    public List<Event> findByCreatedBy(UUID creator){
        return eventRepository.findByCreatedBy(creator);
    }

    @Override
    public List<Event> filterByString(String search,String filter) throws UserNotFoundByIdException {
        return switch (filter) {
            case "category" -> eventRepository.findByCategoryName(search);
            case "eventName" -> eventRepository.findByEventName(search);
            case "location" -> eventRepository.findByLocation(search);
            case "description" -> eventRepository.findByDescription(search);
            case "creator" -> {
                UUID creator = eventRepository.findCreator(search);
                yield findByCreatedBy(creator);
            }
            default -> eventRepository.searchEvents(search, search, search, search);
        };
    }

    @Override
    public List<Event> filterByDate() {
        return eventRepository.filterByDate();
    }
}
