package com.example.tacocloud.config;

import com.example.tacocloud.model.Ingredients;
import com.example.tacocloud.model.Taco;
import com.example.tacocloud.repository.IngredientRepository;
import com.example.tacocloud.repository.TacoRepo;
import com.example.tacocloud.repository.TacoRepository;
import com.example.tacocloud.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@Configuration
@Profile("!prod")
public class DevelopmentConfig {
    @Bean
    public CommandLineRunner dataLoader(IngredientRepository ingredientRepository,
                                        UserRepository userRepository,
                                        PasswordEncoder passwordEncoder,
                                        TacoRepo tacoRepository) {

        return args -> {
            Ingredients flourTortilla = new Ingredients("FLTO", "Flour Tortilla", Ingredients.Type.WRAP);
            Ingredients cornTortilla = new Ingredients("COTO", "Corn Tortilla", Ingredients.Type.WRAP);
            Ingredients groundBeef = new Ingredients("GRBF", "Ground Beef", Ingredients.Type.PROTEIN);
            Ingredients carnitas = new Ingredients("CARN", "Carnitas", Ingredients.Type.PROTEIN);
            Ingredients tomatoes = new Ingredients("TMTO", "Diced Tomatoes", Ingredients.Type.VEGGIES);
            Ingredients lettuce = new Ingredients("LETC", "Lettuce", Ingredients.Type.VEGGIES);
            Ingredients cheddar = new Ingredients("CHED", "Cheddar", Ingredients.Type.CHEESE);
            Ingredients jack = new Ingredients("JACK", "Monterrey Jack", Ingredients.Type.CHEESE);
            Ingredients salsa = new Ingredients("SLSA", "Salsa", Ingredients.Type.SAUCE);
            Ingredients sourCream = new Ingredients("SRCR", "Sour Cream", Ingredients.Type.SAUCE);

            ingredientRepository.save(flourTortilla);
            ingredientRepository.save(cornTortilla);
            ingredientRepository.save(groundBeef);
            ingredientRepository.save(carnitas);
            ingredientRepository.save(tomatoes);
            ingredientRepository.save(lettuce);
            ingredientRepository.save(cheddar);
            ingredientRepository.save(jack);
            ingredientRepository.save(salsa);
            ingredientRepository.save(sourCream);

            Taco taco1 = new Taco();
            taco1.setName("Bovine Bounty");
            taco1.setIngredients(Arrays.asList(flourTortilla, cornTortilla, tomatoes, lettuce, salsa));
            tacoRepository.save(taco1);

            Taco taco2 = new Taco();
            taco2.setName("Hello, it's me");
            taco2.setIngredients(Arrays.asList(flourTortilla, carnitas, cheddar, sourCream));
            tacoRepository.save(taco2);
        };
    }
}
