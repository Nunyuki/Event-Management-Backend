package com.dauphine.event_management_backend.services;

import com.dauphine.event_management_backend.models.Feedback;

import java.util.List;
import java.util.UUID;

public interface FeedbackService {
    List<Feedback> retrieveAllFeedbacks();
    Feedback retrieveFeedbackById(UUID id);
    List<Feedback> retrieveAllFeedbacksByEventId(UUID id);
    Feedback createFeedback(UUID eventId, UUID userId, String comment, int rate);
    Feedback updateFeedback(UUID id, String comment, int rate);
    void deleteById(UUID id);
}
