package com.stefano.dev.repository;

import com.stefano.dev.models.Categoria;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CategoriaRepository extends ReactiveCrudRepository<Categoria, Integer> {
}
