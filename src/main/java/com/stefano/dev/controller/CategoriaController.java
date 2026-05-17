package com.stefano.dev.controller;

import com.stefano.dev.models.dto.CategoriaDtoRequest;
import com.stefano.dev.models.dto.CategoriaDtoResponse;
import com.stefano.dev.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categoria")
public class CategoriaController {
    private final CategoriaService categoriaService;
    @GetMapping
    private Mono<CategoriaDtoResponse> agregarCategoria(CategoriaDtoRequest request){
        return categoriaService.agregarCategoria(request);
    }
}
