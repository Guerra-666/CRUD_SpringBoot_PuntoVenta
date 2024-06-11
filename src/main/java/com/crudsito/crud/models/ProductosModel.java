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
    @Column(name = "id_producto")  // Define el nombre de la columna para la clave primaria
    private int id;

    @Column(length = 100)  // Limita la longitud de la columna para el nombre del producto a 100 caracteres
    private String nombre;

    @Column(length = 30)  // Limita la longitud de la columna para el código de barras a 30 caracteres
    private String codigo_barras;  // Cambia el nombre de la variable para seguir las convenciones de nomenclatura de Java

    @Column(precision = 10, scale = 2)  // Define la precisión y la escala para el precio de venta
    private BigDecimal precio_venta;  // Cambia el nombre de la variable para seguir las convenciones de nomenclatura de Java

}
