package com.dauphine.event_management_backend.services.impl;

import com.dauphine.event_management_backend.models.Category;
import com.dauphine.event_management_backend.services.CategoryService;

import java.util.List;
import java.util.UUID;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> retrieveAllCategories() {
        return List.of();
    }

    @Override
    public Category retrieveCategoryById(UUID id) {
        return null;
    }

    @Override
    public Category createCategory(String name) {
        return null;
    }

    @Override
    public Category updateCategory(UUID id, String categoryName) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
