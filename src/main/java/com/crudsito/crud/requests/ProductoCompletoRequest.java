package com.crudsito.crud.requests;

import com.crudsito.crud.models.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductoCompletoRequest {
    private ProductosModel producto;
    private LotesModel lote;
    private MovimientosModel movimiento;
    private InventarioModel inventario;
    private Tipos_MovimientoModel tipoMovimiento;
}
