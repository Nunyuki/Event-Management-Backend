package com.dauphine.event_management_backend.dto;

import java.util.Date;
import java.util.UUID;

public class RegistrationRequest {
    private UUID eventId;
    private UUID userId;

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
}
