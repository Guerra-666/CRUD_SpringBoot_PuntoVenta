package com.crudsito.crud.controllers;

import com.crudsito.crud.models.MovimientosModel;
import com.crudsito.crud.services.MovimientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController

// Permite solicitudes CORS desde el origen especificado (en este caso, el frontend local).
@CrossOrigin(origins = "http://localhost:8080")

@RequestMapping("/movimientos")
public class MovimientosController {
    @Autowired
    private MovimientosService movimientosService;

    // Maneja las solicitudes GET para obtener todos los movimientos.
    @GetMapping
    public ArrayList<MovimientosModel> getmovimientos(){
        return this.movimientosService.getmovimientos();
    }

    // Maneja las solicitudes POST para guardar un nuevo movimiento.
    @PostMapping
    public MovimientosModel saveMovimientos(@RequestBody MovimientosModel movimientos){
        return this.movimientosService.saveMovimientos(movimientos);
    }

    // Maneja las solicitudes GET para obtener un movimiento específico por su ID.
    @GetMapping(path = "/{id}")
    public Optional<MovimientosModel> getMovimientosById(@PathVariable("id") int id){
        return this.movimientosService.getById(id);
    }

    // Maneja las solicitudes PUT para actualizar un movimiento por su ID.
    @PutMapping (path = "/{id}")
    public MovimientosModel updateMovimientosById(@RequestBody MovimientosModel request, @PathVariable("id") int id){
        return this.movimientosService.updateByID(request, id);
    }

    // Maneja las solicitudes DELETE para eliminar un movimiento por su ID.
    @DeleteMapping(path = "/{id}")
    public String deleteMovimientosById(@PathVariable("id") int id){
        boolean ok = this.movimientosService.deleteMovimientos(id);

        if(ok){
            return "Se eliminó el movimiento con id " + id;
        }else{
            return "No se pudo eliminar el movimiento con id " + id;
        }
    }
}
