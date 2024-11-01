package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository.RespuestaDarProductosConBodega;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository.RespuestaDarSucursalesNombreProducto;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository.RespuestaDarSucursalesSegunProducto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class BodegaController {
    
    @Autowired
    private BodegaRepository bodegaRepository;


    @GetMapping("/bodegas")
    public Collection<Bodega> bodegas() {
        return bodegaRepository.darBodegas();
    }

    @GetMapping("/bodegas/consultaBodega")
    public ResponseEntity<?> darProductosConBodega(@RequestParam(required = false) int sucursal_id) {
        try {
            Collection<RespuestaDarProductosConBodega> bodegas = bodegaRepository.darProductosConBodega(sucursal_id);
            RespuestaDarProductosConBodega info = bodegas.iterator().next();
            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("producto", info.getProducto());
            respuesta.put("cantidad_existente", info.getCantidadExistente());
            respuesta.put("costo_promedio", info.getCostoPromedio());
            respuesta.put("nivel_minimo", info.getNivelMinimo());
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/bodegas/consultarSucursalNombre")
    public ResponseEntity<?> darSucursalesNombreProducto(@RequestParam(required = false) String nombreProducto) {
        try {
            Collection<RespuestaDarSucursalesNombreProducto> bodegas = bodegaRepository.darSucursalesNombreProducto(nombreProducto);
            RespuestaDarSucursalesNombreProducto info = bodegas.iterator().next();
            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("nombre", info.getNombre());
            respuesta.put("direccion", info.getDireccion());
            respuesta.put("telefono", info.getTelefono());
            respuesta.put("tamano", info.getTamano());
            respuesta.put("ciudad_id", info.getCiudad());
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    
    @GetMapping("/bodegas/consultarSucursalProducto")
    public ResponseEntity<?> darSucursalesSegunProducto(@RequestParam(required = false) int producto_id) {
        // try {
            System.out.println("El producto es" + producto_id);
            Collection<RespuestaDarSucursalesSegunProducto> bodegas = bodegaRepository.darSucursalesSegunProducto(producto_id);
            RespuestaDarSucursalesSegunProducto info = bodegas.iterator().next();
            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("nombre", info.getNombre());
            respuesta.put("direccion", info.getDireccion());
            respuesta.put("telefono", info.getTelefono());
            respuesta.put("tamano", info.getTamano());
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        // } catch (Exception e) {
        //     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        // }
    }

    @PostMapping("/bodegas/new/save")
    public ResponseEntity<String> insertarBodega(@RequestBody Bodega bodega) {
        try{
            bodegaRepository.insertarBodega(bodega.getNombre(), bodega.getTamano(), bodega.getSucursal());
            return new  ResponseEntity<> ("Bodega creada exitosamente", HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>("Error al crear la bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/bodegas/{id}/edit/save")
    public ResponseEntity<String> actualizarBodega(@PathVariable("id") int id, @RequestBody Bodega bodega) {
        try{
            bodegaRepository.actualizarBodega(id, bodega.getNombre(), bodega.getTamano(), bodega.getSucursal());
            return new ResponseEntity<>("La bodega se actualizo exitosamente", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Error al actualizar la bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/bodegas/{id}/delete")
    public ResponseEntity<String> borrarBodegas(@PathVariable("id") int id) {
        try {    
            bodegaRepository.borrarBodega(id);
            return new ResponseEntity<>("La bodega se elimino exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    
    
    

    
}
