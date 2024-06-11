package com.dauphine.event_management_backend.controllers;
import com.dauphine.event_management_backend.dto.CategoryRequest;
import com.dauphine.event_management_backend.exceptions.categories.CategoryNameAlreadyExistsException;
import com.dauphine.event_management_backend.exceptions.categories.CategoryNotFoundByIdException;
import com.dauphine.event_management_backend.models.Category;
import com.dauphine.event_management_backend.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(
            summary = "Retrieve all categories",
            description = "Return all categories or filter the name of categories by request param 'categoryName'"
    )
    @GetMapping
    public ResponseEntity<List<Category>> retrieveAllCategories(
            @Parameter(description = "Option to filter categories by sub chain (name)")
            @RequestParam(required = false) String categoryName) {

        System.out.println("Received categoryName: " + categoryName);

        List<Category> categories = categoryName == null || categoryName.isBlank()
                ? categoryService.retrieveAllCategories()
                : categoryService.findAllLikeCategoryName(categoryName);
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Retrieve a category by his id",
            description = "Return a category by path variable 'id'"
    )
    public ResponseEntity<Category> retrieveCategoryById(
            @Parameter(description = "Id of the category to retrieve")
            @PathVariable UUID id) throws CategoryNotFoundByIdException {

        Category category = categoryService.retrieveCategoryById(id);
        return ResponseEntity.ok(category);
    }

    @PostMapping("")
    @Operation(
            summary = "Create a new category",
            description = "Create a new category by setting an unused name"
    )
    public ResponseEntity<Category> createCategory(
            @Parameter(description = "Request which contains the name of the new category")
            @RequestBody CategoryRequest categoryRequest) throws CategoryNameAlreadyExistsException {

        Category category = categoryService.createCategory(categoryRequest);
        return ResponseEntity
                .created(URI.create("v1/categories/"+category.getId()))
                .body(category);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update the name of a category",
            description = "Update category names by path variable 'id' and request body 'categoryRequest'"
    )
    public ResponseEntity<Category> updateCategory(
            @Parameter(description = "Id of the category to updated")
            @PathVariable UUID id,
            @Parameter(description = "Request  which contains the new name of the category")
            @RequestBody CategoryRequest categoryRequest) throws CategoryNotFoundByIdException, CategoryNameAlreadyExistsException {

        Category category = categoryService.updateCategory(id,categoryRequest);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete category by his id",
            description = "Delete category by path variable 'id'"
    )
    public ResponseEntity<?> deleteCategory(
            @Parameter(description = "Id of the category to delete")
            @PathVariable UUID id) throws CategoryNotFoundByIdException {
        categoryService.retrieveCategoryById(id);
        categoryService.deleteCategoryById(id);
        return ResponseEntity.ok().build();
    }

}