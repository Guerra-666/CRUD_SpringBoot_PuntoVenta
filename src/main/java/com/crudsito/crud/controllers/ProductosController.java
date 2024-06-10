package com.crudsito.crud.controllers;

import com.crudsito.crud.models.InventarioModel;
import com.crudsito.crud.models.ProductosModel;
import com.crudsito.crud.services.InventarioService;
import com.crudsito.crud.services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    @GetMapping
    public ArrayList<ProductosModel> getproductos(){
        return this.productosService.getproductos();
    }

    @PostMapping
    public ProductosModel saveProductos(@RequestBody ProductosModel productos){
        return this.productosService.saveProductos(productos);
    }

    @GetMapping(path = "/{id}")
    public Optional<ProductosModel> getProductosById(@PathVariable("id") int id){
        return this.productosService.getById(id);
    }


    @PutMapping (path = "/{id}")
    public ProductosModel updateProductosById(@RequestBody ProductosModel request, int id){
        return this.productosService.updateByID(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteProductosById(@PathVariable("id") int id){
        boolean ok = this.productosService.deleteProductos(id);

        if(ok){
            return "Se eliminó el producto con id " + id;
        }else{
            return "No se pudo eliminar el producto con id " + id;
        }
    }
}
