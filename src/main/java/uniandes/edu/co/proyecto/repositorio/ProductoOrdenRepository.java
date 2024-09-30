package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import uniandes.edu.co.proyecto.modelo.ProductoOrden;
import uniandes.edu.co.proyecto.modelo.ProductoOrdenPK;

public interface ProductoOrdenRepository extends JpaRepository<ProductoOrden, ProductoOrdenPK>{
    
}
