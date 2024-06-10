package com.crudsito.crud.repositories;

import com.crudsito.crud.models.InventarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInventario extends JpaRepository<InventarioModel, Integer>{


}
