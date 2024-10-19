package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Categoria;
import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.modelo.ProductoPK;

public interface ProductoRepository extends JpaRepository<Producto, ProductoPK> {

    public interface RespuestaListarProductosReorden {
        String getNombre_producto();
        int getId_producto();
        String getNombre_bodega();
        String getNombre_sucursal();
        int getCantidadExistente();
        String getNit_proveedor();
        
    }

    public interface RespuestaDarProductosPorCaracteristica {
        String getNombre();
        String getCodigoBarras();
        Double getCostoBodega();
        Double getPrecioVenta();
        String getPresentacion();
        Double getCantidadPresentacion();
        Boolean getUnidadMedida();
        Double getVolumenEmpaque();
        Double getPesoEmpaque();
        Date getFechaExpiracion();
        int getId_categoria();
    
        
    }

    // Obtener todos los productos
    @Query(value = "SELECT * FROM productos", nativeQuery = true)
    Collection<Producto> darProductos();

    // Obtener un producto por su clave primaria compuesta
    @Query(value = "SELECT * FROM productos WHERE id = :id AND codigoBarras = :codigoBarras", nativeQuery = true)
    Producto darProducto(@Param("id") int id, @Param("codigoBarras") String codigoBarras);

    // Insertar un nuevo producto
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productos (id, codigoBarras, nombre, costoBodega, precioVenta, presentacion, cantidadPresentacion, unidadMedida, volumenEmpaque, pesoEmpaque, fechaExpiracion, id_categoria) VALUES (superandes_sequence.nextval, :codigoBarras, :nombre, :costoBodega, :precioVenta, :presentacion, :cantidadPresentacion, :unidadMedida, :volumenEmpaque, :pesoEmpaque, TO_DATE(:fechaExpiracion,  'YYYY-MM-DD'), :id_categoria)", nativeQuery = true)
    void insertarProducto(
                          @Param("codigoBarras") String codigoBarras,
                          @Param("nombre") String nombre,
                          @Param("costoBodega") Double costoBodega,
                          @Param("precioVenta") Double precioVenta,
                          @Param("presentacion") String presentacion,
                          @Param("cantidadPresentacion") Double cantidadPresentacion,
                          @Param("unidadMedida") int unidadMedida,
                          @Param("volumenEmpaque") Double volumenEmpaque,
                          @Param("pesoEmpaque") Double pesoEmpaque,
                          @Param("fechaExpiracion") Date fechaExpiracion,
                          @Param("id_categoria") Categoria id_categoria);

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
                            @Param("unidadMedida") int unidadMedida,
                            @Param("volumenEmpaque") Double volumenEmpaque,
                            @Param("pesoEmpaque") Double pesoEmpaque,
                            @Param("fechaExpiracion") Date fechaExpiracion,
                            @Param("id_categoria") int idCategoria);

    // Borrar un producto por su clave primaria compuesta
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM productos WHERE id = :id AND codigoBarras = :codigoBarras", nativeQuery = true)
    void borrarProducto(@Param("id") int id, @Param("codigoBarras") String codigoBarras);


    @Query(value = "SELECT * FROM productos WHERE precioVenta BETWEEN :precioMinimo AND :precioMaximo AND fechaExpiracion BETWEEN :fechaInicio AND :fechaFin AND id_categoria.id = :idCategoria", nativeQuery = true)
    Collection<RespuestaDarProductosPorCaracteristica> darProductosPorCaracteristicas(@Param("precioMinimo") Double precioMinimo, @Param("precioMaximo") Double precioMaximo, @Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, @Param("idCategoria") int idCategoria);

    @Query(value = "SELECT " +
               "p.nombre AS nombre_producto, " +
               "p.id AS id_producto, " +
               "b.nombre AS nombre_bodega, " +
               "s.nombre AS nombre_sucursal, " +
               "pb.cantidadExistente, " +
               "pro.NIT AS nit_proveedor " +
               "FROM productos p " +
               "INNER JOIN niveles_reorden nro ON nro.id_producto = p.id " +
               "INNER JOIN producto_bodega pb ON pb.id_producto = p.id " +
               "INNER JOIN bodegas b ON pb.id_bodega = b.id " +
               "INNER JOIN sucursales s ON s.id = b.id_sucursal " +
               "LEFT JOIN info_recepcion ir ON ir.id_producto = p.id " +
               "LEFT JOIN recepciones r ON ir.id_recepcion = r.id " +
               "LEFT JOIN proveedores pro ON r.id_proveedor = pro.id " +
               "WHERE pb.cantidadExistente < nro.nivelMinimo " +
               "ORDER BY nombre_producto, nombre_bodega", nativeQuery = true)
    Collection<RespuestaListarProductosReorden> listarProductosReorden();

}

