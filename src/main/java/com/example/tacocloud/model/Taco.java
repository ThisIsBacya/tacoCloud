package com.example.tacocloud.model;

import lombok.Data;

import java.util.List;
//Класс с рецептами
@Data
public class Taco {
    private String name;
    private List<Ingredients> ingredients;
}
