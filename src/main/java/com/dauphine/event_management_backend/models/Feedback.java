package com.dauphine.event_management_backend.models;

import java.util.Date;
import java.util.UUID;

public class Feedback {
    private UUID id;
    private UUID eventId;
    private UUID userId;
    private String comment;
    private Date date;
    private int rate;
}
