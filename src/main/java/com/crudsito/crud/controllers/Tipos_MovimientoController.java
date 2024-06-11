package com.crudsito.crud.controllers;

import com.crudsito.crud.models.Tipos_MovimientoModel;
import com.crudsito.crud.services.Tipos_MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController

// Permite solicitudes CORS desde el origen especificado (en este caso, el frontend local).
@CrossOrigin(origins = "http://localhost:8080")

@RequestMapping("/tipos_movimiento")
public class Tipos_MovimientoController {

    @Autowired
    private Tipos_MovimientoService tipos_movimientoService;

    // Maneja las solicitudes GET para obtener todos los tipos de movimiento.
    @GetMapping
    public ArrayList<Tipos_MovimientoModel> gettipos_movimiento(){
        return this.tipos_movimientoService.gettipos_movimiento();
    }

    // Maneja las solicitudes POST para guardar un nuevo tipo de movimiento.
    @PostMapping
    public Tipos_MovimientoModel saveTipos_Movimiento(@RequestBody Tipos_MovimientoModel tipos_movimiento){
        return this.tipos_movimientoService.saveTipos_Movimiento(tipos_movimiento);
    }

    // Maneja las solicitudes GET para obtener un tipo de movimiento específico por su ID.
    @GetMapping(path = "/{id}")
    public Optional<Tipos_MovimientoModel> getTipos_MovimientoById(@PathVariable("id") int id){
        return this.tipos_movimientoService.getById(id);
    }

    // Maneja las solicitudes PUT para actualizar un tipo de movimiento por su ID.
    @PutMapping (path = "/{id}")
    public Tipos_MovimientoModel updateTipos_MovimientoById(@RequestBody Tipos_MovimientoModel request, @PathVariable("id") int id){
        return this.tipos_movimientoService.updateByID(request, id);
    }

    // Maneja las solicitudes DELETE para eliminar un tipo de movimiento por su ID.
    @DeleteMapping(path = "/{id}")
    public String deleteTipos_MovimientoById(@PathVariable("id") int id){
        boolean ok = this.tipos_movimientoService.deleteTipos_Movimiento(id);

        if(ok){
            return "Se eliminó el tipo de movimiento con id " + id;
        }else{
            return "No se pudo eliminar el tipo de movimiento con id " + id;
        }
    }

}
