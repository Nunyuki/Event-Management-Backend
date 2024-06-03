package com.dauphine.event_management_backend.models;

import java.util.Date;
import java.util.UUID;

public class Registration {
    private UUID id;
    private UUID eventId;
    private UUID userId;
    private Date registrationDate;

    public Registration() {}

    public Registration(UUID id, UUID eventId, UUID userId, Date registrationDate) {
        this.id = id;
        this.eventId = eventId;
        this.userId = userId;
        this.registrationDate = registrationDate;
    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
