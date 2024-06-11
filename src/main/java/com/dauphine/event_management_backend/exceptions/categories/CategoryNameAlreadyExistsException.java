package com.dauphine.event_management_backend.exceptions.categories;

public class CategoryNameAlreadyExistsException extends Exception {
    public CategoryNameAlreadyExistsException(String name) {
        super("Il existe déjà une catégorie avec le nom: " + name + "!!!");
    }
}