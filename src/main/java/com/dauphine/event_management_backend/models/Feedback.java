package com.dauphine.event_management_backend.models;

import java.util.Date;
import java.util.UUID;

public class Feedback {
    private UUID id;
    private UUID eventId;
    private UUID eventUserId;
    private String comment;
    private Date date;
    private int rate;

    public Feedback() {}

    public Feedback(UUID id, UUID eventId, UUID eventUserId, String comment, Date date, int rate) {
        this.id = id;
        this.eventId = eventId;
        this.eventUserId = eventUserId;
        this.comment = comment;
        this.date = date;
        this.rate = rate;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
