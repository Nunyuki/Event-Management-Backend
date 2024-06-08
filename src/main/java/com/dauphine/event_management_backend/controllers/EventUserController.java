package com.dauphine.event_management_backend.controllers;
import com.dauphine.event_management_backend.dto.AuthenticateRequest;
import com.dauphine.event_management_backend.dto.EventUserRequest;
import com.dauphine.event_management_backend.models.EventUser;
import com.dauphine.event_management_backend.services.EventUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class EventUserController {

    private final EventUserService eventUserService;

    public EventUserController(EventUserService eventUserService) {
        this.eventUserService = eventUserService;
    }

    @PostMapping
    public EventUser createUser(@RequestBody EventUserRequest user) {
        EventUser registeredUSer = eventUserService.createUser(user);

        if (registeredUSer == null) {
            System.out.println("Erreur durant l'inscription");
            return null;
        }

        System.out.println("Inscription réussie");
        return registeredUSer;
    }

    @PostMapping("/login")
    public ResponseEntity<EventUser> login(@RequestBody AuthenticateRequest authenticateRequest) {
        EventUser user = eventUserService.authenticateUser(authenticateRequest.getPseudo(), authenticateRequest.getPassword());
        return ResponseEntity.ok(user);
    }
}