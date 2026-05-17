package com.stefano.dev.service;

import com.stefano.dev.models.Categoria;
import com.stefano.dev.models.dto.CategoriaDtoRequest;
import com.stefano.dev.models.dto.CategoriaDtoResponse;
import com.stefano.dev.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;


    public Flux<CategoriaDtoResponse> listaCategoria(){
        return categoriaRepository.findAll().map(categoria -> new CategoriaDtoResponse(categoria.getId(), categoria.getNombreCategoria()));
    }

    public Mono<CategoriaDtoResponse> buscarCategoria(String nombreCategoria){
        return categoriaRepository.findBynombreCategoria(nombreCategoria)
                .switchIfEmpty(
                        Mono.error(
                        new RuntimeException("No se encontro la categoria")
                ))
                .map(categoria -> new CategoriaDtoResponse(categoria.getId(),categoria.getNombreCategoria()));
    }

    public Mono<CategoriaDtoResponse> agregarCategoria(CategoriaDtoRequest request){
        var categoria = Categoria.builder()
                .nombreCategoria(request.nombreCategoria()).build();
        return categoriaRepository.save(categoria).map(categoriaSave-> new CategoriaDtoResponse(categoriaSave.getId(),categoriaSave.getNombreCategoria()));
    }

    public Mono<CategoriaDtoResponse> actualizarCategoria(Integer id, CategoriaDtoRequest request){

        var categoria = Categoria.builder()
                .nombreCategoria(request.nombreCategoria()).build();

        return categoriaRepository.findById(id)
                .switchIfEmpty(
                        Mono.error(
                                new RuntimeException("")
                        )
                )
                .flatMap(cate -> {
                    cate.setNombreCategoria(request.nombreCategoria());
                    return categoriaRepository.save(categoria).map(categori -> new CategoriaDtoResponse(categori.getId(),categori.getNombreCategoria()));
                });
    }
    public void eliminarCategoria(Integer id ){
        categoriaRepository.findById(id)
                .switchIfEmpty(
                        Mono.error(new RuntimeException("No se encontro la categoria"))
                )
                .flatMap(categoriaRepository::delete);
    }

}
