package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import uniandes.edu.co.proyecto.modelo.InfoRecepcion;
import uniandes.edu.co.proyecto.modelo.InfoRecepcionPK;

public interface InfoRecepcionRepository extends JpaRepository<InfoRecepcion, InfoRecepcionPK>{
    
}
