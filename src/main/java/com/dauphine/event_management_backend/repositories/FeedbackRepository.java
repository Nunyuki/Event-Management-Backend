package com.dauphine.event_management_backend.repositories;

import com.dauphine.event_management_backend.models.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FeedbackRepository  extends JpaRepository<Feedback, UUID> {
    List<Feedback> findAllByEventId(UUID eventId);
}
