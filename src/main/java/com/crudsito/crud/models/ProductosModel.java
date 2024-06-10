package com.crudsito.crud.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "productos")
public class ProductosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")  // Asegúrate de que el nombre de la columna sea correcto
    private int id;

    @Column(length = 100)
    private String nombre;
    @Column(length = 30)
    private String codigo_barras;
    @Column(precision = 10, scale = 2)
    private BigDecimal precio_venta;

}
