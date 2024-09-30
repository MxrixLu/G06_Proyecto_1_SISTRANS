package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import uniandes.edu.co.proyecto.modelo.Venta;

public interface VentaRepository extends JpaRepository<Venta, Integer> {
    
}
