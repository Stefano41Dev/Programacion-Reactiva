package com.stefano.dev.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table("categorias")
@Getter @Setter
@Builder
public class Categoria {
    @Id
    private Integer id;
    @Column("nombre_categoria")
    private String nombreCategoria;
}
