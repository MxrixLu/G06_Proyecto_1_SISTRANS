package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.NivelReOrden;
import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.modelo.Sucursal;

public interface NivelReOrdenRepository extends JpaRepository<NivelReOrden, Integer> {

    // Obtener todos los niveles de reorden
    @Query(value = "SELECT * FROM niveles_reorden", nativeQuery = true)
    Collection<NivelReOrden> darNivelesReOrden();

    // Obtener un nivel de reorden por su ID
    @Query(value = "SELECT * FROM niveles_reorden WHERE id = :id", nativeQuery = true)
    NivelReOrden darNivelReOrden(@Param("id") int id);

    // Insertar un nuevo nivel de reorden
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO niveles_reorden (id, nivelMinimo, id_sucursal, id_producto) VALUES (superandes_sequence.nextval, :id_sucursal, :id_producto, :nivelMinimo)", nativeQuery = true)
    void insertarNivelReOrden(@Param("nivelMinimo") int nivelMinimo, 
                              @Param("id_sucursal") Sucursal sucursal, 
                              @Param("id_producto") Producto producto);

    // Actualizar un nivel de reorden existente
    @Modifying
    @Transactional
    @Query(value = "UPDATE niveles_reorden SET nivelMinimo = :nivelMinimo, id_sucursal = :id_sucursal, id_producto = :id_producto WHERE id = :id", nativeQuery = true)
    void actualizarNivelReOrden(@Param("id") int id, 
                                @Param("nivelMinimo") int nivelMinimo, 
                                @Param("id_sucursal") Sucursal sucursal, 
                                @Param("id_producto") Producto producto);

    // Borrar un nivel de reorden por su ID
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM niveles_reorden WHERE id = :id", nativeQuery = true)
    void borrarNivelReOrden(@Param("id") int id);
}
