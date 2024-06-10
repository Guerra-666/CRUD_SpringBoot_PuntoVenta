package com.crudsito.crud.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "tipos_movimiento")
public class Tipos_MovimientoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_movimiento")  // Asegúrate de que el nombre de la columna sea correcto
    private int id;

    @Column(length = 50)
    private String nombre;

}
