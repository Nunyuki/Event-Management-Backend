package com.dauphine.event_management_backend.services;

import com.dauphine.event_management_backend.dto.FeedbackRequest;
import com.dauphine.event_management_backend.exceptions.events.EventNotFoundByIdException;
import com.dauphine.event_management_backend.exceptions.eventusers.UserNotFoundByIdException;
import com.dauphine.event_management_backend.exceptions.feedback.EmptyFeedbackCommentException;
import com.dauphine.event_management_backend.exceptions.feedback.FeedbackAlreadyExistsException;
import com.dauphine.event_management_backend.exceptions.feedback.FeedbackNotFoundByIdException;
import com.dauphine.event_management_backend.models.Feedback;

import java.util.List;
import java.util.UUID;

public interface FeedbackService {
    List<Feedback> retrieveAllFeedbacks();
    Feedback retrieveFeedbackById(UUID id) throws FeedbackNotFoundByIdException;
    List<Feedback> retrieveAllFeedbacksByEventId(UUID eventId);
    Feedback createFeedback(FeedbackRequest feedbackRequest) throws FeedbackAlreadyExistsException, EmptyFeedbackCommentException, EventNotFoundByIdException, UserNotFoundByIdException;
    Feedback updateFeedback(UUID id, FeedbackRequest feedbackRequest) throws EmptyFeedbackCommentException, FeedbackNotFoundByIdException;
    void deleteFeedbackById(UUID id) throws FeedbackNotFoundByIdException;
}
