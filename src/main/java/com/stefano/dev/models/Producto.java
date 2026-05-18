package com.stefano.dev.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("productos")
@Getter @Setter
@Builder
public class Producto {
    @Id
    private Integer id;
    private String nombre;
    private String descripcion;
    private Double precio;
    @Column("categoria_id")
    private Integer categoriaId;
    @Column("stock_actual")
    private int stockActual;
}
