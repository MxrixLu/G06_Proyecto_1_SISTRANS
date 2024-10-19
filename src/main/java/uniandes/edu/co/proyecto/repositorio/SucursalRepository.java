package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Sucursal;
import uniandes.edu.co.proyecto.modelo.Ciudad;

public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {


    public interface RespuestaIndiceOcupacion {
        int getBodega_id();
        String getNombre_bodega();
        double getVolumen_ocupado();
        double getPorcentaje_ocupacion();
    }

    // Obtener todas las sucursales
    @Query(value = "SELECT * FROM sucursales", nativeQuery = true)
    Collection<Sucursal> darSucursales();

    // Obtener una sucursal por su ID
    @Query(value = "SELECT * FROM sucursales WHERE id = :id", nativeQuery = true)
    Sucursal darSucursal(@Param("id") int id);

    // Insertar una nueva sucursal
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO sucursales (id, nombre, telefono, direccion, tamano, id_ciudad) VALUES (superandes_sequence.nextval, :nombre, :telefono, :direccion, :tamano, :id_ciudad)", nativeQuery = true)
    void insertarSucursal(@Param("nombre") String nombre, 
                          @Param("telefono") String telefono, 
                          @Param("direccion") String direccion, 
                          @Param("tamano") Double tamano, 
                          @Param("id_ciudad") Ciudad id_ciudad);

    // Actualizar una sucursal existente
    @Modifying
    @Transactional
    @Query(value = "UPDATE sucursales SET nombre = :nombre, telefono = :telefono, direccion = :direccion, tamano = :tamano, id_ciudad = :id_ciudad WHERE id = :id", nativeQuery = true)
    void actualizarSucursal(@Param("id") int id, 
                            @Param("nombre") String nombre, 
                            @Param("telefono") String telefono, 
                            @Param("direccion") String direccion, 
                            @Param("tamano") Double tamano, 
                            @Param("id_ciudad") Ciudad id_ciudad);

    // Borrar una sucursal por su ID
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM sucursales WHERE id = :id", nativeQuery = true)
    void borrarSucursal(@Param("id") int id);

    @Query(value = "SELECT " +
               "b.id AS bodega_id, " +
               "b.nombre AS nombre_bodega, " +
               "SUM(pb.cantidadExistente * p.volumenEmpaque) AS volumen_ocupado, " +
               "(SUM(pb.cantidadExistente * p.volumenEmpaque) / b.capacidadBodega) * 100 AS porcentaje_ocupacion " +
               "FROM bodegas b " +
               "INNER JOIN producto_bodega pb ON pb.id_bodega = b.id " +
               "INNER JOIN productos p ON p.id = pb.id_producto " +
               "WHERE p.id IN (:listaDeProductos) " +
               "GROUP BY b.id, b.nombre, b.capacidadBodega", nativeQuery = true)
    Collection<RespuestaIndiceOcupacion> calcularIndiceOcupacion(@Param("listaDeProductos") List<Integer> listaDeProductos);

}
