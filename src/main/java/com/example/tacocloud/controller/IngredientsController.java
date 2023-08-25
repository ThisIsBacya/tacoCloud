package com.example.tacocloud.controller;

import com.example.tacocloud.model.Ingredients;
import com.example.tacocloud.repository.IngredientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/ingredients", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8080")
public class IngredientsController {
    private IngredientRepository ingredientRepository;

    @GetMapping
    public Iterable<Ingredients> allIngredients() {
        return ingredientRepository.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("#{hasRole('ADMIN')}")
    public Ingredients createIngredients(@RequestBody Ingredients ingredients) {
        return ingredientRepository.save(ingredients);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("#{hasRole('ADMIN')}")
    public void deleteIngredient(@PathVariable("id") String ingredientId) {
        ingredientRepository.deleteById(ingredientId);
    }
}
