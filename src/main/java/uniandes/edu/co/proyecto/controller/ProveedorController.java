package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.Proveedor;
import uniandes.edu.co.proyecto.repositorio.ProveedorRepository;

@RestController
public class ProveedorController {

    @Autowired
    private ProveedorRepository proveedorRepository;

    // Obtener todos los proveedores
    @GetMapping("/proveedores")
    public Collection<Proveedor> darProveedores() {
        return proveedorRepository.darProveedores();
    }

    // Obtener un proveedor por su ID
    @GetMapping("/proveedores/{id}")
    public ResponseEntity<Proveedor> darProveedorPorId(@PathVariable("id") int id) {
        try {
            Proveedor proveedor = proveedorRepository.darProveedor(id);
            return new ResponseEntity<>(proveedor, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Insertar un nuevo proveedor
    @PostMapping("/proveedores/new/save")
    @Transactional
    public ResponseEntity<String> insertarProveedor(@RequestBody Proveedor proveedor) {
        try {
            proveedorRepository.insertarProveedor(
                proveedor.getId(),
                proveedor.getNIT(),
                proveedor.getDireccion(),
                proveedor.getNombrePersonaC(),
                proveedor.getTelefonoPersonaC()
            );
            return new ResponseEntity<>("Proveedor creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar un proveedor existente
    @PutMapping("/proveedores/{id}/edit/save")
    @Transactional
    public ResponseEntity<String> actualizarProveedor(@PathVariable("id") int id,
                                                     @RequestBody Proveedor proveedor) {
        try {
            proveedorRepository.actualizarProveedor(
                id,
                proveedor.getNIT(),
                proveedor.getDireccion(),
                proveedor.getNombrePersonaC(),
                proveedor.getTelefonoPersonaC()
            );
            return new ResponseEntity<>("Proveedor actualizado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Borrar un proveedor por su ID
    @DeleteMapping("/proveedores/{id}/delete")
    @Transactional
    public ResponseEntity<String> borrarProveedor(@PathVariable("id") int id) {
        try {
            proveedorRepository.borrarProveedor(id);
            return new ResponseEntity<>("Proveedor eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
