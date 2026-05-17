package com.stefano.dev.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CategoriaDtoRequest (
        @JsonProperty("nombre_categoria")
        String nombreCategoria
){
}
