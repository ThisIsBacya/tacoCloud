package com.example.tacocloud.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.util.List;
//Класс с рецептами
@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createdAt = new Date();

    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    @NotNull
    @Size(min=1, message="You must choose at least 1 ingredient")
    @ManyToMany
    private List<Ingredients> ingredients;
}
