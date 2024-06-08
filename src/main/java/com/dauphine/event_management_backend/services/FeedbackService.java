package com.dauphine.event_management_backend.services;

import com.dauphine.event_management_backend.dto.FeedbackRequest;
import com.dauphine.event_management_backend.models.Feedback;

import java.util.List;
import java.util.UUID;

public interface FeedbackService {
    List<Feedback> retrieveAllFeedbacks();
    Feedback retrieveFeedbackById(UUID id);
    List<Feedback> retrieveAllFeedbacksByEventId(UUID id);
    Feedback createFeedback(FeedbackRequest feedbackRequest);
    Feedback updateFeedback(UUID id, FeedbackRequest feedbackRequest);
    void deleteFeedbackById(UUID id);
}
