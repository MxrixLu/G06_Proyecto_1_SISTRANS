package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto_orden")
public class ProductoOrden {
    
    @EmbeddedId
    private ProductoOrdenPK pk;

    public ProductoOrden(Producto id_producto, OrdenCompra id_orden) {
        //this.pk = new ProductoOrden(id_producto, id_orden);
    }
    

}
