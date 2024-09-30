package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "niveles_reorden")
public class NivelReOrden {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer nivelMaximo; 
    private Integer capacidadBodega; 

    @ManyToOne
    @JoinColumn(name = "id_sucursal", nullable = false)
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    public NivelReOrden(Integer id, Integer nivelMaximo, Integer capacidadBodega, Sucursal sucursal, Producto producto) {
        this.id = id;
        this.nivelMaximo = nivelMaximo;
        this.capacidadBodega = capacidadBodega;
        this.sucursal = sucursal;
        this.producto = producto;
    }

    public NivelReOrden() 
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNivelMaximo() {
        return nivelMaximo;
    }

    public void setNivelMaximo(Integer nivelMaximo) {
        this.nivelMaximo = nivelMaximo;
    }

    public Integer getCapacidadBodega() {
        return capacidadBodega;
    }

    public void setCapacidadBodega(Integer capacidadBodega) {
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
