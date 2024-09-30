package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "ordenes_compra")
public class OrdenCompra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date fechaEsperadaEntrega; 
    private Double precioAcordado;
    private String estado; 
    private Date fechaCreacion; 

    @ManyToOne
    @JoinColumn(name = "id_sucursal", nullable = false)
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedor proveedor;

    public OrdenCompra(int id, Date fechaEsperadaEntrega, Double precioAcordado, String estado, Date fechaCreacion,
            Sucursal sucursal, Proveedor proveedor) {
        this.id = id;
        this.fechaEsperadaEntrega = fechaEsperadaEntrega;
        this.precioAcordado = precioAcordado;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.sucursal = sucursal;
        this.proveedor = proveedor;
    }

    public OrdenCompra() 
    {;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaEsperadaEntrega() {
        return fechaEsperadaEntrega;
    }

    public void setFechaEsperadaEntrega(Date fechaEsperadaEntrega) {
        this.fechaEsperadaEntrega = fechaEsperadaEntrega;
    }

    public Double getPrecioAcordado() {
        return precioAcordado;
    }

    public void setPrecioAcordado(Double precioAcordado) {
        this.precioAcordado = precioAcordado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Proveedor getproveedor() {
        return proveedor;
    }

    public void setproveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    
}
