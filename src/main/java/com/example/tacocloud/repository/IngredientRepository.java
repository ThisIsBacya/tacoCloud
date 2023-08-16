package com.example.tacocloud.repository;

import com.example.tacocloud.model.Ingredients;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredients, String> {
}
