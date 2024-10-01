package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
 
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "niveles_reorden")
public class NivelReOrden {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int nivelMinimo; 

    @ManyToOne
    private Sucursal sucursal;

    @ManyToOne
    private Producto producto;

    public NivelReOrden(int id, int nivelMinimo, Sucursal sucursal, Producto producto) {
        this.id = id;
        this.nivelMinimo = nivelMinimo;
        this.sucursal = sucursal;
        this.producto = producto;
    }

    public NivelReOrden() 
    {;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNivelMinimo() {
        return nivelMinimo;
    }

    public void setNivelMinimo(int nivelMinimo) {
        this.nivelMinimo = nivelMinimo;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
}
