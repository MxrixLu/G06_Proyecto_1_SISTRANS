package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto_bodega")
public class ProductoBodega {
    
    @EmbeddedId
    private ProductoBodegaPK pk;

    private int cantidadExistente;
    private Double costoPromedio;

    private int capacidadBodega;


    public ProductoBodega( Producto id_Producto, Bodega id_Bodega, int cantidadExistente, Double costoPromedio, int capacidadBodega) {
        this.pk = new ProductoBodegaPK( id_Producto, id_Bodega);
        this.cantidadExistente = cantidadExistente;
        this.costoPromedio = costoPromedio;
        this.capacidadBodega = capacidadBodega;
    }
    public ProductoBodega()
    {;}
    public int getCapacidadBodega() {
        return capacidadBodega;
    }
    public void setCapacidadBodega(int capacidadBodega) {
        this.capacidadBodega = capacidadBodega;
    }
    public ProductoBodegaPK getPk() {
        return pk;
    }
    public void setPk(ProductoBodegaPK pk) {
        this.pk = pk;
    }
    public int getCantidadExistente() {
        return cantidadExistente;
    }
    public void setCantidadExistente(int cantidadExistente) {
        this.cantidadExistente = cantidadExistente;
    }
    public Double getCostoPromedio() {
        return costoPromedio;
    }
    public void setCostoPromedio(Double costoPromedio) {
        this.costoPromedio = costoPromedio;
    }

    
}
