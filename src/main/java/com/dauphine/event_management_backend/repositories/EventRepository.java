package com.dauphine.event_management_backend.repositories;

import com.dauphine.event_management_backend.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository  extends JpaRepository<Event, UUID> {
}
