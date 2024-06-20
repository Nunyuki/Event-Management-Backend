package com.dauphine.event_management_backend.controllers;

import com.dauphine.event_management_backend.dto.CategoryRequest;
import com.dauphine.event_management_backend.dto.EventRequest;
import com.dauphine.event_management_backend.exceptions.categories.CategoryNameAlreadyExistsException;
import com.dauphine.event_management_backend.exceptions.categories.CategoryNotFoundByIdException;
import com.dauphine.event_management_backend.exceptions.events.EmptyDescriptionException;
import com.dauphine.event_management_backend.exceptions.events.EventAlreadyExistsException;
import com.dauphine.event_management_backend.exceptions.events.EventNotFoundByIdException;
import com.dauphine.event_management_backend.exceptions.eventusers.UserNotFoundByIdException;
import com.dauphine.event_management_backend.models.Category;
import com.dauphine.event_management_backend.models.Event;
import com.dauphine.event_management_backend.services.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @Operation(
            summary = "Retrieve all events",
            description = "Return all events"
    )
    @GetMapping
    public ResponseEntity<List<Event>> retrieveAllEvents() {
        List<Event> events = eventService.retrieveAllEvents();
        return ResponseEntity.ok(events);
    }

    @PostMapping
    @Operation(
            summary = "Create a new event",
            description = "Create a new event by setting (event name, category name, date, location, description, capacity, image)"
    )
    public ResponseEntity<?> createEvent(
            @Parameter(description = "Request which contains the data of the new event")
            @RequestBody EventRequest eventRequest) throws EmptyDescriptionException, EventAlreadyExistsException {

        Event event = eventService.createEvent(eventRequest);
        return ResponseEntity
                .created(URI.create("events/"+event.getId()))
                .body(event);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update the data of an event",
            description = "Update event data by path variable 'id' and request body 'eventRequest'"
    )
    public ResponseEntity<Event> updateEvent(
            @Parameter(description = "Id of the event to updated")
            @PathVariable UUID id,
            @Parameter(description = "Request which contains new data of the event")
            @RequestBody EventRequest eventRequest) throws EventNotFoundByIdException {

        Event event = eventService.updateEvent(id,eventRequest);
        return ResponseEntity.ok(event);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Retrieve a event by his id",
            description = "Return a event by path variable 'id'"
    )
    public ResponseEntity<Event> retrieveEventById(
            @Parameter(description = "Id of the event to retrieve")
            @PathVariable UUID id) throws EventNotFoundByIdException {
        Event event = eventService.retrieveEventById(id);
        return ResponseEntity.ok(event);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete event by his id",
            description = "Delete event by path variable 'id'"
    )
    public ResponseEntity<?> deleteEvent(
            @Parameter(description = "Id of the event to delete")
            @PathVariable UUID id) throws EventNotFoundByIdException {
        eventService.deleteEventById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/filter/{search}/{filter}")
    @Operation(
            summary = "Filter events by string",
            description = "Return a event by path variable 'search' and 'filter'"
    )
    public ResponseEntity<List<Event>> filterEvents(
            @Parameter(description = "description of the event to search")
            @PathVariable String search,
            @Parameter(description = "description of the event to search")
            @PathVariable String filter) throws UserNotFoundByIdException {
        List<Event> events = eventService.filterByString(search,filter);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/filter/date")
    @Operation(
            summary = "Filter events by date",
            description = "Return a event by date"
    )
    public ResponseEntity<List<Event>> filterEventsByDate() {
        List<Event> events = eventService.filterByDate();
        return ResponseEntity.ok(events);
    }
}