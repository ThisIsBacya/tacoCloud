package com.example.tacocloud.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Класс с рецептами
@Data
@Entity
@RestResource(rel = "tacos", path = "tacos")
public class Taco {

    @Id
    private Long id;


    private Date createdAt = new Date();

    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    @ManyToMany()
    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<Ingredients> ingredients = new ArrayList<>();

    public void addIngredient(Ingredients ingredients) {
        this.ingredients.add(ingredients);
    }
}
