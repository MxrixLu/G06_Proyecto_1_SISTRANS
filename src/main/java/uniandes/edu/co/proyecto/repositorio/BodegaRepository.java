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
    @Query(value= "INSERT INTO bodegas (id, nombre, tamano, id_sucursal) VALUES (superandes_sequence.nextval , :nombre, :tamano, :id_sucursal)", nativeQuery = true)
    void insertarBodega(@Param("nombre")  String nombre, @Param("tamano")  Double tamano, @Param("id_sucursal")  Sucursal sucursal);

    @Modifying
    @Transactional
    @Query(value = "UPDATE bodegas SET nombre = :nombre, tamano = :tamano, id_sucursal = :id_sucursal WHERE id = :id ", nativeQuery = true)
    void actualizarBodega(@Param("id") int id, @Param("nombre") String nombre, @Param("tamano")  Double tamano, @Param("id_sucursal")  Sucursal sucursal );

    @Modifying
    @Transactional
    @Query( value = "DELETE FROM bodegas WHERE id = :id", nativeQuery = true)
    void borrarBodega(@Param("id") int id);

    @Query(value = "SELECT p.nombre AS producto, pb.cantidadExistente, pb.costoPromedio, nro.nivelMinimo " +
    "FROM sucursales s " +
    "INNER JOIN bodegas b ON b.id_sucursal = s.id " +
    "INNER JOIN productos_bodega pb ON pb.id_bodega = b.id " +
    "INNER JOIN productos p ON p.id = pb.id_producto " +
    "LEFT JOIN niveles_reorden nro ON nro.id_producto = p.id AND nro.id_sucursal = s.id " +
    "WHERE s.id = :id_sucursal AND \n" + //
    " b.id = :id_bodega\n" + 
    "GROUP BY \n" + 
    " p.nombre, pb.cantidad_actual, pb.cantidad_minima;", nativeQuery = true)
    Collection<RespuestaDarProductosConBodega> darProductosConBodega(@Param("id_sucursal") int id_sucursal);

    @Query(value = "SELECT s.* " +
               "FROM sucursales s " +
               "INNER JOIN bodegas b ON b.id_sucursal = s.id " +
               "INNER JOIN productos_bodega pb ON pb.id_bodega = b.id " +
               "WHERE pb.id_producto = :idProducto", nativeQuery = true)
    Collection<RespuestaDarSucursalesSegunProducto> darSucursalesSegunProducto(@Param("idProducto") int idProducto);

    @Query(value = "SELECT s.* " +
    "FROM sucursales s " +
    "INNER JOIN bodegas b ON b.id_sucursal = s.id " +
    "INNER JOIN productos_bodega pb ON pb.id_bodega = b.id " +
    "INNER JOIN productos p ON p.id = pb.id_producto " +
    "WHERE p.nombre = :nombreProducto", nativeQuery = true)
    Collection<RespuestaDarSucursalesNombreProducto> darSucursalesNombreProducto(@Param("nombreProducto") String nombreProducto);


    
}
