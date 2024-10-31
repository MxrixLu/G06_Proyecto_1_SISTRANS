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

    public interface RespuestaDarProductosConBodega {
        String getProducto();
        int getCantidadExistente();
        double getCostoPromedio();
        int getNivelMinimo();
    }

    public interface RespuestaDarSucursalesSegunProducto {
        String getNombre();
        String getDireccion();
        String getTelefono();
        Double getTamano();
        int getId_ciudad();
        
    }

    public interface RespuestaDarSucursalesNombreProducto {
        String getNombre();
        String getDireccion();
        String getTelefono();
        Double getTamano();
        int getId_ciudad();
        
    }
 
    @Query(value= "SELECT * FROM bodegas", nativeQuery = true)
    Collection<Bodega> darBodegas();

    @Query(value= "SELECT * FROM bodegas WHERE id = :id", nativeQuery = true)
    Bodega darBodega(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value= "INSERT INTO bodegas (id, nombre, tamano, sucursal_id) VALUES (superandes_sequence.nextval , :nombre, :tamano, :sucursal_id)", nativeQuery = true)
    void insertarBodega(@Param("nombre")  String nombre, @Param("tamano")  Double tamano, @Param("sucursal_id")  Sucursal sucursal);

    @Modifying
    @Transactional
    @Query(value = "UPDATE bodegas SET nombre = :nombre, tamano = :tamano, sucursal_id = :sucursal_id WHERE id = :id ", nativeQuery = true)
    void actualizarBodega(@Param("id") int id, @Param("nombre") String nombre, @Param("tamano")  Double tamano, @Param("sucursal_id")  Sucursal sucursal );

    @Modifying
    @Transactional
    @Query( value = "DELETE FROM bodegas WHERE id = :id", nativeQuery = true)
    void borrarBodega(@Param("id") int id);

    @Query(value = "SELECT p.nombre AS producto, pb.cantidad_existente, pb.costo_promedio, nro.nivel_minimo " +
    "FROM sucursales s " +
    "INNER JOIN bodegas b ON b.sucursal_id = s.id " +
    "INNER JOIN productos_bodega pb ON pb.bodega_id = b.id " +
    "INNER JOIN productos p ON p.id = pb.producto_id " +
    "LEFT JOIN niveles_reorden nro ON nro.producto_id = p.id AND nro.sucursal_id = s.id " +
    "WHERE s.id = :sucursal_id AND \n" + //
    " b.id = :bodega_id\n" + 
    "GROUP BY \n" + 
    " p.nombre, pb.cantidad_actual, pb.cantidad_minima;", nativeQuery = true)
    Collection<RespuestaDarProductosConBodega> darProductosConBodega(@Param("sucursal_id") int sucursal_id);

    @Query(value = "SELECT s.* " +
               "FROM sucursales s " +
               "INNER JOIN bodegas b ON b.sucursal_id = s.id " +
               "INNER JOIN productos_bodega pb ON pb.bodega_id = b.id " +
               "WHERE pb.producto_id = :producto_id", nativeQuery = true)
    Collection<RespuestaDarSucursalesSegunProducto> darSucursalesSegunProducto(@Param("producto_id") int producto_id);

    @Query(value = "SELECT s.* " +
    "FROM sucursales s " +
    "INNER JOIN bodegas b ON b.sucursal_id = s.id " +
    "INNER JOIN productos_bodega pb ON pb.bodega_id = b.id " +
    "INNER JOIN productos p ON p.id = pb.producto_id " +
    "WHERE p.nombre = :nombreProducto", nativeQuery = true)
    Collection<RespuestaDarSucursalesNombreProducto> darSucursalesNombreProducto(@Param("nombreProducto") String nombreProducto);


    
}
