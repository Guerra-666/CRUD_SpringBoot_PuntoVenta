package com.crudsito.crud.repositories;

import com.crudsito.crud.models.MovimientosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovimientos extends JpaRepository<MovimientosModel, Integer> {
}
