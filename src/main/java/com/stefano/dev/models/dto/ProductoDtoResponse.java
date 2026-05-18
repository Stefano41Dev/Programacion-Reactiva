package com.stefano.dev.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record ProductoDtoResponse (
    Integer id,
    String nombre,
    String descripcion,
    Double precio,
    @JsonProperty("categoria")
    CategoriaDtoResponse categoriaDtoResponse,
    int stockActual
){
}
