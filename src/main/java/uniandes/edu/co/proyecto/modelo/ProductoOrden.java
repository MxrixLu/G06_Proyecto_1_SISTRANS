package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto_orden")
public class ProductoOrden {
    
    @EmbeddedId
    private ProductoOrdenPK pk;

    private Double precioAcordado; 

    private int cantidadSolicitada;

    public ProductoOrden(Producto id_producto, OrdenCompra id_orden, Double precioAcordado, int cantidadSolicitada) {
        this.pk = new ProductoOrdenPK(id_producto, id_orden);
        this.precioAcordado = precioAcordado;
        this.cantidadSolicitada = cantidadSolicitada;
    }
    
    public ProductoOrden()
    {;}

    public ProductoOrdenPK getPk() {
        return pk;
    }

    public void setPk(ProductoOrdenPK pk) {
        this.pk = pk;
    }

    public Double getPrecioAcordado() {
        return precioAcordado;
    }

    public void setPrecioAcordado(Double precioAcordado) {
        this.precioAcordado = precioAcordado;
    }

    public int getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    public void setCantidadSolicitada(int cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }

    
}
