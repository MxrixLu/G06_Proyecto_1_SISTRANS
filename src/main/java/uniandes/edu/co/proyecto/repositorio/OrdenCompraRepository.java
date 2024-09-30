package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.OrdenCompra;
import uniandes.edu.co.proyecto.modelo.Proveedor;
import uniandes.edu.co.proyecto.modelo.Sucursal;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Integer> {

    // Obtener todas las órdenes de compra
    @Query(value = "SELECT * FROM ordenes_compra", nativeQuery = true)
    Collection<OrdenCompra> darOrdenesCompra();

    // Obtener una orden de compra por su ID
    @Query(value = "SELECT * FROM ordenes_compra WHERE id = :id", nativeQuery = true)
    OrdenCompra darOrdenCompra(@Param("id") int id);

    // Insertar una nueva orden de compra
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ordenes_compra (id, fechaEsperadaEntrega, precioAcordado, estado, fechaCreacion, id_sucursal, id_proveedor) VALUES (superandes_sequence.nextval, :fechaEsperadaEntrega, :precioAcordado, :estado, :fechaCreacion, :id_sucursal, :id_proveedor)", nativeQuery = true)
    void insertarOrdenCompra(@Param("fechaEsperadaEntrega") Date fechaEsperadaEntrega,
                             @Param("precioAcordado") Double precioAcordado,
                             @Param("estado") String estado,
                             @Param("fechaCreacion") Date fechaCreacion,
                             @Param("id_sucursal") Sucursal sucursal,
                             @Param("id_proveedor") Proveedor proveedor);

    // Actualizar una orden de compra existente
    @Modifying
    @Transactional
    @Query(value = "UPDATE ordenes_compra SET fechaEsperadaEntrega = :fechaEsperadaEntrega, precioAcordado = :precioAcordado, estado = :estado, fechaCreacion = :fechaCreacion, id_sucursal = :id_sucursal, id_proveedor = :id_proveedor WHERE id = :id", nativeQuery = true)
    void actualizarOrdenCompra(@Param("id") int id,
                               @Param("fechaEsperadaEntrega") Date fechaEsperadaEntrega,
                               @Param("precioAcordado") Double precioAcordado,
                               @Param("estado") String estado,
                               @Param("fechaCreacion") Date fechaCreacion,
                               @Param("id_sucursal") Sucursal sucursal,
                               @Param("id_proveedor") Proveedor proveedor);

    // Borrar una orden de compra por su ID
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ordenes_compra WHERE id = :id", nativeQuery = true)
    void borrarOrdenCompra(@Param("id") int id);
}
