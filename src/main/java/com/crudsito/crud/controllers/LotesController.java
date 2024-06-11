package com.crudsito.crud.controllers;

import com.crudsito.crud.models.LotesModel;
import com.crudsito.crud.services.LotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController

// Permite solicitudes CORS desde el origen especificado (en este caso, el frontend local).
@CrossOrigin(origins = "http://localhost:8080")

@RequestMapping("/lotes")
public class LotesController {

    @Autowired
    private LotesService lotesService;

    // Maneja las solicitudes GET para obtener todos los lotes.
    @GetMapping
    public ArrayList<LotesModel> getlotes(){
        return this.lotesService.getlotes();
    }

    // Maneja las solicitudes POST para guardar un nuevo lote.
    @PostMapping
    public LotesModel saveLotes(@RequestBody LotesModel lotes){
        return this.lotesService.saveLotes(lotes);
    }

    // Maneja las solicitudes GET para obtener un lote específico por su ID.
    @GetMapping(path = "/{id}")
    public Optional<LotesModel> getlotesById(@PathVariable("id") int id){
        return this.lotesService.getById(id);
    }

    // Maneja las solicitudes PUT para actualizar un lote por su ID.
    @PutMapping (path = "/{id}")
    public LotesModel updateLotesById(@RequestBody LotesModel request, @PathVariable("id") int id){
        return this.lotesService.updateByID(request, id);
    }

    // Maneja las solicitudes DELETE para eliminar un lote por su ID.
    @DeleteMapping(path = "/{id}")
    public String deleteLotesById(@PathVariable("id") int id){
        boolean ok = this.lotesService.deleteLotes(id);

        if(ok){
            return "Se eliminó el lote con id " + id;
        }else{
            return "No se pudo eliminar el lote con id " + id;
        }
    }
}
