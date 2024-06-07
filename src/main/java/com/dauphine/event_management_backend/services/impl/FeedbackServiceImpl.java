package com.dauphine.event_management_backend.services.impl;

import com.dauphine.event_management_backend.dto.FeedbackRequest;
import com.dauphine.event_management_backend.models.Feedback;
import com.dauphine.event_management_backend.services.FeedbackService;

import java.util.List;
import java.util.UUID;

public class FeedbackServiceImpl implements FeedbackService {
    @Override
    public List<Feedback> retrieveAllFeedbacks() {
        return List.of();
    }

    @Override
    public Feedback retrieveFeedbackById(UUID id) {
        return null;
    }

    @Override
    public List<Feedback> retrieveAllFeedbacksByEventId(UUID id) {
        return List.of();
    }

    @Override
    public Feedback createFeedback(FeedbackRequest feedbackRequest) {
        return null;
    }

    @Override
    public Feedback updateFeedback(UUID id, FeedbackRequest feedbackRequest) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
