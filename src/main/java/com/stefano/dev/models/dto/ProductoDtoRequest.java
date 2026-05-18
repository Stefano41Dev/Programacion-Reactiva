package com.stefano.dev.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductoDtoRequest(
        String nombre,
        String descripcion,
        Double precio,
        @JsonProperty("categoria_id")
        Integer categoriaId,
        @JsonProperty("stock_actual")
        int stockActual
) {
}
