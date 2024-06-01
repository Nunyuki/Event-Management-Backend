package com.dauphine.event_management_backend.dto;

import java.util.Date;
import java.util.UUID;

public class RegistrationRequest {
    private UUID eventId;
    private UUID userId;
    private Date registrationDate;
}
