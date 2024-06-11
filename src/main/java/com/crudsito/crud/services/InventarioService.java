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
    public ArrayList<InventarioModel> getinventario() {
        // Retorna todos los registros de inventario desde el repositorio
        return (ArrayList<InventarioModel>) inventarioRepository.findAll();
    }

    // Método para guardar un nuevo registro de inventario
    public InventarioModel saveInventario(InventarioModel inventario) {
        // Guarda el inventario en la base de datos y retorna el objeto guardado
        return inventarioRepository.save(inventario);
    }

    // Método para obtener un registro de inventario por su ID
    public Optional<InventarioModel> getById(int id) {
        // Retorna un registro de inventario por su ID
        return inventarioRepository.findById(Integer.valueOf(id));
    }

    // Método para actualizar un registro de inventario por su ID
    public InventarioModel updateByID(InventarioModel request, int id) {
        // Busca el registro de inventario por su ID
        InventarioModel inventario = inventarioRepository.findById(Integer.valueOf(id)).get();

        // Actualiza los campos del inventario con los valores proporcionados en la solicitud
        inventario.setCantidad(request.getCantidad());
        inventario.setId_lote(request.getId_lote());

        return inventario; // Retorna el inventario actualizado
    }

    // Método para eliminar un registro de inventario por su ID
    public Boolean deleteInventario(int id) {
        try {
            // Elimina el registro de inventario por su ID
            inventarioRepository.deleteById(Integer.valueOf(id));
            return true; // Retorna verdadero si se eliminó correctamente
        } catch (Exception err) {
            return false; // Retorna falso si ocurrió un error al eliminar el registro
        }
    }
}
