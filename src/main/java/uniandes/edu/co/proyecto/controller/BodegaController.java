package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class BodegaController {
    
    @Autowired
    private BodegaRepository bodegaRepository;


    @GetMapping("/bodegas")
    public Collection<Bodega> bodegas() {
        return bodegaRepository.darBodegas();
    }

    @PostMapping("/bodegas/new/save")
    public ResponseEntity<String> guardarBodega(@RequestBody Bodega bodega) {
        try{
            bodegaRepository.insertarBodega(bodega.getNombre(), bodega.getTamano(), bodega.getSucursal());
            return new  ResponseEntity<> ("Bodega creada exitosamente", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Error al crear la bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/bodegas/{id}/edit/save")
    public ResponseEntity<String> bodegaEditarGuardar(@PathVariable("id") Integer id, @RequestBody Bodega bodega) {
        try{
            bodegaRepository.actualizarBodega(id, bodega.getNombre(), bodega.getTamano(), bodega.getSucursal());
            return new ResponseEntity<>("La bodega se actualizo exitosamente", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Error al actualizar la bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/bodegas/{id}/delete")
    public ResponseEntity<String> borrarBodegas(@PathVariable("id") Integer id) {
        try {    
            bodegaRepository.borrarBodega(id);
            return new ResponseEntity<>("La bodega se elimino exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    
    
    

    
}
