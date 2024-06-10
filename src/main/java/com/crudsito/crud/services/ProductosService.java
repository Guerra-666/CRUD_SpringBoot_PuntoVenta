package com.crudsito.crud.services;

import com.crudsito.crud.models.LotesModel;
import com.crudsito.crud.models.ProductosModel;
import com.crudsito.crud.repositories.ILotes;
import com.crudsito.crud.repositories.IProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductosService {

    @Autowired
    IProductos ProductosRepository;
    /**
     * Método para obtener los lotes de la base de datos
     */
    public ArrayList<ProductosModel> getproductos(){
        return (ArrayList<ProductosModel>) ProductosRepository.findAll();
    }

    public ProductosModel saveProductos(ProductosModel productos){
        return ProductosRepository.save(productos);
    }

    public Optional<ProductosModel> getById(int id){
        return ProductosRepository.findById(Integer.valueOf(id));
    }


    public ProductosModel updateByID(ProductosModel request, int id){
        ProductosModel productos = ProductosRepository.findById(Integer.valueOf(id)).get();

        productos.setNombre(request.getNombre());
        productos.setCodigo_barras(request.getCodigo_barras());
        productos.setPrecio_venta(request.getPrecio_venta());

        return productos;
    }

    public Boolean deleteProductos(int id){
        try{
            ProductosRepository.deleteById(Integer.valueOf(id));
            return (Boolean) true;
        }catch(Exception err){
            return (Boolean) false;
        }
    }
}
