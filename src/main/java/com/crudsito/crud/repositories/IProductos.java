package com.crudsito.crud.repositories;

import com.crudsito.crud.models.ProductosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductos extends JpaRepository<ProductosModel, Integer> {
}
