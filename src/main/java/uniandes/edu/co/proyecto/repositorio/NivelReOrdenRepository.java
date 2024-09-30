package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import uniandes.edu.co.proyecto.modelo.NivelReOrden;

public interface NivelReOrdenRepository extends JpaRepository<NivelReOrden, Integer> {
    
}
