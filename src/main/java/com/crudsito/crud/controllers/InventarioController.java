package com.crudsito.crud.controllers;

import com.crudsito.crud.models.InventarioModel;
import com.crudsito.crud.services.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public ArrayList<InventarioModel> getinventario() {
        return this.inventarioService.getinventario();
    }

    @PostMapping
    public InventarioModel saveInventario(@RequestBody InventarioModel inventario) {
        return this.inventarioService.saveInventario(inventario);
    }

    @GetMapping(path = "/{id}")
    public Optional<InventarioModel> getInventarioById(@PathVariable("id") int id) {
        return this.inventarioService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public InventarioModel updateInventarioById(@RequestBody InventarioModel request, @PathVariable("id") int id) {
        return this.inventarioService.updateByID(request, id);
    }

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
