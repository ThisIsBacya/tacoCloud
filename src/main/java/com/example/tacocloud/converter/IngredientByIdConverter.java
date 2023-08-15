package com.example.tacocloud.converter;

import com.example.tacocloud.model.Ingredients;
import com.example.tacocloud.model.Ingredients.Type;
import com.example.tacocloud.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

//Класс для преобразования строк в объекты Ingredient
@Component
public class IngredientByIdConverter implements Converter<String, Ingredients> {

    private final IngredientRepository ingredientRepo;


    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }


    @Override
    public Ingredients convert(String id) {
        return ingredientRepo.findById(id).orElse(null);
    }
}
