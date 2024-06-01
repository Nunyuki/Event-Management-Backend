package com.dauphine.event_management_backend.models;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

public class Event {
    private UUID id;
    private String eventName;
    private UUID createdBy;
    private Date createdOn;
    private UUID categoryId;
    private Date eventDate;
    private Time eventTime;
    private String eventLocation;
    private String eventDescription;
}
