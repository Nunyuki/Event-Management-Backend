package com.dauphine.event_management_backend.models;

import java.util.Date;
import java.util.UUID;

public class Registration {
    private UUID id;
    private UUID eventId;
    private UUID eventUserId;
    private Date registrationDate;

    public Registration() {}

    public Registration(UUID id, UUID eventId, UUID eventUserId, Date registrationDate) {
        this.id = id;
        this.eventId = eventId;
        this.eventUserId = eventUserId;
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

    public UUID getEventUserId() {
        return eventUserId;
    }

    public void setEventUserId(UUID eventUserId) {
        this.eventUserId = eventUserId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
