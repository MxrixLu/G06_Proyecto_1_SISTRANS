package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.InfoRecepcion;
import uniandes.edu.co.proyecto.modelo.InfoRecepcionPK;
import uniandes.edu.co.proyecto.modelo.Recepcion;
import uniandes.edu.co.proyecto.modelo.Producto;

public interface InfoRecepcionRepository extends JpaRepository<InfoRecepcion, InfoRecepcionPK> {

    // Obtener todas las entradas de recepción
    @Query(value = "SELECT * FROM info_recepcion", nativeQuery = true)
    Collection<InfoRecepcion> darInfoRecepcion();

    // Obtener una entrada de recepción por su clave primaria compuesta
    @Query(value = "SELECT * FROM info_recepcion WHERE id_Recepcion = :idRecepcion AND id_producto = :idProducto", nativeQuery = true)
    InfoRecepcion darInfoRecepcionPorId(@Param("idRecepcion") int idRecepcion, @Param("idProducto") int idProducto);

    // Insertar una nueva entrada de recepción
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO info_recepcion (id_Recepcion, id_producto, cantidadRecibida, costoRecibido) VALUES (:idRecepcion, :idProducto, :cantidadRecibida, :costoRecibido)", nativeQuery = true)
    void insertarInfoRecepcion(@Param("idRecepcion") Recepcion idRecepcion, 
                               @Param("idProducto") Producto idProducto, 
                               @Param("cantidadRecibida") int cantidadRecibida, 
                               @Param("costoRecibido") Double costoRecibido);

    // Actualizar una entrada de recepción existente
    @Modifying
    @Transactional
    @Query(value = "UPDATE info_recepcion SET cantidadRecibida = :cantidadRecibida, costoRecibido = :costoRecibido WHERE id_Recepcion = :idRecepcion AND id_producto = :idProducto", nativeQuery = true)
    void actualizarInfoRecepcion(@Param("idRecepcion") Recepcion idRecepcion, 
                                  @Param("idProducto") Producto idProducto, 
                                  @Param("cantidadRecibida") int cantidadRecibida, 
                                  @Param("costoRecibido") Double costoRecibido);

    // Borrar una entrada de recepción por su clave primaria compuesta
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM info_recepcion WHERE id_Recepcion = :idRecepcion AND id_producto = :idProducto", nativeQuery = true)
    void borrarInfoRecepcion(@Param("idRecepcion") Recepcion idRecepcion, @Param("idProducto") Producto idProducto);
}
