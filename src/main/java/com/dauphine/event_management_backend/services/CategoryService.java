package com.dauphine.event_management_backend.services;

import com.dauphine.event_management_backend.dto.CategoryRequest;
import com.dauphine.event_management_backend.exceptions.categories.CategoryNameAlreadyExistsException;
import com.dauphine.event_management_backend.exceptions.categories.CategoryNotFoundByIdException;
import com.dauphine.event_management_backend.models.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> retrieveAllCategories();
    Category retrieveCategoryById(UUID id) throws CategoryNotFoundByIdException;
    Category createCategory(CategoryRequest categoryRequest) throws CategoryNameAlreadyExistsException, CategoryNameAlreadyExistsException;
    Category updateCategory(UUID id, CategoryRequest categoryRequest) throws CategoryNotFoundByIdException, CategoryNameAlreadyExistsException, CategoryNotFoundByIdException;
    void deleteCategoryById(UUID id) throws CategoryNotFoundByIdException;
    List<Category> findAllLikeCategoryName(String categoryName);
}
