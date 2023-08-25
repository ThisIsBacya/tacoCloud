package com.example.tacocloud.service;

import com.example.tacocloud.model.Ingredients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.client.Traverson;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class TacoCloudClient {
    private RestTemplate restTemplate;
    private Traverson traverson;

    public Ingredients getIngredientById(String ingredientId) {
        Map<String, String> url = new HashMap<>();
        url.put("id", ingredientId);
        return restTemplate.getForObject("http://localhost:8080/ingredients/{id}",
                Ingredients.class, url);
    }

    public void updateIngredient(Ingredients ingredients) {
        restTemplate.put("http://localhost:8080/ingredients/{id}",
                ingredients, ingredients.getId());
    }

    public void deleteIngredient(Ingredients ingredients) {
        restTemplate.delete("http://localhost:8080/ingredients/{id}", ingredients.getId());
    }

    public Ingredients createIngredient(Ingredients ingredients) {
        return restTemplate.postForObject("http://localhost:8080/ingredients/{id}",
                ingredients, Ingredients.class);
    }
}
