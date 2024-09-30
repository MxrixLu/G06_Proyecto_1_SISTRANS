package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import uniandes.edu.co.proyecto.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    
}
