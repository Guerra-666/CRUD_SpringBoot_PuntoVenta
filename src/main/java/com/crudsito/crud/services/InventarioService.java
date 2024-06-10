package com.crudsito.crud.services;


import com.crudsito.crud.models.InventarioModel;
import com.crudsito.crud.repositories.IInventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class InventarioService {

    @Autowired
    IInventario inventarioRepository;
    /**
     * Método para obtener el inventario de la base de datos
     */
    public ArrayList<InventarioModel> getinventario(){
        return (ArrayList<InventarioModel>) inventarioRepository.findAll();
    }

    public InventarioModel saveInventario(InventarioModel inventario){
        return inventarioRepository.save(inventario);
    }

    public Optional<InventarioModel> getById(int id){
        return inventarioRepository.findById(Integer.valueOf(id));
    }

    public InventarioModel updateByID(InventarioModel request, int id){
        InventarioModel inventario = inventarioRepository.findById(Integer.valueOf(id)).get();

        inventario.setCantidad(request.getCantidad());
        inventario.setId_lote(request.getId_lote());

        return inventario;
    }

    public Boolean deleteInventario(int id){
        try{
            inventarioRepository.deleteById(Integer.valueOf(id));
            return (Boolean) true;
        }catch(Exception err){
            return (Boolean) false;
        }
    }

}
