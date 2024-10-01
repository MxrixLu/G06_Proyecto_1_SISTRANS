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

    private int nivelMaximo; 
    private int capacidadBodega; 

    @ManyToOne
    private Sucursal sucursal;

    @ManyToOne
    private Producto producto;

    public NivelReOrden(int id, int nivelMaximo, int capacidadBodega, Sucursal sucursal, Producto producto) {
        this.id = id;
        this.nivelMaximo = nivelMaximo;
        this.capacidadBodega = capacidadBodega;
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

    public int getNivelMaximo() {
        return nivelMaximo;
    }

    public void setNivelMaximo(int nivelMaximo) {
        this.nivelMaximo = nivelMaximo;
    }

    public int getCapacidadBodega() {
        return capacidadBodega;
    }

    public void setCapacidadBodega(int capacidadBodega) {
        this.capacidadBodega = capacidadBodega;
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
