package com.dauphine.event_management_backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    public Category() {}

    public Category(String categoryName) {
        this.id = UUID.randomUUID();
        this.categoryName = categoryName;
    }

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
