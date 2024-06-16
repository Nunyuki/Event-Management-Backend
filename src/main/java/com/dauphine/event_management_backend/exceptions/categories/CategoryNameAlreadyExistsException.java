package com.dauphine.event_management_backend.exceptions.categories;

public class CategoryNameAlreadyExistsException extends Exception {
    public CategoryNameAlreadyExistsException(String name) {
        super("Already a category with the name " + name + "exists !!!");
    }
}