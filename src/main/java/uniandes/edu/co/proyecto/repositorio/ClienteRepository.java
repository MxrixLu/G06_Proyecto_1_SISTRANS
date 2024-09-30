package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import uniandes.edu.co.proyecto.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
}
