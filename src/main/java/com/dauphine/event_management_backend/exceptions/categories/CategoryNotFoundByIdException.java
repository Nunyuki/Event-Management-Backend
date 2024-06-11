package com.dauphine.event_management_backend.exceptions.categories;

import java.util.UUID;

public class CategoryNotFoundByIdException extends  Exception {
    public CategoryNotFoundByIdException(UUID id) {
        super("On ne trouve pas de catégorie avec l'id: " + id + "!!!");
    }
}