package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.ProductoOrden;
import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.modelo.OrdenCompra;
import uniandes.edu.co.proyecto.repositorio.ProductoOrdenRepository;

@RestController
public class ProductoOrdenController {

    @Autowired
    private ProductoOrdenRepository productoOrdenRepository;

    // Obtener todos los registros de ProductoOrden
    @GetMapping("/productoOrdenes")
    public Collection<ProductoOrden> darProductoOrden() {
        return productoOrdenRepository.darProductoOrden();
    }

    // Obtener un registro específico de ProductoOrden por su clave primaria compuesta
    @GetMapping("/productoOrden/{id_producto}/{id_ordenCompra}")
    public ResponseEntity<ProductoOrden> darProductoOrdenPorId(@PathVariable("id_producto") Producto id_producto,
                                                               @PathVariable("id_ordenCompra") OrdenCompra id_ordenCompra) {
        try {
            ProductoOrden productoOrden = productoOrdenRepository.darProductoOrden(id_producto, id_ordenCompra);
            return new ResponseEntity<>(productoOrden, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Insertar un nuevo registro de ProductoOrden
    @PostMapping("/productoOrden/new/save")
    @Transactional
    public ResponseEntity<String> insertarProductoOrden(@RequestBody ProductoOrden productoOrden) {
        try {
            productoOrdenRepository.insertarProductoOrden(
                productoOrden.getPk().getId_producto(),
                productoOrden.getPk().getId_ordenCompra(),
                productoOrden.getPrecioAcordado(),
                productoOrden.getCantidadSolicitada()
            );
            return new ResponseEntity<>("ProductoOrden creada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el ProductoOrden", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar un registro existente de ProductoOrden
    @PutMapping("/productoOrden/{id_producto}/{id_ordenCompra}/edit/save")
    @Transactional
    public ResponseEntity<String> actualizarProductoOrden(@PathVariable("id_producto") Producto id_producto,
                                                          @PathVariable("id_ordenCompra") OrdenCompra id_ordenCompra,
                                                          @RequestBody ProductoOrden productoOrden) {
        try {
            productoOrdenRepository.actualizarProductoOrden(
                id_producto,
                id_ordenCompra,
                productoOrden.getPrecioAcordado(),
                productoOrden.getCantidadSolicitada()
            );
            return new ResponseEntity<>("ProductoOrden actualizada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el ProductoOrden", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Borrar un registro de ProductoOrden por su clave primaria compuesta
    @DeleteMapping("/productoOrden/{id_producto}/{id_ordenCompra}/delete")
    @Transactional
    public ResponseEntity<String> borrarProductoOrden(@PathVariable("id_producto") Producto id_producto,
                                                      @PathVariable("id_ordenCompra") OrdenCompra id_ordenCompra) {
        try {
            productoOrdenRepository.borrarProductoOrden(id_producto, id_ordenCompra);
            return new ResponseEntity<>("ProductoOrden eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el ProductoOrden", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener productos en una orden específica
    @GetMapping("/productoOrden/orden/{id_ordenCompra}")
    public ResponseEntity<Collection<ProductoOrden>> darProductosPorOrden(@PathVariable("id_ordenCompra") OrdenCompra id_ordenCompra) {
        try {
            Collection<ProductoOrden> productosOrden = productoOrdenRepository.darProductosPorOrden(id_ordenCompra);
            return new ResponseEntity<>(productosOrden, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Obtener órdenes que contienen un producto específico
    @GetMapping("/productoOrden/producto/{id_producto}")
    public ResponseEntity<Collection<ProductoOrden>> darOrdenesPorProducto(@PathVariable("id_producto") Producto id_producto) {
        try {
            Collection<ProductoOrden> ordenesProducto = productoOrdenRepository.darOrdenesPorProducto(id_producto);
            return new ResponseEntity<>(ordenesProducto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
