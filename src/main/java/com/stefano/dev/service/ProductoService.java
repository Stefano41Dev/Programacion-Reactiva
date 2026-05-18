package com.stefano.dev.service;

import com.stefano.dev.models.Producto;
import com.stefano.dev.models.dto.CategoriaDtoResponse;
import com.stefano.dev.models.dto.ProductoDtoRequest;
import com.stefano.dev.models.dto.ProductoDtoResponse;
import com.stefano.dev.repository.CategoriaRepository;
import com.stefano.dev.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductoService {
    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    public Mono<ProductoDtoResponse> agregarProducto(
            @RequestBody ProductoDtoRequest request
            ){

        Producto producto = Producto.builder()
                .nombre(request.nombre())
                .descripcion(request.descripcion())
                .precio(request.precio())
                .categoriaId(request.categoriaId())
                .stockActual(request.stockActual())
                .build();

        return productoRepository.save(producto)
                // Cuando se guarde el producto...
                .flatMap(producto1 ->
                        // Buscar categoría
                        categoriaRepository.findById(producto1.getCategoriaId())
                                // Transformar a DTO final
                                .map(categoria -> ProductoDtoResponse.builder()
                                        .id(producto1.getId())
                                        .nombre(producto1.getNombre())
                                        .descripcion(producto1.getDescripcion())
                                        .precio(producto1.getPrecio())
                                        // Aquí YA tienes la categoría real
                                        .categoriaDtoResponse(
                                                new CategoriaDtoResponse(
                                                        categoria.getId(),
                                                        categoria.getNombreCategoria()
                                                )
                                        )
                                        .stockActual(producto1.getStockActual())
                                        .build()
                                )
                );
    }

    public Flux<ProductoDtoResponse> listarProducto(){
        return productoRepository.findAll().flatMap(producto ->
           categoriaRepository.findById(producto.getCategoriaId())
                   .map(categoria -> ProductoDtoResponse.builder()
                           .id(producto.getId())
                           .nombre(producto.getNombre())
                           .descripcion(producto.getDescripcion())
                           .precio(producto.getPrecio())
                           .categoriaDtoResponse(
                                   new CategoriaDtoResponse(
                                           categoria.getId(),
                                           categoria.getNombreCategoria()
                                   )
                           )
                           .stockActual(producto.getStockActual())
                           .build())
        );
    }

    public Flux<ProductoDtoResponse> buscarProductoPorNombre(String nombre){
        return productoRepository.findBynombreContainingIgnoreCase(nombre).flatMap(producto ->
                categoriaRepository.findById(producto.getCategoriaId())
                        .map(categoria -> ProductoDtoResponse.builder()
                                .id(producto.getId())
                                .nombre(producto.getNombre())
                                .descripcion(producto.getDescripcion())
                                .precio(producto.getPrecio())
                                .categoriaDtoResponse(
                                        new CategoriaDtoResponse(
                                                categoria.getId(),
                                                categoria.getNombreCategoria()
                                        )
                                )
                                .stockActual(producto.getStockActual())
                                .build())
        );

    }

}
