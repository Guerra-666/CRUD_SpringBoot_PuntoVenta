package com.crudsito.crud.services;

import com.crudsito.crud.models.Tipos_MovimientoModel;
import com.crudsito.crud.repositories.ITipos_Movimientos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service

public class Tipos_MovimientoService {
    @Autowired
    ITipos_Movimientos Tipos_MovimientosRepository;
    /**
     * Método para obtener los lotes de la base de datos
     */
    public ArrayList<Tipos_MovimientoModel> gettipos_movimiento(){
        return (ArrayList<Tipos_MovimientoModel>) Tipos_MovimientosRepository.findAll();
    }

    public Tipos_MovimientoModel saveTipos_Movimiento(Tipos_MovimientoModel tipos_movimiento){
        return Tipos_MovimientosRepository.save(tipos_movimiento);
    }

    public Optional <Tipos_MovimientoModel> getById(int id){
        return Tipos_MovimientosRepository.findById(Integer.valueOf(id));
    }

    public Tipos_MovimientoModel updateByID(Tipos_MovimientoModel request, int id){
        Tipos_MovimientoModel tipos_movimiento = Tipos_MovimientosRepository.findById(Integer.valueOf(id)).get();

        tipos_movimiento.setNombre(request.getNombre());

        return tipos_movimiento;
    }

    public Boolean deleteTipos_Movimiento(int id){
        try{
            Tipos_MovimientosRepository.deleteById(Integer.valueOf(id));
            return (Boolean) true;
        }catch(Exception err){
            return (Boolean) false;
        }
    }
}
