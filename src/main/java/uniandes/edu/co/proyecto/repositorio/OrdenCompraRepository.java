package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import uniandes.edu.co.proyecto.modelo.OrdenCompra;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Integer> {
    
}
