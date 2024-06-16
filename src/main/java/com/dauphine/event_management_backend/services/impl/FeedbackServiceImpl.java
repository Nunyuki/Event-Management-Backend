package com.dauphine.event_management_backend.services.impl;

import com.dauphine.event_management_backend.dto.FeedbackRequest;
import com.dauphine.event_management_backend.exceptions.events.EventNotFoundByIdException;
import com.dauphine.event_management_backend.exceptions.eventusers.UserNotFoundByIdException;
import com.dauphine.event_management_backend.exceptions.feedback.EmptyFeedbackCommentException;
import com.dauphine.event_management_backend.exceptions.feedback.FeedbackAlreadyExistsException;
import com.dauphine.event_management_backend.exceptions.feedback.FeedbackNotFoundByIdException;
import com.dauphine.event_management_backend.models.Feedback;
import com.dauphine.event_management_backend.repositories.FeedbackRepository;
import com.dauphine.event_management_backend.services.EventService;
import com.dauphine.event_management_backend.services.EventUserService;
import com.dauphine.event_management_backend.services.FeedbackService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    FeedbackRepository feedbackRepository;
    EventService eventService;
    EventUserService eventUserService;

    public FeedbackServiceImpl(FeedbackRepository feedbackRepository, EventService eventService,EventUserService eventUserService) {
        this.feedbackRepository = feedbackRepository;
        this.eventService = eventService;
        this.eventUserService = eventUserService;
    }

    @Override
    public List<Feedback> retrieveAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    @Override
    public Feedback retrieveFeedbackById(UUID id) throws FeedbackNotFoundByIdException {
        return feedbackRepository.findById(id).orElseThrow(() -> new FeedbackNotFoundByIdException(id));
    }

    @Override
    public List<Feedback> retrieveAllFeedbacksByEventId(UUID eventId) {
        return feedbackRepository.findAllByEventId(eventId);
    }

    @Override
    public Feedback createFeedback(FeedbackRequest feedbackRequest) throws FeedbackAlreadyExistsException, EmptyFeedbackCommentException, EventNotFoundByIdException, UserNotFoundByIdException {
        if(feedbackRequest.getComment().trim().isEmpty()){
            throw new EmptyFeedbackCommentException();
        }
        if(feedbackRepository.findAll().stream().anyMatch(feedback -> feedback.getEventId().equals(feedbackRequest.getEventId()) && feedback.getEventUserId().equals(feedbackRequest.getEventUserId()))){
            throw new FeedbackAlreadyExistsException();
        }

        Feedback feedback = new Feedback(feedbackRequest.getEventId(), feedbackRequest.getEventUserId(), feedbackRequest.getComment(), feedbackRequest.getDate(), feedbackRequest.getRate());
        return feedbackRepository.save(feedback);
    }

    @Override
    public Feedback updateFeedback(UUID id, FeedbackRequest feedbackRequest) throws EmptyFeedbackCommentException, FeedbackNotFoundByIdException {
        Feedback feedback = retrieveFeedbackById(id);
        if(feedbackRequest.getComment().trim().isEmpty()){
            throw new EmptyFeedbackCommentException();
        }
        feedback.setComment(feedbackRequest.getComment());
        feedback.setRate(feedbackRequest.getRate());
        return feedbackRepository.save(feedback);
    }

    @Override
    public void deleteFeedbackById(UUID id) throws FeedbackNotFoundByIdException {
        retrieveFeedbackById(id);
        feedbackRepository.deleteById(id);
    }
}
