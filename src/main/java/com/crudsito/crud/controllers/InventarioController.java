package com.crudsito.crud.controllers;

import com.crudsito.crud.models.InventarioModel;
import com.crudsito.crud.services.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController

// Permite solicitudes CORS desde el origen especificado (en este caso, el frontend local).
@CrossOrigin(origins = "http://localhost:8080")

@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    // Maneja las solicitudes GET para obtener todos los elementos del inventario.
    @GetMapping
    public ArrayList<InventarioModel> getinventario() {
        return this.inventarioService.getinventario();
    }

    // Maneja las solicitudes POST para guardar un nuevo elemento en el inventario.
    @PostMapping
    public InventarioModel saveInventario(@RequestBody InventarioModel inventario) {
        return this.inventarioService.saveInventario(inventario);
    }

    // Maneja las solicitudes GET para obtener un elemento específico del inventario por su ID.
    @GetMapping(path = "/{id}")
    public Optional<InventarioModel> getInventarioById(@PathVariable("id") int id) {
        return this.inventarioService.getById(id);
    }

    // Maneja las solicitudes PUT para actualizar un elemento del inventario por su ID.
    @PutMapping(path = "/{id}")
    public InventarioModel updateInventarioById(@RequestBody InventarioModel request, @PathVariable("id") int id) {
        return this.inventarioService.updateByID(request, id);
    }

    // Maneja las solicitudes DELETE para eliminar un elemento del inventario por su ID.
    @DeleteMapping(path = "/{id}")
    public String deleteInventarioById(@PathVariable("id") int id) {
        boolean ok = this.inventarioService.deleteInventario(id);

        if (ok) {
            return "Se eliminó el inventario con id " + id;
        } else {
            return "No se pudo eliminar el inventario con id " + id;
        }
    }
}
