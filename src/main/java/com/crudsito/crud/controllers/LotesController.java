package com.crudsito.crud.controllers;

import com.crudsito.crud.models.InventarioModel;
import com.crudsito.crud.models.LotesModel;
import com.crudsito.crud.services.LotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/lotes")
public class LotesController {

    @Autowired
    private LotesService lotesService;

    @GetMapping
    public ArrayList<LotesModel> getlotes(){
        return this.lotesService.getlotes();
    }

    @PostMapping
    public LotesModel saveLotes(@RequestBody LotesModel lotes){
        return this.lotesService.saveLotes(lotes);
    }

    @GetMapping(path = "/{id}")
    public Optional<LotesModel> getlotesById(@PathVariable("id") int id){
        return this.lotesService.getById(id);
    }

    @PutMapping (path = "/{id}")
    public LotesModel updateLotesById(@RequestBody LotesModel request, int id){
        return this.lotesService.updateByID(request, id);
    }

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
