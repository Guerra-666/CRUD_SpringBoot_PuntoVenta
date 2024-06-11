package com.crudsito.crud.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "inventario")
public class InventarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventario")  // Define el nombre de la columna para la clave primaria
    private Integer id;

    @Column
    private int cantidad;  // Columna para almacenar la cantidad en inventario
    @Column
    private int id_lote;   // Columna para almacenar el ID del lote asociado al inventario

}
