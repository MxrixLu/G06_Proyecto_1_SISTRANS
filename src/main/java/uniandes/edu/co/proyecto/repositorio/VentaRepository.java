package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Venta;
import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Producto;

public interface VentaRepository extends JpaRepository<Venta, Integer> {

    // Obtener todas las ventas
    @Query(value = "SELECT * FROM ventas", nativeQuery = true)
    Collection<Venta> darVentas();

    // Obtener una venta por su ID
    @Query(value = "SELECT * FROM ventas WHERE id = :id", nativeQuery = true)
    Venta darVenta(@Param("id") int id);

    // Insertar una nueva venta
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ventas (id, fecha, cantidad, precioUnitario, cedula, id_cliente, id_producto) VALUES (:id, :fecha, :cantidad, :precioUnitario, :cedula, :id_cliente, :id_producto)", nativeQuery = true)
    void insertarVenta(@Param("id") int id, 
                       @Param("fecha") Date fecha, 
                       @Param("cantidad") int cantidad, 
                       @Param("precioUnitario") int precioUnitario, 
                       @Param("cedula") int cedula, 
                       @Param("id_cliente") Cliente cliente, 
                       @Param("id_producto") Producto producto);

    // Actualizar una venta existente
    @Modifying
    @Transactional
    @Query(value = "UPDATE ventas SET fecha = :fecha, cantidad = :cantidad, precioUnitario = :precioUnitario, cedula = :cedula, id_cliente = :id_cliente, id_producto = :id_producto WHERE id = :id", nativeQuery = true)
    void actualizarVenta(@Param("id") int id, 
                         @Param("fecha") Date fecha, 
                         @Param("cantidad") int cantidad, 
                         @Param("precioUnitario") int precioUnitario, 
                         @Param("cedula") int cedula, 
                         @Param("id_cliente") Cliente cliente, 
                         @Param("id_producto") Producto producto);

    // Borrar una venta por su ID
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ventas WHERE id = :id", nativeQuery = true)
    void borrarVenta(@Param("id") int id);
}
