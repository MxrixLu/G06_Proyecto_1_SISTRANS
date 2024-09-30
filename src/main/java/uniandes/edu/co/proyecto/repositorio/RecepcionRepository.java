package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import uniandes.edu.co.proyecto.modelo.Recepcion;

public interface RecepcionRepository extends JpaRepository<Recepcion, Integer> {
    
}
