package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
 
import jakarta.persistence.ManyToOne;

@Embeddable
public class ProductoOrdenPK implements Serializable {
    
    @ManyToOne
    private Producto producto_id;

    @ManyToOne
    private OrdenCompra orden_compra_id;

    public ProductoOrdenPK(Producto producto_id, OrdenCompra orden_compra_id) {
        this.producto_id = producto_id;
        this.orden_compra_id = orden_compra_id;
    }

    public ProductoOrdenPK() {
    }

    public Producto getId_producto() {
        return producto_id;
    }

    public void setId_producto(Producto producto_id) {
        this.producto_id = producto_id;
    }

    public OrdenCompra getId_ordenCompra() {
        return orden_compra_id;
    }

    public void setId_ordenCompra(OrdenCompra orden_compra_id) {
        this.orden_compra_id = orden_compra_id;
    }

    

}
