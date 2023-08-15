package com.example.tacocloud.repository;

import com.example.tacocloud.model.Ingredients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcIngredientRepository implements IngredientRepository{

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredients> findAll() {
        return jdbcTemplate.query(
                "select id, name, type from ingredient",
                this::mapRowToIngredient
        );
    }

    @Override
    public Optional<Ingredients> findById(String id) {
        List<Ingredients> results = jdbcTemplate.query(
                "select id, name, type from ingredient where id=?",
                this::mapRowToIngredient,
                id
        );
        return results.size() == 0 ?
                Optional.empty() :
                Optional.of(results.get(0));
    }

    @Override
    public Ingredients save(Ingredients ingredients) {
        jdbcTemplate.update(
                "insert into Ingredient (id, name, type) values (?, ?, ?)",
                ingredients.getId(),
                ingredients.getName(),
                ingredients.getType().toString());
        return ingredients;
    }

    private Ingredients mapRowToIngredient(ResultSet row, int rowNum) throws SQLException {
        return new Ingredients(row.getString("id"),
                row.getString("name"),
                Ingredients.Type.valueOf(row.getString("type")));
    }
}
