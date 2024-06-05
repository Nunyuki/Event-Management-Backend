package com.dauphine.event_management_backend.models;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

public class Event {
    private UUID id;
    private String eventName;
    private UUID createdBy;
    private Date createdOn;
    private Category category;
    private Date eventDate;
    private Time eventTime;
    private String eventLocation;
    private String eventDescription;

    public Event() {}

    public Event(UUID id, String eventName, UUID createdBy, Date createdOn, Category category, Date eventDate, Time eventTime, String eventLocation, String eventDescription){
        this.id = id;
        this.eventName = eventName;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.category = category;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventLocation = eventLocation;
        this.eventDescription = eventDescription;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public UUID getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Time getEventTime() {
        return eventTime;
    }

    public void setEventTime(Time eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }
}
