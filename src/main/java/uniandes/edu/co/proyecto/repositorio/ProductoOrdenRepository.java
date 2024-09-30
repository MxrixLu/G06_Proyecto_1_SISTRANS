package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.OrdenCompra;
import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.modelo.ProductoOrden;
import uniandes.edu.co.proyecto.modelo.ProductoOrdenPK;

public interface ProductoOrdenRepository extends JpaRepository<ProductoOrden, ProductoOrdenPK> {

    // Obtener todos los registros de ProductoOrden
    @Query(value = "SELECT * FROM producto_orden", nativeQuery = true)
    Collection<ProductoOrden> darProductoOrden();

    // Obtener un registro específico de ProductoOrden por su clave primaria compuesta
    @Query(value = "SELECT * FROM producto_orden WHERE id_producto = :id_producto AND id_ordenCompra = :id_ordenCompra", nativeQuery = true)
    ProductoOrden darProductoOrden(@Param("id_producto") Producto id_producto, @Param("id_ordenCompra") OrdenCompra id_ordenCompra);

    // Insertar un nuevo registro de ProductoOrden, utilizando las entidades asociadas
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO producto_orden (id_producto, id_ordenCompra, precioAcordado, cantidadSolicitada) VALUES (:id_producto, :id_ordenCompra, :precioAcordado, :cantidadSolicitada)", nativeQuery = true)
    void insertarProductoOrden(@Param("id_producto") Producto id_producto,
                               @Param("id_ordenCompra") OrdenCompra id_ordenCompra,
                               @Param("precioAcordado") Double precioAcordado,
                               @Param("cantidadSolicitada") int cantidadSolicitada);

    // Actualizar un registro existente de ProductoOrden
    @Modifying
    @Transactional
    @Query(value = "UPDATE producto_orden SET precioAcordado = :precioAcordado, cantidadSolicitada = :cantidadSolicitada WHERE id_producto = :id_producto AND id_ordenCompra = :id_ordenCompra", nativeQuery = true)
    void actualizarProductoOrden(@Param("id_producto") Producto id_producto,
                                 @Param("id_ordenCompra") OrdenCompra id_ordenCompra,
                                 @Param("precioAcordado") Double precioAcordado,
                                 @Param("cantidadSolicitada") int cantidadSolicitada);

    // Borrar un registro de ProductoOrden por su clave primaria compuesta
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM producto_orden WHERE id_producto = :id_producto AND id_ordenCompra = :id_ordenCompra", nativeQuery = true)
    void borrarProductoOrden(@Param("id_producto") Producto id_producto, @Param("id_ordenCompra") OrdenCompra id_ordenCompra);
    
    // Obtener productos en una orden específica
    @Query(value = "SELECT * FROM producto_orden WHERE id_ordenCompra = :id_ordenCompra", nativeQuery = true)
    Collection<ProductoOrden> darProductosPorOrden(@Param("id_ordenCompra") OrdenCompra id_ordenCompra);

    // Obtener órdenes que contienen un producto específico
    @Query(value = "SELECT * FROM producto_orden WHERE id_producto = :id_producto", nativeQuery = true)
    Collection<ProductoOrden> darOrdenesPorProducto(@Param("id_producto") Producto id_producto);
}
