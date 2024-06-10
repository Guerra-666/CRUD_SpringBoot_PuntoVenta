package com.crudsito.crud.controllers;

import com.crudsito.crud.models.InventarioModel;
import com.crudsito.crud.models.MovimientosModel;
import com.crudsito.crud.services.InventarioService;
import com.crudsito.crud.services.MovimientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/movimientos")
public class MovimientosController {
    @Autowired
    private MovimientosService movimientosService;

    @GetMapping
    public ArrayList<MovimientosModel> getmovimientos(){
        return this.movimientosService.getmovimientos();
    }

    @PostMapping
    public MovimientosModel saveMovimientos(@RequestBody MovimientosModel movimientos){
        return this.movimientosService.saveMovimientos(movimientos);
    }

    @GetMapping(path = "/{id}")
    public Optional<MovimientosModel> getMovimientosById(@PathVariable("id") int id){
        return this.movimientosService.getById(id);
    }

    @PutMapping (path = "/{id}")
    public MovimientosModel updateMovimientosById(@RequestBody MovimientosModel request, int id){
        return this.movimientosService.updateByID(request, id);
    }

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
