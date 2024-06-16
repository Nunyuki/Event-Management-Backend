package com.dauphine.event_management_backend.repositories;

import com.dauphine.event_management_backend.models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RegistrationRepository  extends JpaRepository<Registration, UUID> {
    List<Registration> findAllByEventId(UUID eventId);
    List<Registration> findAllByEventUserId(UUID eventUserId);
    Registration findByEventIdAndEventUserId(UUID eventId, UUID eventUserId);
}
