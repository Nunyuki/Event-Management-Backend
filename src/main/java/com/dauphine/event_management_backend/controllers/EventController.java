package com.dauphine.event_management_backend.controllers;

import com.dauphine.event_management_backend.dto.CategoryRequest;
import com.dauphine.event_management_backend.dto.EventRequest;
import com.dauphine.event_management_backend.exceptions.categories.CategoryNameAlreadyExistsException;
import com.dauphine.event_management_backend.exceptions.categories.CategoryNotFoundByIdException;
import com.dauphine.event_management_backend.exceptions.events.EmptyDescriptionException;
import com.dauphine.event_management_backend.exceptions.events.EventAlreadyExistsException;
import com.dauphine.event_management_backend.exceptions.events.EventNotFoundByIdException;
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

    @GetMapping("/category/{categoryName}")
    @Operation(
            summary = "Find events by category",
            description = "Return a event by path variable 'categoryName'"
    )
    public ResponseEntity<List<Event>> findEventsByCategoryName(
            @Parameter(description = "category name to search")
            @PathVariable String categoryName) {
        List<Event> events = eventService.findByCategoryName(categoryName);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/creator/{creator}")
    @Operation(
            summary = "Find events by creator",
            description = "Return a event by path variable 'creator'"
    )
    public ResponseEntity<List<Event>> findEventsByCreator(
            @Parameter(description = "id of the creator to search")
            @PathVariable UUID creator) {
        List<Event> events = eventService.findByCreatedBy(creator);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/name/{eventName}")
    @Operation(
            summary = "Find events by name",
            description = "Return a event by path variable 'name'"
    )
    public ResponseEntity<List<Event>> findEventsByEventByName(
            @Parameter(description = "name of the event to search")
            @PathVariable String eventName) {
        List<Event> events = eventService.findByEventName(eventName);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/location/{location}")
    @Operation(
            summary = "Find events by location",
            description = "Return a event by path variable 'location'"
    )
    public ResponseEntity<List<Event>> findEventsByLocation(
            @Parameter(description = "location of the event to search")
            @PathVariable String location) {
        List<Event> events = eventService.findByLocation(location);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/description/{description}")
    @Operation(
            summary = "Find events by description",
            description = "Return a event by path variable 'description'"
    )
    public ResponseEntity<List<Event>> findEventsByDescription(
            @Parameter(description = "description of the event to search")
            @PathVariable String description) {
        List<Event> events = eventService.findByDescription(description);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/search/{search}")
    @Operation(
            summary = "Find events by string",
            description = "Return a event by path variable 'search'"
    )
    public ResponseEntity<List<Event>> searchEvents(
            @Parameter(description = "search element")
            @PathVariable String search) {
        List<Event> events = eventService.searchEvents(search);
        return ResponseEntity.ok(events);
    }
}