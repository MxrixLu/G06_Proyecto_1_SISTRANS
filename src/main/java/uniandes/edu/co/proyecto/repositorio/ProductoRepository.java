package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.modelo.ProductoPK;

public interface ProductoRepository extends JpaRepository<Producto, ProductoPK>{
     
}
