package uniandes.edu.co.proyecto.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
 
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "recepciones")
public class Recepcion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String fecha_recepcion;

    @ManyToOne
    private Proveedor proveedor_id;

    @ManyToOne
    private Bodega bodega_id;

    public Recepcion(int id, String fecha_recepcion, Proveedor proveedor_id, Bodega bodega_id) {
        this.id = id;
        this.fecha_recepcion = fecha_recepcion;
        this.proveedor_id = proveedor_id;
        this.bodega_id = bodega_id;
    }

    public Recepcion() {
    ;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaRecepcion() {
        return fecha_recepcion;
    }

    public void setFechaRecepcion(String fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    public Proveedor getId_proveedor() {
        return proveedor_id;
    }

    public void setId_proveedor(Proveedor proveedor_id) {
        this.proveedor_id = proveedor_id;
    }

    public Bodega getId_bodega() {
        return bodega_id;
    }

    public void setId_bodega(Bodega bodega_id) {
        this.bodega_id = bodega_id;
    }

    
}
