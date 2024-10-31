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

    @Query(value = "SELECT * FROM producto_bodega", nativeQuery = true)
    Collection<ProductoBodega> darProductoBodega();

    @Query(value = "SELECT * FROM producto_bodega WHERE producto_id = :producto_id AND bodega_id = :bodega_id", nativeQuery = true)
    ProductoBodega darProductoBodega(@Param("producto_id") Producto producto_id, @Param("bodega_id") Bodega bodega_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO producto_bodega (producto_id, bodega_id, cantidad_existente, costo_promedio, capacidad_bodega) VALUES (:producto_id, :bodega_id, :cantidad_existente, :costo_promedio, :capacidad_bodega)", nativeQuery = true)
    void insertarProductoBodega(@Param("producto_id") Producto producto_id,
                                 @Param("bodega_id") Bodega bodega_id,
                                 @Param("cantidad_existente") int cantidad_existente,
                                 @Param("costo_promedio") Double costo_promedio, 
                                 @Param("capacidad_bodega") int capacidad_bodega);

    @Modifying
    @Transactional
    @Query(value = "UPDATE producto_bodega SET cantidad_existente = :cantidad_existente, costo_promedio = :costo_promedio , capacidad_bodega= :capacidad_bodega WHERE producto_id = :producto_id AND bodega_id = :bodega_id", nativeQuery = true)
    void actualizarProductoBodega(@Param("producto_id") Producto producto_id,
                                   @Param("bodega_id") Bodega bodega_id,
                                   @Param("cantidad_existente") int cantidad_existente,
                                   @Param("costo_promedio") Double costo_promedio, 
                                   @Param("capacidad_bodega") int capacidad_bodega);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM producto_bodega WHERE producto_id = :producto_id AND bodega_id = :bodega_id", nativeQuery = true)
    void borrarProductoBodega(@Param("producto_id") Producto producto_id, @Param("bodega_id") Bodega bodega_id);
    
    @Query(value = "SELECT * FROM producto_bodega WHERE bodega_id = :bodega_id", nativeQuery = true)
    Collection<ProductoBodega> darProductosPorBodega(@Param("bodega_id") Bodega bodega_id);

    @Query(value = "SELECT * FROM producto_bodega WHERE producto_id = :producto_id", nativeQuery = true)
    Collection<ProductoBodega> darBodegasPorProducto(@Param("producto_id") Producto producto_id);
}
