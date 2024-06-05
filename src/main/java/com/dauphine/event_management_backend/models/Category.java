package com.dauphine.event_management_backend.models;

import java.util.UUID;

public class Category {
    private UUID id;
    private String categoryName;

    public Category() {}
    public Category(UUID id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
