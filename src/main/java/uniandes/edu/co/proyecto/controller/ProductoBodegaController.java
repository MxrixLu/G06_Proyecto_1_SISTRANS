package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.ProductoBodega;
import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.repositorio.ProductoBodegaRepository;

@RestController
public class ProductoBodegaController {

    @Autowired
    private ProductoBodegaRepository productoBodegaRepository;

    // Obtener todos los registros de ProductoBodega
    @GetMapping("/productoBodegas")
    public Collection<ProductoBodega> darProductoBodega() {
        return productoBodegaRepository.darProductoBodega();
    }

    // Obtener un registro específico de ProductoBodega por su clave primaria compuesta
    @GetMapping("/productoBodega/{id_producto}/{id_bodega}")
    public ResponseEntity<ProductoBodega> darProductoBodegaPorId(@PathVariable("id_producto") Producto id_producto,
                                                                 @PathVariable("id_bodega") Bodega id_bodega) {
        try {
            ProductoBodega productoBodega = productoBodegaRepository.darProductoBodega(id_producto, id_bodega);
            return new ResponseEntity<>(productoBodega, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Insertar un nuevo registro de ProductoBodega
    @PostMapping("/productoBodega/new/save")
    @Transactional
    public ResponseEntity<String> insertarProductoBodega(@RequestBody ProductoBodega productoBodega) {
        try {
            productoBodegaRepository.insertarProductoBodega(
                productoBodega.getPk().getId_producto(),
                productoBodega.getPk().getId_bodega(),
                productoBodega.getCantidadExistente(),
                productoBodega.getCostoPromedio(), 
                productoBodega.getCapacidadBodega()
            );
            return new ResponseEntity<>("ProductoBodega creada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el ProductoBodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar un registro existente de ProductoBodega
    @PutMapping("/productoBodega/{id_producto}/{id_bodega}/edit/save")
    @Transactional
    public ResponseEntity<String> actualizarProductoBodega(@PathVariable("id_producto") Producto id_producto,
                                                           @PathVariable("id_bodega") Bodega id_bodega,
                                                           @RequestBody ProductoBodega productoBodega) {
        try {
            productoBodegaRepository.actualizarProductoBodega(
                id_producto,
                id_bodega,
                productoBodega.getCantidadExistente(),
                productoBodega.getCostoPromedio(), 
                productoBodega.getCapacidadBodega()
            );
            return new ResponseEntity<>("ProductoBodega actualizada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el ProductoBodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Borrar un registro de ProductoBodega por su clave primaria compuesta
    @DeleteMapping("/productoBodega/{id_producto}/{id_bodega}/delete")
    @Transactional
    public ResponseEntity<String> borrarProductoBodega(@PathVariable("id_producto") Producto id_producto,
                                                       @PathVariable("id_bodega") Bodega id_bodega) {
        try {
            productoBodegaRepository.borrarProductoBodega(id_producto, id_bodega);
            return new ResponseEntity<>("ProductoBodega eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el ProductoBodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener productos en una bodega específica
    @GetMapping("/productoBodega/bodega/{id_bodega}")
    public ResponseEntity<Collection<ProductoBodega>> darProductosPorBodega(@PathVariable("id_bodega") Bodega id_bodega) {
        try {
            Collection<ProductoBodega> productosBodega = productoBodegaRepository.darProductosPorBodega(id_bodega);
            return new ResponseEntity<>(productosBodega, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Obtener bodegas que contienen un producto específico
    @GetMapping("/productoBodega/producto/{id_producto}")
    public ResponseEntity<Collection<ProductoBodega>> darBodegasPorProducto(@PathVariable("id_producto") Producto id_producto) {
        try {
            Collection<ProductoBodega> bodegasProducto = productoBodegaRepository.darBodegasPorProducto(id_producto);
            return new ResponseEntity<>(bodegasProducto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
