package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Recepcion;

public interface RecepcionRepository extends JpaRepository<Recepcion, Integer> {

    // Obtener todas las recepciones
    @Query(value = "SELECT * FROM recepciones", nativeQuery = true)
    Collection<Recepcion> darRecepciones();

    // Obtener una recepcion por su ID
    @Query(value = "SELECT * FROM recepciones WHERE id = :id", nativeQuery = true)
    Recepcion darRecepcion(@Param("id") int id);

    @Query(value = "SELECT * FROM recepciones", nativeQuery = true)
    Recepcion darRecepcionHoy();

    // Insertar una nueva recepcion
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO recepciones (id, fecha_recepcion, proveedor_id, bodega_id) VALUES (:id, :fecha_recepcion, :proveedor_id, :bodega_id )", nativeQuery = true)
    void insertarRecepcion(@Param("id") int id, 
                           @Param("fecha_recepcion") String fecha_recepcion, 
                           @Param("proveedor_id") int proveedor_id, 
                           @Param("bodega_id") int bodega_id);

    // // Actualizar una recepcion existente
    @Modifying
    @Transactional
    @Query(value = "UPDATE recepciones SET fecha_recepcion = :fecha_recepcion, proveedor_id = :proveedor_id, bodega_id = :bodega_id WHERE id = :id", nativeQuery = true)
    void actualizarRecepcion(@Param("id") int id, 
                             @Param("fecha_recepcion") String fecha_recepcion, 
                             @Param("proveedor_id") int proveedor_id, 
                             @Param("bodega_id") int bodega_id);

    // Borrar una recepcion por su ID
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM recepciones WHERE id = :id", nativeQuery = true)
    void borrarRecepcion(@Param("id") int id);
}
