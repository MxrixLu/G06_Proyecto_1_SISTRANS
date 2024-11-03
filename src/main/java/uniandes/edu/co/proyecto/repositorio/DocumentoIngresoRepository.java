package uniandes.edu.co.proyecto.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.proyecto.modelo.DocumentoIngreso;

@Repository
public interface DocumentoIngresoRepository extends JpaRepository<DocumentoIngreso, Long> {

    @Query("SELECT d FROM DocumentoIngreso d " +
           "WHERE d.sucursal.id = :sucursalId " +
           "AND d.bodega.id = :bodegaId " +
           "AND d.fecha >= CURRENT_DATE - 30")
    List<DocumentoIngreso> findDocumentosIngreso(@Param("sucursalId") Long sucursalId,
                                                 @Param("bodegaId") Long bodegaId);
}
