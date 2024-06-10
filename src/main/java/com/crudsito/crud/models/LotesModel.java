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
    @Column(name = "id_lote")  // Asegúrate de que el nombre de la columna sea correcto
    private int id;

    @Column
    private int id_producto;
    @Column
    private LocalDateTime caducidad;
    @Column
    private int piezas;
    @Column(precision = 10, scale = 2)
    private BigDecimal precio_compra;

}
