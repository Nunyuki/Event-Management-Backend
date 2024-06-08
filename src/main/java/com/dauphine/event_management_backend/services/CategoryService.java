package com.dauphine.event_management_backend.services;

import com.dauphine.event_management_backend.dto.CategoryRequest;
import com.dauphine.event_management_backend.models.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> retrieveAllCategories();
    Category retrieveCategoryById(UUID id);
    Category createCategory(CategoryRequest categoryRequest);
    Category updateCategory(UUID id, CategoryRequest categoryRequest);
    void deleteCategoryById(UUID id);
}
