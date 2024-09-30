package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import uniandes.edu.co.proyecto.modelo.ProductoBodega;
import uniandes.edu.co.proyecto.modelo.ProductoBodegaPK;

public interface ProductoBodegaRepository extends JpaRepository<ProductoBodega, ProductoBodegaPK> {
    
}
