package com.dauphine.event_management_backend.services.impl;

import com.dauphine.event_management_backend.dto.CategoryRequest;
import com.dauphine.event_management_backend.models.Category;
import com.dauphine.event_management_backend.repositories.CategoryRepository;
import com.dauphine.event_management_backend.services.CategoryService;

import java.util.List;
import java.util.UUID;

public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> retrieveAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category retrieveCategoryById(UUID id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category createCategory(CategoryRequest categoryRequest) {
        if(categoryRepository.findCategoryName(categoryRequest.getCategoryName())!=null){
            return null;
        }
        Category category = new Category(categoryRequest.getCategoryName());
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(UUID id, CategoryRequest categoryRequest) {
        Category category = retrieveCategoryById(id);

        if (category == null){
            return null;
        }
        category.setCategoryName(categoryRequest.getCategoryName());
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategoryById(UUID id) {
        categoryRepository.deleteById(id);
    }
}
