package com.crudsito.crud.services;

import com.crudsito.crud.models.MovimientosModel;
import com.crudsito.crud.repositories.IMovimientos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Service
public class MovimientosService {

    @Autowired
    IMovimientos MovimientosRepository;
    /**
     * Método para obtener los lotes de la base de datos
     */
    public ArrayList<MovimientosModel> getmovimientos(){
        return (ArrayList<MovimientosModel>) MovimientosRepository.findAll();
    }

    public MovimientosModel saveMovimientos(MovimientosModel movimientos){
        // Validación adicional para asegurarse de que la fecha no sea nula
        if (movimientos.getFechaMovimiento() == null) {
            movimientos.setFechaMovimiento(LocalDateTime.now());
        }
        return MovimientosRepository.save(movimientos);
    }


    public Optional<MovimientosModel> getById(int id){
        return MovimientosRepository.findById(Integer.valueOf(id));
    }

    public MovimientosModel updateByID(MovimientosModel request, int id){
        MovimientosModel movimientos = MovimientosRepository.findById(Integer.valueOf(id)).get();

        movimientos.setFechaMovimiento(request.getFechaMovimiento());
        movimientos.setCantidad(request.getCantidad());

        return movimientos;
    }

    public Boolean deleteMovimientos(int id){
        try{
            MovimientosRepository.deleteById(Integer.valueOf(id));
            return (Boolean) true;
        }catch(Exception err){
            return (Boolean) false;
        }
    }
}
