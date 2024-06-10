package com.crudsito.crud.services;


import com.crudsito.crud.models.LotesModel;
import com.crudsito.crud.repositories.ILotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class LotesService {

    @Autowired
    ILotes lotesRepository;

    /**
     * Método para obtener los lotes de la base de datos
     */
    public ArrayList<LotesModel> getlotes() {
        return (ArrayList<LotesModel>) lotesRepository.findAll();
    }

    public LotesModel saveLotes(LotesModel lotes) {
        return lotesRepository.save(lotes);
    }

    public Optional<LotesModel> getById(int id) {
        return lotesRepository.findById(Integer.valueOf(id));
    }

    public LotesModel updateByID(LotesModel request, int id) {
        LotesModel lotes = lotesRepository.findById(Integer.valueOf(id)).get();

        lotes.setCaducidad(request.getCaducidad());
        lotes.setId_producto(request.getId_producto());
        lotes.setPiezas(request.getPiezas());
        lotes.setPrecio_compra(request.getPrecio_compra());

        return lotes;
    }

    public Boolean deleteLotes(int id) {
        try {
            lotesRepository.deleteById(Integer.valueOf(id));
            return (Boolean) true;
        } catch (Exception err) {
            return (Boolean) false;
        }
    }
}