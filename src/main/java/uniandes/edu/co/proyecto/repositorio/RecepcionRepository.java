package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Recepcion;
import uniandes.edu.co.proyecto.modelo.Proveedor;
import uniandes.edu.co.proyecto.modelo.Bodega;

public interface RecepcionRepository extends JpaRepository<Recepcion, Integer> {

    // Obtener todas las recepciones
    @Query(value = "SELECT * FROM recepciones", nativeQuery = true)
    Collection<Recepcion> darRecepciones();

    // Obtener una recepcion por su ID
    @Query(value = "SELECT * FROM recepciones WHERE id = :id", nativeQuery = true)
    Recepcion darRecepcion(@Param("id") int id);

    // Insertar una nueva recepcion
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO recepciones (id, fechaRecepcion, id_proveedor, id_bodega) VALUES (:id, :fechaRecepcion, :id_proveedor, :id_bodega)", nativeQuery = true)
    void insertarRecepcion(@Param("id") int id, 
                           @Param("fechaRecepcion") Date fechaRecepcion, 
                           @Param("id_proveedor") Proveedor id_proveedor, 
                           @Param("id_bodega") Bodega id_bodega);

    // Actualizar una recepcion existente
    @Modifying
    @Transactional
    @Query(value = "UPDATE recepciones SET fechaRecepcion = :fechaRecepcion, id_proveedor = :id_proveedor, id_bodega = :id_bodega WHERE id = :id", nativeQuery = true)
    void actualizarRecepcion(@Param("id") int id, 
                             @Param("fechaRecepcion") Date fechaRecepcion, 
                             @Param("id_proveedor") Proveedor id_proveedor, 
                             @Param("id_bodega") Bodega id_bodega);

    // Borrar una recepcion por su ID
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM recepciones WHERE id = :id", nativeQuery = true)
    void borrarRecepcion(@Param("id") int id);
}
