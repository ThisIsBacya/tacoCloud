package com.example.tacocloud.converter;

import com.example.tacocloud.model.Ingredients;
import com.example.tacocloud.model.Ingredients.Type;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//Класс для преобразования строк в объекты Ingredient
@Component
public class IngredientByIdConverter implements Converter<String, Ingredients> {

    private Map<String, Ingredients> ingredientsMap = new HashMap<>();

    public IngredientByIdConverter() {
        ingredientsMap.put("FLTO", new Ingredients("FLTO", "Flour Tortilla", Type.WRAP));
        ingredientsMap.put("COTO", new Ingredients("COTO", "Corn Tortilla", Type.WRAP));
        ingredientsMap.put("COTO", new Ingredients("GRBF", "Ground Beef", Type.PROTEIN));
        ingredientsMap.put("COTO", new Ingredients("CARN", "Carnitas", Type.PROTEIN));
        ingredientsMap.put("COTO", new Ingredients("TMTO", "Tomatoes", Type.VEGGIES));
        ingredientsMap.put("COTO", new Ingredients("LETC", "Lettuce", Type.VEGGIES));
        ingredientsMap.put("COTO", new Ingredients("CHDR", "Cheese Cheddar", Type.CHEESE));
        ingredientsMap.put("COTO", new Ingredients("JACK", "Monterrey Jack", Type.CHEESE));
        ingredientsMap.put("COTO", new Ingredients("SLSA", "Salsa", Type.SAUCE));
        ingredientsMap.put("COTO", new Ingredients("SRCR", "Sour Cream", Type.SAUCE));
    }


    @Override
    public Ingredients convert(String id) {
        return ingredientsMap.get(id);
    }
}