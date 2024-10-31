package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "info_recepcion")
public class InfoRecepcion {
    
    @EmbeddedId
    private InfoRecepcionPK pk;

    private int cantidad_recibida;

    private Double costo_recibido;


    public InfoRecepcion(Recepcion id_Recepcion, Producto id_Producto, int cantidad_recibida, Double costo_recibido) {
        super();
        this.pk = new InfoRecepcionPK(id_Recepcion, id_Producto);
        this.cantidad_recibida  = cantidad_recibida;
        this.costo_recibido = costo_recibido;
    }

    public InfoRecepcion()
    {;}
    
    public InfoRecepcionPK getPk() {
        return pk;
    }
    public void setPk(InfoRecepcionPK pk) {
        this.pk = pk;
    }
    public int getCantidadRecibida() {
        return cantidad_recibida;
    }
    public void setCantidadRecibida(int cantidad_recibida) {
        this.cantidad_recibida = cantidad_recibida;
    }
    public Double getCostoRecibido() {
        return costo_recibido;
    }
    public void setCostoRecibido(Double costo_recibido) {
        this.costo_recibido = costo_recibido;
    }
}
