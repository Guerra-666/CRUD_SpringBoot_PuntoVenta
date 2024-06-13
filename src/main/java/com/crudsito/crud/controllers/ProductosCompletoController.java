package com.crudsito.crud.controllers;

import com.crudsito.crud.models.*;
import com.crudsito.crud.requests.ProductoCompletoRequest;
import com.crudsito.crud.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/productos-completo")
public class ProductosCompletoController {

    @Autowired
    private ProductosService productosService;
    @Autowired
    private LotesService lotesService;
    @Autowired
    private MovimientosService movimientosService;
    @Autowired
    private InventarioService inventarioService;
    @Autowired
    private Tipos_MovimientoService tiposMovimientoService;


    @PostMapping
    public String createProductoCompleto(@RequestBody ProductoCompletoRequest request) {
        // Crear Producto
        ProductosModel producto = productosService.saveProductos(request.getProducto());

        // Crear Lote
        LotesModel lote = request.getLote();
        lote.setIdProducto(producto.getId());
        lote = lotesService.saveLotes(lote);

        // Crear Movimiento
        MovimientosModel movimiento = request.getMovimiento();
        movimiento.setIdProducto(producto.getId());
        movimiento.setIdTipoMovimiento(request.getTipoMovimiento().getId());
        movimiento.setFechaMovimiento(request.getMovimiento().getFechaMovimiento());
        movimiento = movimientosService.saveMovimientos(movimiento);

        // Actualizar Inventario
        InventarioModel inventario = new InventarioModel();
        inventario.setCantidad(request.getInventario().getCantidad());
        inventario.setId_lote(lote.getId());
        inventarioService.saveInventario(inventario);


        return "Producto, lote, movimiento e inventario creados con éxito";
    }
}
