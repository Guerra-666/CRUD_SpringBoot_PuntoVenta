package com.crudsito.crud.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "movimientos")
public class MovimientosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")  // Define el nombre de la columna para la clave primaria
    private int id;

    @Column(name = "id_producto")  // Define el nombre de la columna para el ID del producto asociado
    private int idProducto;  // Cambia el nombre de la variable para seguir las convenciones de nomenclatura de Java

    @Column(name = "id_tipo_movimiento")  // Define el nombre de la columna para el ID del tipo de movimiento
    private int idTipoMovimiento;  // Cambia el nombre de la variable para seguir las convenciones de nomenclatura de Java

    @Column(name = "fecha_movimiento")  // Define el nombre de la columna para la fecha de movimiento
    private LocalDateTime fechaMovimiento;  // Cambia el nombre de la variable para seguir las convenciones de nomenclatura de Java

    @Column
    private int cantidad;  // Columna para almacenar la cantidad de productos movidos

}
