package com.stefano.dev.repository;

import com.stefano.dev.models.Categoria;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface CategoriaRepository extends ReactiveCrudRepository<Categoria, Integer> {

    Mono<Categoria> findBynombreCategoria(String nombreCategoria);
}
