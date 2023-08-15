package com.example.tacocloud.repository;

import com.example.tacocloud.model.Ingredients;

import java.util.Optional;

public interface IngredientRepository {
    Iterable<Ingredients> findAll();

    Optional<Ingredients> findById(String id);

    Ingredients save(Ingredients ingredients);
}
