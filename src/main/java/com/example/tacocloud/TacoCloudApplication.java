package com.example.tacocloud;

import com.example.tacocloud.model.Ingredients;
import com.example.tacocloud.model.Ingredients.Type;
import com.example.tacocloud.repository.IngredientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TacoCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository repo) {
        return args -> {
            repo.save(new Ingredients("FLTO", "Flour Tortilla", Type.WRAP));
            repo.save(new Ingredients("COTO", "Corn Tortilla", Type.WRAP));
            repo.save(new Ingredients("GRBF", "Ground Beef", Type.PROTEIN));
            repo.save(new Ingredients("CARN", "Carnitas", Type.PROTEIN));
            repo.save(new Ingredients("TMTO", "Diced Tomatoes", Type.VEGGIES));
            repo.save(new Ingredients("LETC", "Lettuce", Type.VEGGIES));
            repo.save(new Ingredients("CHED", "Cheddar", Type.CHEESE));
            repo.save(new Ingredients("JACK", "Monterrey Jack", Type.CHEESE));
            repo.save(new Ingredients("SLSA", "Salsa", Type.SAUCE));
            repo.save(new Ingredients("SRCR", "Sour Cream", Type.SAUCE));
        };
    }
}
