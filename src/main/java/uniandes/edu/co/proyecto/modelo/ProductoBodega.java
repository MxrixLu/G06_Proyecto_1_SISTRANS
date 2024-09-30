package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto_bodega")
public class ProductoBodega {
    
    @EmbeddedId
    private ProductoBodegaPK pk;

    private Integer cantidadExistente;
    private Double costoPromedio;


    public ProductoBodega( Producto id_Producto, Bodega id_Bodega, Integer cantidadExistente, Double costoPromedio) {
        this.pk = new ProductoBodegaPK( id_Producto, id_Bodega);
        this.cantidadExistente = cantidadExistente;
        this.costoPromedio = costoPromedio;
    }
    public ProductoBodega()
    {;}
    public ProductoBodegaPK getPk() {
        return pk;
    }
    public void setPk(ProductoBodegaPK pk) {
        this.pk = pk;
    }
    public Integer getCantidadExistente() {
        return cantidadExistente;
    }
    public void setCantidadExistente(Integer cantidadExistente) {
        this.cantidadExistente = cantidadExistente;
    }
    public Double getCostoPromedio() {
        return costoPromedio;
    }
    public void setCostoPromedio(Double costoPromedio) {
        this.costoPromedio = costoPromedio;
    }

    
}
