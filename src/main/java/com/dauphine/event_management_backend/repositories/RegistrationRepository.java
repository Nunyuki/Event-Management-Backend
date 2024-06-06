package com.dauphine.event_management_backend.repositories;

import com.dauphine.event_management_backend.models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RegistrationRepository  extends JpaRepository<Registration, UUID> {
}
