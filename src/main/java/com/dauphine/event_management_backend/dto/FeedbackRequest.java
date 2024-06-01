package com.dauphine.event_management_backend.dto;

import java.util.Date;
import java.util.UUID;

public class FeedbackRequest {
    private UUID eventId;
    private UUID userId;
    private String comment;
    private Date date;
    private int rate;
}
