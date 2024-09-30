package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "info_recepcion")
public class InfoRecepcion {
    
    @EmbeddedId
    private InfoRecepcionPK pk;

    public InfoRecepcion(Recepcion id_Recepcion, Producto id_Producto) {
        this.pk = new InfoRecepcionPK(id_Recepcion, id_Producto);
    }
    public InfoRecepcion()
    {;}
}
