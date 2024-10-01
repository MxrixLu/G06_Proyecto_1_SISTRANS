package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    @GetMapping
    public Collection<Producto> darProductos() {
        return productoRepository.darProductos();
    }

    // Obtener un producto por su clave primaria compuesta
    @GetMapping("/{id}/{codigoBarras}")
    public ResponseEntity<Producto> darProductoPorId(@PathVariable("id") int id, @PathVariable("codigoBarras") String codigoBarras) {
        try {
            Producto producto = productoRepository.darProducto(id, codigoBarras);
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Insertar un nuevo producto
    @PostMapping("/new/save")
    @Transactional
    public ResponseEntity<String> insertarProducto(@RequestBody Producto producto) {
        try {
            productoRepository.insertarProducto(
                producto.getPk().getId(),
                producto.getPk().getCodigoBarras(),
                producto.getNombre(),
                producto.getCostoBodega(),
                producto.getPrecioVenta(),
                producto.getPresentacion(),
                producto.getCantidadPresentacion(),
                producto.getUnidadMedida(),
                producto.getVolumenEmpaque(),
                producto.getPesoEmpaque(),
                producto.getFechaExpiracion(),
                producto.getCategoria().getId() 
            );
            return new ResponseEntity<>("Producto creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar un producto existente
    @PutMapping("/{id}/{codigoBarras}/edit/save")
    @Transactional
    public ResponseEntity<String> actualizarProducto(@PathVariable("id") int id,
                                                     @PathVariable("codigoBarras") String codigoBarras,
                                                     @RequestBody Producto producto) {
        try {
            productoRepository.actualizarProducto(
                id,
                codigoBarras,
                producto.getNombre(),
                producto.getCostoBodega(),
                producto.getPrecioVenta(),
                producto.getPresentacion(),
                producto.getCantidadPresentacion(),
                producto.getUnidadMedida(),
                producto.getVolumenEmpaque(),
                producto.getPesoEmpaque(),
                producto.getFechaExpiracion(),
                producto.getCategoria().getId() 
            );
            return new ResponseEntity<>("Producto actualizado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Borrar un producto por su clave primaria compuesta
    @DeleteMapping("/{id}/{codigoBarras}/delete")
    @Transactional
    public ResponseEntity<String> borrarProducto(@PathVariable("id") int id, @PathVariable("codigoBarras") String codigoBarras) {
        try {
            productoRepository.borrarProducto(id, codigoBarras);
            return new ResponseEntity<>("Producto eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
