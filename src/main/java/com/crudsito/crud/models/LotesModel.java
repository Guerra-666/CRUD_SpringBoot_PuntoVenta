package com.crudsito.crud.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "lotes")
public class LotesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lote")  // Define el nombre de la columna para la clave primaria
    private int id;

    @Column(name = "id_producto")  // Define el nombre de la columna para el ID del producto asociado
    private int idProducto;  // Cambia el nombre de la variable para seguir las convenciones de nomenclatura de Java

    @Column
    private LocalDateTime caducidad;  // Columna para almacenar la fecha de caducidad del lote

    @Column
    private int piezas;  // Columna para almacenar la cantidad de piezas en el lote

    @Column(precision = 10, scale = 2)  // Define precisión y escala para el precio de compra
    private BigDecimal precio_compra;  // Cambia el nombre de la variable para seguir las convenciones de nomenclatura de Java

}
