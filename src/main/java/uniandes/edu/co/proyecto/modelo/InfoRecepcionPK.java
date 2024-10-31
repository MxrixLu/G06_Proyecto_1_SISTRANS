package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
 
import jakarta.persistence.ManyToOne; 

@Embeddable
public class InfoRecepcionPK implements Serializable {

    @ManyToOne
    private Recepcion id_Recepcion; 

    @ManyToOne
    private Producto producto_id;

    public InfoRecepcionPK(Recepcion id_Recepcion, Producto producto_id) {
        super();
        this.id_Recepcion = id_Recepcion;
        this.producto_id = producto_id;
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
        return producto_id;
    }

    public void setIdProducto(Producto producto_id) {
        this.producto_id = producto_id;
    } 

    
    
}
