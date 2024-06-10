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
    @Column(name = "id_inventario")  // Asegúrate de que el nombre de la columna sea correcto
    private Integer id;

    @Column
    private int cantidad;
    @Column
    private int id_lote;

}
