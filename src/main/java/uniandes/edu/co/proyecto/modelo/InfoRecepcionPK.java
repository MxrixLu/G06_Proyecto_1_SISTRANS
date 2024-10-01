package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
 
import jakarta.persistence.ManyToOne; 

@Embeddable
public class InfoRecepcionPK implements Serializable {

    @ManyToOne
    private Recepcion id_Recepcion; 

    @ManyToOne
    private Producto id_producto;

    public InfoRecepcionPK(Recepcion id_Recepcion, Producto id_producto) {
        super();
        this.id_Recepcion = id_Recepcion;
        this.id_producto = id_producto;
    }

    public InfoRecepcionPK() {
        super();
    }

    public Recepcion getIdRecepcion() {
        return id_Recepcion;
    }

    public void setIdRecepcion(Recepcion id_Recepcion) {
        this.id_Recepcion = id_Recepcion;
    }

    public Producto getIdProducto() {
        return id_producto;
    }

    public void setIdProducto(Producto id_producto) {
        this.id_producto = id_producto;
    } 

    
    
}
