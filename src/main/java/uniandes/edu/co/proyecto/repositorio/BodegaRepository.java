package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.modelo.Sucursal;


public interface BodegaRepository extends JpaRepository<Bodega, Integer> {
 
    @Query(value= "SELECT * FROM bodegas", nativeQuery = true)
    Collection<Bodega> darBodegas();

    @Query(value= "SELECT * FROM bodegas WHERE id = :id", nativeQuery = true)
    Bodega darBodega(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value= "INSERT INTO bodegas (id, nombre, tamano, id_sucursal) VALUES (superandes_sequence.nextval , :nombre, :tamano, :id_sucursal)", nativeQuery = true)
    void insertarBodega(@Param("nombre")  String nombre, @Param("tamano")  Double tamano, @Param("id_sucursal")  Sucursal sucursal);

    @Modifying
    @Transactional
    @Query(value = "UPDATE bodegas SET nombre = :nombre, tamano = :tamano, id_sucursal = :id_sucursal WHERE id = :id ", nativeQuery = true)
    void actualizarBodega(@Param("id") int id, @Param("nombre") String nombre, @Param("tamano")  Double tamano, @Param("id_sucursal")  Sucursal sucursal );

    @Modifying
    @Transactional
    @Query( value = "DELETE FROM bodegas WHERE id = :id", nativeQuery = true)
    void borrarBodega(@Param("id") int id);
}
