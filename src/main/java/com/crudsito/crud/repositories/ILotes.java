package com.crudsito.crud.repositories;

import com.crudsito.crud.models.LotesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILotes extends JpaRepository<LotesModel, Integer> {
}
