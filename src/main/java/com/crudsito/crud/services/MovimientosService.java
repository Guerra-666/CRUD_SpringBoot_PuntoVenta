package com.crudsito.crud.services;

import com.crudsito.crud.models.MovimientosModel;
import com.crudsito.crud.repositories.IMovimientos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Optional;

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
        return MovimientosRepository.save(movimientos);
    }

    public Optional<MovimientosModel> getById(int id){
        return MovimientosRepository.findById(Integer.valueOf(id));
    }

    public MovimientosModel updateByID(MovimientosModel request, int id){
        MovimientosModel movimientos = MovimientosRepository.findById(Integer.valueOf(id)).get();

        movimientos.setFecha_movimiento(request.getFecha_movimiento());
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
