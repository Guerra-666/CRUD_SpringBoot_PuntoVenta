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
    @Column(name = "id_movimiento")  // Asegúrate de que el nombre de la columna sea correcto
    private int id;

    @Column
    private int id_producto;
    @Column
    private int id_tipo_movimiento;
    @Column
    private LocalDateTime fecha_movimiento;
    @Column
    private int cantidad;

}
