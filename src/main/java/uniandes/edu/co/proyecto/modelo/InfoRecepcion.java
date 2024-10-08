package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "info_recepcion")
public class InfoRecepcion {
    
    @EmbeddedId
    private InfoRecepcionPK pk;

    private int cantidadRecibida;

    private Double costoRecibido;


    public InfoRecepcion(Recepcion id_Recepcion, Producto id_Producto, int cantidadRecibida, Double costoRecibido) {
        super();
        this.pk = new InfoRecepcionPK(id_Recepcion, id_Producto);
        this.cantidadRecibida  = cantidadRecibida;
        this.costoRecibido = costoRecibido;
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
        return cantidadRecibida;
    }
    public void setCantidadRecibida(int cantidadRecibida) {
        this.cantidadRecibida = cantidadRecibida;
    }
    public Double getCostoRecibido() {
        return costoRecibido;
    }
    public void setCostoRecibido(Double costoRecibido) {
        this.costoRecibido = costoRecibido;
    }
}
