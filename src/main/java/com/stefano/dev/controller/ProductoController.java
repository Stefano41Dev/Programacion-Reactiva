package com.stefano.dev.controller;

import com.stefano.dev.models.dto.ProductoDtoRequest;
import com.stefano.dev.models.dto.ProductoDtoResponse;
import com.stefano.dev.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/producto")
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping
    public Mono<ProductoDtoResponse> agregarProducto(
            @RequestBody ProductoDtoRequest request
    ){
        return productoService.agregarProducto(request);
    }
    @GetMapping
    public Flux<ProductoDtoResponse> listarProducto(){
        return productoService.listarProducto();
    }
    @GetMapping("/{nombre}")
    public Flux<ProductoDtoResponse> buscarProductoPorNombre(
            @PathVariable String nombre
    ){
        return productoService.buscarProductoPorNombre(nombre);
    }
}
