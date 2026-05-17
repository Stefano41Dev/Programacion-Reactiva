package com.stefano.dev.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("Productos")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @Id
    private Integer id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer categoriaId;
    private int stockActual;
}
