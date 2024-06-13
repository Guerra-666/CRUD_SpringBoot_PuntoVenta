### Documentación del Proyecto en Spring Boot

#### Introducción
Este proyecto está diseñado para gestionar productos y sus características en una base de datos. Utiliza el framework Spring Boot, que facilita el desarrollo de aplicaciones Java con una configuración mínima y ofrece una estructura organizada basada en el patrón de diseño MVC (Modelo-Vista-Controlador).

A continuación, se describe cada componente principal del proyecto: Modelos, Controladores, Repositorios, Servicios y Requests.

### Modelo
Los modelos representan las entidades de la base de datos. Cada modelo corresponde a una tabla en la base de datos y define los campos y las relaciones entre las tablas.

#### `InventarioModel.java`
```java
package com.crudsito.crud.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "inventario")
public class InventarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventario")
    private Integer id;

    @Column
    private int cantidad;

    @Column
    private int id_lote;
}
```

**Explicación:**
- `@Entity`: Indica que esta clase es una entidad JPA.
- `@Table(name = "inventario")`: Especifica el nombre de la tabla en la base de datos.
- `@Id`: Denota el campo `id` como la clave primaria.
- `@GeneratedValue(strategy = GenerationType.IDENTITY)`: Indica que el valor del campo `id` será generado automáticamente.
- `@Column`: Especifica que los campos `cantidad` e `id_lote` corresponden a columnas en la tabla.

### Controlador
Los controladores manejan las solicitudes HTTP (GET, POST, PUT, DELETE) y llaman a los servicios para procesar la lógica de negocio.

#### `ProductosController.java`
```java
package com.crudsito.crud.controllers;

import com.crudsito.crud.services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "http://localhost:8080")
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    @DeleteMapping("/{id}")
    public String deleteProductoById(@PathVariable("id") int id) {
        boolean ok = productosService.deleteProductoById(id);
        if (ok) {
            return "Se eliminó el producto con id " + id;
        } else {
            return "No se pudo eliminar el producto con id " + id;
        }
    }

    @PostMapping("/deleteMultiple")
    public String deleteMultipleProductos(@RequestBody List<Integer> ids) {
        boolean ok = productosService.deleteMultipleProductos(ids);
        if (ok) {
            return "Se eliminaron los productos con ids " + ids.toString();
        } else {
            return "No se pudieron eliminar todos los productos. Verifique los ids proporcionados.";
        }
    }
}
```

**Explicación:**
- `@RestController`: Indica que esta clase es un controlador REST.
- `@RequestMapping("/productos")`: Mapea las solicitudes a `/productos`.
- `@CrossOrigin`: Permite solicitudes CORS desde el origen especificado.
- `@DeleteMapping("/{id}")`: Mapea las solicitudes `DELETE` para eliminar un producto por su ID.
- `@PostMapping("/deleteMultiple")`: Mapea las solicitudes `POST` para eliminar múltiples productos.

### Repositorio
Los repositorios proporcionan métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la base de datos.

#### `IProductos.java`
```java
package com.crudsito.crud.repositories;

import com.crudsito.crud.models.ProductosModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductos extends CrudRepository<ProductosModel, Integer> {
}
```

**Explicación:**
- `@Repository`: Indica que esta interfaz es un repositorio.
- `CrudRepository<ProductosModel, Integer>`: Proporciona métodos CRUD para la entidad `ProductosModel` con la clave primaria de tipo `Integer`.

### Servicio
Los servicios contienen la lógica de negocio y actúan como intermediarios entre los controladores y los repositorios.

#### `ProductosService.java`
```java
package com.crudsito.crud.services;

import com.crudsito.crud.repositories.IProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosService {

    @Autowired
    IProductos productosRepository;

    public boolean deleteProductoById(int id) {
        try {
            productosRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteMultipleProductos(List<Integer> ids) {
        try {
            productosRepository.deleteAllById(ids);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
```

**Explicación:**
- `@Service`: Indica que esta clase es un servicio.
- `deleteProductoById(int id)`: Elimina un producto por su ID.
- `deleteMultipleProductos(List<Integer> ids)`: Elimina múltiples productos usando una lista de IDs.

### Request
Las clases de request se utilizan para recibir y validar datos de entrada en las solicitudes HTTP.

#### `ProductoCompletoRequest.java`
```java
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
```

**Explicación:**
- `@Getter` y `@Setter`: Lombok genera automáticamente los métodos getter y setter.
- `ProductoCompletoRequest`: Agrupa varios modelos en un solo objeto de solicitud, útil para operaciones que involucran múltiples entidades.

### Justificación de Spring Boot
Spring Boot se elige por varias razones:
- **Configuración Mínima**: Simplifica la configuración de proyectos Spring mediante convenciones predeterminadas.
- **Eficiencia**: Permite a los desarrolladores centrarse en la lógica de negocio en lugar de la configuración de la infraestructura.
- **Escalabilidad**: Ideal para aplicaciones que necesitan crecer en términos de funcionalidad y usuarios.
- **Comunidad y Soporte**: Gran cantidad de recursos y soporte de la comunidad, facilitando la resolución de problemas y la obtención de ayuda.
- **Integración**: Facilita la integración con otros marcos y bibliotecas populares en el ecosistema Java.

### Conclusión
Este proyecto ejemplifica cómo estructurar una aplicación en Spring Boot utilizando el patrón MVC, con modelos para representar entidades, controladores para manejar solicitudes HTTP, 
repositorios para realizar operaciones en la base de datos y servicios para contener la lógica de negocio. Además, las clases de request permiten agrupar y validar datos de entrada.
Spring Boot es una excelente elección para desarrollar aplicaciones robustas y escalables de manera eficiente.
