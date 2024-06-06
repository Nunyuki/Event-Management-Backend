package com.dauphine.event_management_backend.repositories;

import com.dauphine.event_management_backend.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository  extends JpaRepository<Category, UUID> {
}
