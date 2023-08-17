package com.example.tacocloud.model;


import java.util.List;
import java.util.stream.Collectors;

public class TacoUDRUtils {

    public static TacoUDT toTacoUDT(Taco taco) {
        return new TacoUDT(taco.getName(), taco.getIngredients());
    }

//    public static List<IngredientsUDT> toIngredientUDTs(List<Ingredients> ingredients) {
//        return ingredients.stream()
//                .map(ingredient -> toIngredientUDTs(ingredient))
//                .collect(Collectors.toList());
//    }

    public static IngredientsUDT toIngredientsUDT(Ingredients ingredient) {
        return new IngredientsUDT(ingredient.getName(), ingredient.getType());
    }
}
