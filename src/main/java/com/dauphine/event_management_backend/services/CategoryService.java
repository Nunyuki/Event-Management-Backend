package com.dauphine.event_management_backend.services;

import com.dauphine.event_management_backend.models.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> retrieveAllCategories();
    Category retrieveCategoryById(UUID id);
    Category createCategory(String name);
    Category updateCategory(UUID id, String categoryName);
    void deleteById(UUID id);
}
