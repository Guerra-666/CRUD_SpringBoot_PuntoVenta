package com.crudsito.crud.controllers;

import com.crudsito.crud.models.InventarioModel;
import com.crudsito.crud.models.Tipos_MovimientoModel;
import com.crudsito.crud.services.Tipos_MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/tipos_movimiento")
public class Tipos_MovimientoController {
    @Autowired
    private Tipos_MovimientoService tipos_movimientoService;

    @GetMapping
    public ArrayList<Tipos_MovimientoModel> gettipos_movimiento(){
        return this.tipos_movimientoService.gettipos_movimiento();
    }

    @PostMapping
    public Tipos_MovimientoModel saveTipos_Movimiento(@RequestBody Tipos_MovimientoModel tipos_movimiento){
        return this.tipos_movimientoService.saveTipos_Movimiento(tipos_movimiento);
    }

    @GetMapping(path = "/{id}")
    public Optional<Tipos_MovimientoModel> getTipos_MovimientoById(@PathVariable("id") int id){
        return this.tipos_movimientoService.getById(id);
    }

    @PutMapping (path = "/{id}")
    public Tipos_MovimientoModel updateTipos_MovimientoById(@RequestBody Tipos_MovimientoModel request, int id){
        return this.tipos_movimientoService.updateByID(request, id);
    }

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
