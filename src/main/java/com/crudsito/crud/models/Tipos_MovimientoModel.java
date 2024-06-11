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
    @Column(name = "id_tipo_movimiento")  // Define el nombre de la columna para la clave primaria
    private int id;

    @Column(length = 50)  // Limita la longitud de la columna para el nombre del tipo de movimiento a 50 caracteres
    private String nombre;

}
