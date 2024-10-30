package uniandes.edu.co.proyecto.modelo;

import java.util.Date;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
 
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {
    
    @EmbeddedId
    private ProductoPK pk;

    private String nombre; 
    private Double costoBodega; 
    private Double precioVenta; 
    private String presentacion; 
    private Double cantidadPresentacion; 
    private int unidadMedida;
    private Double volumenEmpaque; 
    private Double pesoEmpaque; 
    private String fechaExpiracion; 

    @ManyToOne
    private Categoria categoria;

    public Producto(int id, String codigoBarras, String nombre, Double costoBodega, Double precioVenta, String presentacion,
            Double cantidadPresentacion, int unidadMedida, Double volumenEmpaque, Double pesoEmpaque,
            String fechaExpiracion, Categoria categoria) {
        this.pk = new ProductoPK(id, codigoBarras);
        this.nombre = nombre;
        this.costoBodega = costoBodega;
        this.precioVenta = precioVenta;
        this.presentacion = presentacion;
        this.cantidadPresentacion = cantidadPresentacion;
        this.unidadMedida = unidadMedida;
        this.volumenEmpaque = volumenEmpaque;
        this.pesoEmpaque = pesoEmpaque;
        this.fechaExpiracion = fechaExpiracion;
        this.categoria = categoria;
    }

    public Producto() 
    {;}

    public ProductoPK getPk() {
        return pk;
    }

    public void setPk(ProductoPK pk) {
        this.pk = pk;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCostoBodega() {
        return costoBodega;
    }

    public void setCostoBodega(Double costoBodega) {
        this.costoBodega = costoBodega;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public Double getCantidadPresentacion() {
        return cantidadPresentacion;
    }

    public void setCantidadPresentacion(Double cantidadPresentacion) {
        this.cantidadPresentacion = cantidadPresentacion;
    }

    public int getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(int unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Double getVolumenEmpaque() {
        return volumenEmpaque;
    }

    public void setVolumenEmpaque(Double volumenEmpaque) {
        this.volumenEmpaque = volumenEmpaque;
    }

    public Double getPesoEmpaque() {
        return pesoEmpaque;
    }

    public void setPesoEmpaque(Double pesoEmpaque) {
        this.pesoEmpaque = pesoEmpaque;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    
}
