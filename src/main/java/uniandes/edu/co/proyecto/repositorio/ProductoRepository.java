package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.modelo.ProductoPK;

public interface ProductoRepository extends JpaRepository<Producto, ProductoPK> {

    // Obtener todos los productos
    @Query(value = "SELECT * FROM productos", nativeQuery = true)
    Collection<Producto> darProductos();

    // Obtener un producto por su clave primaria compuesta
    @Query(value = "SELECT * FROM productos WHERE id = :id AND codigoBarras = :codigoBarras", nativeQuery = true)
    Producto darProducto(@Param("id") int id, @Param("codigoBarras") String codigoBarras);

    // Insertar un nuevo producto
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productos (id, codigoBarras, nombre, costoBodega, precioVenta, presentacion, cantidadPresentacion, unidadMedida, volumenEmpaque, pesoEmpaque, fechaExpiracion, id_categoria) VALUES (:id, :codigoBarras, :nombre, :costoBodega, :precioVenta, :presentacion, :cantidadPresentacion, :unidadMedida, :volumenEmpaque, :pesoEmpaque, :fechaExpiracion, :id_categoria)", nativeQuery = true)
    void insertarProducto(@Param("id") int id,
                          @Param("codigoBarras") String codigoBarras,
                          @Param("nombre") String nombre,
                          @Param("costoBodega") Double costoBodega,
                          @Param("precioVenta") Double precioVenta,
                          @Param("presentacion") String presentacion,
                          @Param("cantidadPresentacion") Double cantidadPresentacion,
                          @Param("unidadMedida") Boolean unidadMedida,
                          @Param("volumenEmpaque") Double volumenEmpaque,
                          @Param("pesoEmpaque") Double pesoEmpaque,
                          @Param("fechaExpiracion") Date fechaExpiracion,
                          @Param("id_categoria") int idCategoria);

    // Actualizar un producto existente
    @Modifying
    @Transactional
    @Query(value = "UPDATE productos SET nombre = :nombre, costoBodega = :costoBodega, precioVenta = :precioVenta, presentacion = :presentacion, cantidadPresentacion = :cantidadPresentacion, unidadMedida = :unidadMedida, volumenEmpaque = :volumenEmpaque, pesoEmpaque = :pesoEmpaque, fechaExpiracion = :fechaExpiracion, id_categoria = :id_categoria WHERE id = :id AND codigoBarras = :codigoBarras", nativeQuery = true)
    void actualizarProducto(@Param("id") int id,
                            @Param("codigoBarras") String codigoBarras,
                            @Param("nombre") String nombre,
                            @Param("costoBodega") Double costoBodega,
                            @Param("precioVenta") Double precioVenta,
                            @Param("presentacion") String presentacion,
                            @Param("cantidadPresentacion") Double cantidadPresentacion,
                            @Param("unidadMedida") Boolean unidadMedida,
                            @Param("volumenEmpaque") Double volumenEmpaque,
                            @Param("pesoEmpaque") Double pesoEmpaque,
                            @Param("fechaExpiracion") Date fechaExpiracion,
                            @Param("id_categoria") int idCategoria);

    // Borrar un producto por su clave primaria compuesta
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM productos WHERE id = :id AND codigoBarras = :codigoBarras", nativeQuery = true)
    void borrarProducto(@Param("id") int id, @Param("codigoBarras") String codigoBarras);
}
