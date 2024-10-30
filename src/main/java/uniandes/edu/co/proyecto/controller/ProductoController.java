package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.modelo.ProductoPK;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository.RespuestaDarProductosPorCaracteristica;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository.RespuestaListarProductosReorden;


@RestController
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    @GetMapping("/productos")
    public Collection<Producto> darProductos() {
        return productoRepository.darProductos();
    }

    @GetMapping("/productos/consulta")
    public ResponseEntity<?> listarProductosReOrdenConsulta() {
        try {
            Collection<RespuestaListarProductosReorden> productos = productoRepository.listarProductosReorden();
            RespuestaListarProductosReorden info = productos.iterator().next();
            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("procentajeOcupacion", info.getNit_proveedor());
            respuesta.put("nombreProducto", info.getNombre_producto());
            respuesta.put("idProducto", info.getId_producto());
            respuesta.put("nombreBodega", info.getNombre_bodega());
            respuesta.put("nombreSucursal", info.getNombre_sucursal());
            respuesta.put("cantidadExistente", info.getCantidadExistente());
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/productos/consultaCaracteristica")
    public ResponseEntity<?> darProductoPorCaracteristica(@RequestParam(required = false) Double precioMinimo, @RequestParam(required = false) Double precioMaximo, @RequestParam(required = false) Date fechaInicio, @RequestParam(required = false) Date fechaFin, @RequestParam(required = false) int idCategoria) {
        try {
            Collection<RespuestaDarProductosPorCaracteristica> productos = productoRepository.darProductosPorCaracteristicas(precioMinimo, precioMaximo, fechaInicio, fechaFin, idCategoria);
            RespuestaDarProductosPorCaracteristica info = productos.iterator().next();
            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("nombre", info.getNombre());
            respuesta.put("codigoBarras", info.getCodigoBarras());
            respuesta.put("costoBodega", info.getCostoBodega());
            respuesta.put("precioVenta", info.getPrecioVenta());
            respuesta.put("presentacion", info.getPresentacion());
            respuesta.put("cantidadPresentacion", info.getCantidadPresentacion());
            respuesta.put("unidadMedida", info.getUnidadMedida());
            respuesta.put("volumenEmpaque", info.getVolumenEmpaque());
            respuesta.put("pesoEmpaque", info.getPesoEmpaque());
            respuesta.put("fechaExpiracion", info.getFechaExpiracion());
            respuesta.put("id_categoria", info.getId_categoria());
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // Obtener un producto por su clave primaria compuesta
    @GetMapping("/productos/{id}/{codigoBarras}")
    public ResponseEntity<Producto> darProductoPorId(@PathVariable("id") int id, @PathVariable("codigoBarras") String codigoBarras) {
        try {
            Producto producto = productoRepository.darProducto(id, codigoBarras);
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Insertar un nuevo producto
    @PostMapping("/productos/new/save")
    @Transactional
    public ResponseEntity<String> insertarProducto(@RequestBody Producto producto) {
        // try {
            System.err.println("Empieza insertar productos");
            ProductoPK pk = producto.getPk();
            String codigoBarras = pk.getCodigoBarras();
            System.err.println(codigoBarras + "Este es el codigo de barras creado");
            productoRepository.insertarProducto(
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
            return new ResponseEntity<>("Producto creado exitosamente", HttpStatus.CREATED);
        // } catch (Exception e) {
        //     return new ResponseEntity<>("Error al crear el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        // }
    }

    // Actualizar un producto existente
    @PutMapping("/productos/{id}/{codigoBarras}/edit/save")
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
    @DeleteMapping("/productos/{id}/{codigoBarras}/delete")
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
