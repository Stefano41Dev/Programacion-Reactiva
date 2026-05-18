package com.stefano.dev.repository;

import com.stefano.dev.models.Producto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ProductoRepository extends ReactiveCrudRepository<Producto, Integer> {
    Flux<Producto> findBynombreContainingIgnoreCase(String nombre);
}
