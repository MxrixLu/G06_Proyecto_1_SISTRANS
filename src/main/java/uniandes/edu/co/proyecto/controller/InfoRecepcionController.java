package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.InfoRecepcion;
import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.modelo.Recepcion;
import uniandes.edu.co.proyecto.repositorio.InfoRecepcionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class InfoRecepcionController {

    @Autowired
    private InfoRecepcionRepository infoRecepcionRepository;

    @GetMapping("/infoRecepcion")
    public Collection<InfoRecepcion> infoRecepciones() {
        return infoRecepcionRepository.darInfoRecepcion();
    }

    @GetMapping("/infoRecepcion/{idRecepcion}/{idProducto}")
    public ResponseEntity<InfoRecepcion> obtenerInfoRecepcionPorId(@PathVariable("idRecepcion") int idRecepcion,
                                                                   @PathVariable("idProducto") int idProducto) {
        try {
            InfoRecepcion infoRecepcion = infoRecepcionRepository.darInfoRecepcionPorId(idRecepcion, idProducto);
            return new ResponseEntity<>(infoRecepcion, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/infoRecepcion/new/save")
    public ResponseEntity<String> guardarInfoRecepcion(@RequestBody InfoRecepcion infoRecepcion) {
        try {
            infoRecepcionRepository.insertarInfoRecepcion(
                infoRecepcion.getPk().getIdRecepcion(),
                infoRecepcion.getPk().getIdProducto(),
                infoRecepcion.getCantidadRecibida(),
                infoRecepcion.getCostoRecibido()
            );
            return new ResponseEntity<>("Info de Recepción creada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la info de recepción", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/infoRecepcion/{idRecepcion}/{idProducto}/edit/save")
    public ResponseEntity<String> actualizarInfoRecepcion(@PathVariable("idRecepcion") Recepcion idRecepcion,
                                                          @PathVariable("idProducto") Producto idProducto,
                                                          @RequestBody InfoRecepcion infoRecepcion) {
        try {
            infoRecepcionRepository.actualizarInfoRecepcion(
                idRecepcion,
                idProducto,
                infoRecepcion.getCantidadRecibida(),
                infoRecepcion.getCostoRecibido()
            );
            return new ResponseEntity<>("Info de Recepción actualizada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la info de recepción", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/infoRecepcion/{idRecepcion}/{idProducto}/delete")
    public ResponseEntity<String> borrarInfoRecepcion(@PathVariable("idRecepcion") Recepcion idRecepcion,
                                                      @PathVariable("idProducto") Producto idProducto) {
        try {
            infoRecepcionRepository.borrarInfoRecepcion(idRecepcion, idProducto);
            return new ResponseEntity<>("Info de Recepción eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la info de recepción", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
