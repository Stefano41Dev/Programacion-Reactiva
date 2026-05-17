package com.stefano.dev.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table("Categorias")
@Getter @Setter
@Builder
public class Categoria {
    @Id
    private Integer id;
    private String nombreCategoria;
}
