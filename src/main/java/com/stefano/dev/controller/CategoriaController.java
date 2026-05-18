package com.stefano.dev.controller;

import com.stefano.dev.models.dto.CategoriaDtoRequest;
import com.stefano.dev.models.dto.CategoriaDtoResponse;
import com.stefano.dev.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categoria")
public class CategoriaController {
    private final CategoriaService categoriaService;

    @PostMapping
    public Mono<CategoriaDtoResponse> agregarCategoria(
            @RequestBody CategoriaDtoRequest request
    ){
        return categoriaService.agregarCategoria(request);
    }

    @GetMapping
    public Flux<CategoriaDtoResponse> listarCategoria(){
        return categoriaService.listaCategoria();
    }

    @PutMapping("/{id}")
    public Mono<CategoriaDtoResponse> actualizarCategoria(
            @PathVariable Integer id,
            @RequestBody CategoriaDtoRequest requestUpdate
            ){
        return categoriaService.actualizarCategoria(id,requestUpdate);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminarCategoria(
            @PathVariable Integer id
    ){
        return categoriaService.eliminarCategoria(id);
    }

    @GetMapping("/{nombre}")
    public Flux<CategoriaDtoResponse> buscarCategoriaPorNombre(
            @PathVariable String nombre
    ){
        return categoriaService.buscarCategoria(nombre);
    }
}
