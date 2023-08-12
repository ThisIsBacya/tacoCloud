package com.example.tacocloud.model;

import lombok.Data;

@Data
public class Ingredients {
    private final String id;
    private final String name;
    private final type type;

    public enum type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
