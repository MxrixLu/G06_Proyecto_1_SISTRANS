package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ProductoOrdenPK implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    private Producto id_producto;

    @ManyToOne
    @JoinColumn(name = "id_ordenCompra", referencedColumnName = "id")
    private OrdenCompra id_ordenCompra;

    public ProductoOrdenPK(Producto id_producto, OrdenCompra id_ordenCompra) {
        this.id_producto = id_producto;
        this.id_ordenCompra = id_ordenCompra;
    }

    public ProductoOrdenPK() {
    }

    public Producto getId_producto() {
        return id_producto;
    }

    public void setId_producto(Producto id_producto) {
        this.id_producto = id_producto;
    }

    public OrdenCompra getId_ordenCompra() {
        return id_ordenCompra;
    }

    public void setId_ordenCompra(OrdenCompra id_ordenCompra) {
        this.id_ordenCompra = id_ordenCompra;
    }

    

}
