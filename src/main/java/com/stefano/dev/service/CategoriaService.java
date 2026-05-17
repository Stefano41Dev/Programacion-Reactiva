package com.stefano.dev.service;

import com.stefano.dev.models.Categoria;
import com.stefano.dev.models.dto.CategoriaDtoRequest;
import com.stefano.dev.models.dto.CategoriaDtoResponse;
import com.stefano.dev.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public Mono<CategoriaDtoResponse> agregarCategoria(CategoriaDtoRequest request){
        var categoria = Categoria.builder()
                .nombreCategoria(request.nombreCategoria()).build();

        return categoriaRepository.save(categoria).map(categoriaSave-> new CategoriaDtoResponse(
                categoriaSave.getId(),categoriaSave.getNombreCategoria()
        ));
    }

}
