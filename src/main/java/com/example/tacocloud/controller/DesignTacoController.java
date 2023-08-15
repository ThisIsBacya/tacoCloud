package com.example.tacocloud.controller;

import com.example.tacocloud.model.Ingredients;
import com.example.tacocloud.model.Ingredients.Type;
import com.example.tacocloud.model.Taco;
import com.example.tacocloud.model.TacoOrder;
import javax.validation.Valid;

import com.example.tacocloud.repository.IngredientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;

    public DesignTacoController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredients> ingredients = ingredientRepo.findAll();

        Type[] types = Ingredients.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }
    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping()
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String sendTaco(@Valid Taco taco,
                           @ModelAttribute TacoOrder tacoOrder,
                           Errors errors) {

        if (errors.hasErrors()) {
            return "design";
        }
        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}", taco);

        return "redirect:/orders/current";
    }

    private Iterable<Ingredients> filterByType(Iterable<Ingredients> ingredients, Type type) {
        return StreamSupport.stream(ingredients.spliterator(), false)
                .filter(i -> i.getType().equals(type))
                .collect(Collectors.toList());
    }
}
