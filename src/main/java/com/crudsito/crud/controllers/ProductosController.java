package com.crudsito.crud.controllers;

import com.crudsito.crud.models.ProductosModel;
import com.crudsito.crud.services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController

// Permite solicitudes CORS desde el origen especificado (en este caso, el frontend local).
@CrossOrigin(origins = "http://localhost:8080")

@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    // Maneja las solicitudes GET para obtener todos los productos.
    @GetMapping
    public ArrayList<ProductosModel> getproductos(){
        return this.productosService.getproductos();
    }

    // Maneja las solicitudes POST para guardar un nuevo producto.
    @PostMapping
    public ProductosModel saveProductos(@RequestBody ProductosModel productos){
        return this.productosService.saveProductos(productos);
    }

    // Maneja las solicitudes GET para obtener un producto específico por su ID.
    @GetMapping(path = "/{id}")
    public Optional<ProductosModel> getProductosById(@PathVariable("id") int id){
        return this.productosService.getById(id);
    }

    // Maneja las solicitudes PUT para actualizar un producto por su ID.
    @PutMapping (path = "/{id}")
    public ProductosModel updateProductosById(@RequestBody ProductosModel request, @PathVariable("id") int id){
        return this.productosService.updateByID(request, id);
    }

    // Maneja las solicitudes DELETE para eliminar un producto por su ID.
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
