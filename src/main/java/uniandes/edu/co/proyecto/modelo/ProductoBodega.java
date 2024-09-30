package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto_bodega")
public class ProductoBodega {
    
    @EmbeddedId
    private ProductoBodegaPK pk;

    public ProductoBodega(Bodega id_Bodega, Producto id_Producto) {
        //this.pk = new ProductoBodega(id_Bodega, id_Producto);
    }
    public ProductoBodega()
    {;}
}
