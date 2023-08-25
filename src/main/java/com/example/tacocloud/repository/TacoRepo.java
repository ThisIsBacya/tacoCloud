package com.example.tacocloud.repository;

import com.example.tacocloud.model.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepo extends CrudRepository<Taco, Long> {
}
