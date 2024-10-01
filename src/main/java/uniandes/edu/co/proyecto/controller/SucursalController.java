package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.Sucursal;
import uniandes.edu.co.proyecto.repositorio.SucursalRepository;

@RestController
@RequestMapping("/sucursales")
public class SucursalController {

    @Autowired
    private SucursalRepository sucursalRepository;

    // Obtener todas las sucursales
    @GetMapping
    public Collection<Sucursal> darSucursales() {
        return sucursalRepository.darSucursales();
    }

    // Obtener una sucursal por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Sucursal> darSucursalPorId(@PathVariable("id") int id) {
        try {
            Sucursal sucursal = sucursalRepository.darSucursal(id);
            return new ResponseEntity<>(sucursal, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Insertar una nueva sucursal
    @PostMapping("/new/save")
    @Transactional
    public ResponseEntity<String> insertarSucursal(@RequestBody Sucursal sucursal) {
        try {
            sucursalRepository.insertarSucursal(
                sucursal.getId(),
                sucursal.getNombre(),
                sucursal.getTelefono(),
                sucursal.getDireccion(),
                sucursal.getTamano(),
                sucursal.getId_ciudad()
            );
            return new ResponseEntity<>("Sucursal creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la sucursal", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar una sucursal existente
    @PutMapping("/{id}/edit/save")
    @Transactional
    public ResponseEntity<String> actualizarSucursal(@PathVariable("id") int id,
                                                    @RequestBody Sucursal sucursal) {
        try {
            sucursalRepository.actualizarSucursal(
                id,
                sucursal.getNombre(),
                sucursal.getTelefono(),
                sucursal.getDireccion(),
                sucursal.getTamano(),
                sucursal.getId_ciudad()
            );
            return new ResponseEntity<>("Sucursal actualizada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la sucursal", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Borrar una sucursal por su ID
    @DeleteMapping("/{id}/delete")
    @Transactional
    public ResponseEntity<String> borrarSucursal(@PathVariable("id") int id) {
        try {
            sucursalRepository.borrarSucursal(id);
            return new ResponseEntity<>("Sucursal eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la sucursal", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
