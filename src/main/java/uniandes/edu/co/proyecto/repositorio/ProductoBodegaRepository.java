package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.modelo.ProductoBodega;
import uniandes.edu.co.proyecto.modelo.ProductoBodegaPK;

public interface ProductoBodegaRepository extends JpaRepository<ProductoBodega, ProductoBodegaPK> {

    // Obtener todos los registros de ProductoBodega
    @Query(value = "SELECT * FROM producto_bodega", nativeQuery = true)
    Collection<ProductoBodega> darProductoBodega();

    // Obtener un registro específico de ProductoBodega por su clave primaria compuesta
    @Query(value = "SELECT * FROM producto_bodega WHERE id_producto = :id_producto AND id_bodega = :id_bodega", nativeQuery = true)
    ProductoBodega darProductoBodega(@Param("id_producto") Producto id_producto, @Param("id_bodega") Bodega id_bodega);

    // Insertar un nuevo registro de ProductoBodega, utilizando las entidades asociadas
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO producto_bodega (id_producto, id_bodega, cantidadExistente, costoPromedio) VALUES (:id_producto, :id_bodega, :cantidadExistente, :costoPromedio)", nativeQuery = true)
    void insertarProductoBodega(@Param("id_producto") Producto id_producto,
                                 @Param("id_bodega") Bodega id_bodega,
                                 @Param("cantidadExistente") int cantidadExistente,
                                 @Param("costoPromedio") Double costoPromedio);

    // Actualizar un registro existente de ProductoBodega
    @Modifying
    @Transactional
    @Query(value = "UPDATE producto_bodega SET cantidadExistente = :cantidadExistente, costoPromedio = :costoPromedio WHERE id_producto = :id_producto AND id_bodega = :id_bodega", nativeQuery = true)
    void actualizarProductoBodega(@Param("id_producto") Producto id_producto,
                                   @Param("id_bodega") Bodega id_bodega,
                                   @Param("cantidadExistente") int cantidadExistente,
                                   @Param("costoPromedio") Double costoPromedio);

    // Borrar un registro de ProductoBodega por su clave primaria compuesta
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM producto_bodega WHERE id_producto = :id_producto AND id_bodega = :id_bodega", nativeQuery = true)
    void borrarProductoBodega(@Param("id_producto") Producto id_producto, @Param("id_bodega") Bodega id_bodega);
    
    // Obtener productos en una bodega específica
    @Query(value = "SELECT * FROM producto_bodega WHERE id_bodega = :id_bodega", nativeQuery = true)
    Collection<ProductoBodega> darProductosPorBodega(@Param("id_bodega") Bodega id_bodega);

    // Obtener bodegas que contienen un producto específico
    @Query(value = "SELECT * FROM producto_bodega WHERE id_producto = :id_producto", nativeQuery = true)
    Collection<ProductoBodega> darBodegasPorProducto(@Param("id_producto") Producto id_producto);
}
