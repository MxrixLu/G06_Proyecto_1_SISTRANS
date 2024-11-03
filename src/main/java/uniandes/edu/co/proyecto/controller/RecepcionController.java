package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.Recepcion;
import uniandes.edu.co.proyecto.repositorio.RecepcionRepository;
import uniandes.edu.co.proyecto.servicios.RecepcionService;


@RestController
public class RecepcionController {

    @Autowired
    private RecepcionRepository recepcionRepository;
    private RecepcionService recepcionService;

    // Obtener todas las recepciones
    @GetMapping("/recepciones")
    public Collection<Recepcion> darRecepciones() {
        return recepcionRepository.darRecepciones();
    }

    // Obtener una recepción por su ID
    @GetMapping("/recepciones/{id}")
    public ResponseEntity<Recepcion> darRecepcionPorId(@PathVariable("id") int id) {
        try {
            Recepcion recepcion = recepcionRepository.darRecepcion(id);
            return new ResponseEntity<>(recepcion, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // // Insertar una nueva recepción
    @PostMapping("/recepciones/new/save")
    @Transactional
    public ResponseEntity<String> insertarRecepcion(@RequestBody Recepcion recepcion) {
        try {
            recepcionRepository.insertarRecepcion(
                recepcion.getId(),
                recepcion.getFechaRecepcion(),
                recepcion.getId_proveedor().getId(),
                recepcion.getId_bodega().getId()
            );
            return new ResponseEntity<>("Recepción creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la recepción", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/recepciones/hoy")
    public ResponseEntity<Recepcion> darRecepcionHoy() {
        // try {
            Recepcion recepcion = recepcionRepository.darRecepcionHoy();
            return new ResponseEntity<>(recepcion, HttpStatus.OK);
        // } catch (Exception e) {
        //     return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        // }
    }
    
    // Actualizar una recepción existente
    @PutMapping("/recepciones/{id}/edit/save")
    @Transactional
    public ResponseEntity<String> actualizarRecepcion(@PathVariable("id") int id,
                                                     @RequestBody Recepcion recepcion) {
        try {
            recepcionRepository.actualizarRecepcion(
                id,
                recepcion.getFechaRecepcion(),
                recepcion.getId_proveedor().getId(),
                recepcion.getId_bodega().getId()
            );
            return new ResponseEntity<>("Recepción actualizada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la recepción", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Borrar una recepción por su ID
    @DeleteMapping("/recepciones/{id}/delete")
    @Transactional
    public ResponseEntity<String> borrarRecepcion(@PathVariable("id") int id) {
        try {
            recepcionRepository.borrarRecepcion(id);
            return new ResponseEntity<>("Recepción eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la recepción", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //---------------Transacciones----------------//

    @GetMapping("/recepciones/consultaIngresoProductoBodega_SERIALIZABLE")
    public ResponseEntity<String> consultaIngresoProductoBodega_SERIALIZABLE(@RequestParam int sucursal_id, @RequestParam int bodega_id) {
        try {
            recepcionService.consultaIngresoProductoBodega_SERIALIZABLE(sucursal_id, bodega_id);
            return new ResponseEntity<>("Consulta de documento de ingreso de productos a bodega realizado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al consultar el documento de ingreso de productos a bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
