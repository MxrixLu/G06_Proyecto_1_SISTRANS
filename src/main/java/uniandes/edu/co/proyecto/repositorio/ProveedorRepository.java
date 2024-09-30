package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

    // Obtener todos los proveedores
    @Query(value = "SELECT * FROM proovedores", nativeQuery = true)
    Collection<Proveedor> darProveedores();

    // Obtener un proveedor por su ID
    @Query(value = "SELECT * FROM proovedores WHERE id = :id", nativeQuery = true)
    Proveedor darProveedor(@Param("id") int id);

    // Insertar un nuevo proveedor
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO proovedores (id, NIT, direccion, nombrePersonaC, telefonoPersonaC) VALUES (:id, :NIT, :direccion, :nombrePersonaC, :telefonoPersonaC)", nativeQuery = true)
    void insertarProveedor(@Param("id") int id, 
                           @Param("NIT") String NIT, 
                           @Param("direccion") String direccion, 
                           @Param("nombrePersonaC") String nombrePersonaC, 
                           @Param("telefonoPersonaC") String telefonoPersonaC);

    // Actualizar un proveedor existente
    @Modifying
    @Transactional
    @Query(value = "UPDATE proovedores SET NIT = :NIT, direccion = :direccion, nombrePersonaC = :nombrePersonaC, telefonoPersonaC = :telefonoPersonaC WHERE id = :id", nativeQuery = true)
    void actualizarProveedor(@Param("id") int id, 
                             @Param("NIT") String NIT, 
                             @Param("direccion") String direccion, 
                             @Param("nombrePersonaC") String nombrePersonaC, 
                             @Param("telefonoPersonaC") String telefonoPersonaC);

    // Borrar un proveedor por su ID
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM proovedores WHERE id = :id", nativeQuery = true)
    void borrarProveedor(@Param("id") int id);
}
