package com.dauphine.event_management_backend.repositories;

import com.dauphine.event_management_backend.models.EventUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface EventUserRepository extends JpaRepository<EventUser, UUID> {

}