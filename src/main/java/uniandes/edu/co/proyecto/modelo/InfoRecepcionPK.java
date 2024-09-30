package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne; 

@Embeddable
public class InfoRecepcionPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_Recepcion", referencedColumnName = "id")
    private Recepcion id_Recepcion; 

    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    private Producto id_producto;

    public InfoRecepcionPK(Recepcion id_Recepcion, Producto id_producto) {
        super();
        this.id_Recepcion = id_Recepcion;
        this.id_producto = id_producto;
    }

    public InfoRecepcionPK() {
        super();
    }

    public Recepcion getId_Recepcion() {
        return id_Recepcion;
    }

    public void setId_Recepcion(Recepcion id_Recepcion) {
        this.id_Recepcion = id_Recepcion;
    }

    public Producto getId_producto() {
        return id_producto;
    }

    public void setId_producto(Producto id_producto) {
        this.id_producto = id_producto;
    } 

    
    
}
