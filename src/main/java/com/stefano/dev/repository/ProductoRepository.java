package com.stefano.dev.repository;

import com.stefano.dev.models.Producto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductoRepository extends ReactiveCrudRepository<Producto, Integer> {
}
