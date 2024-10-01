package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

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

    private Date fechaRecepcion;

    @ManyToOne
    private Proveedor id_proveedor;

    @ManyToOne
    private Bodega id_bodega;

    public Recepcion(int id, Date fechaRecepcion, Proveedor id_proveedor, Bodega id_bodega) {
        this.id = id;
        this.fechaRecepcion = fechaRecepcion;
        this.id_proveedor = id_proveedor;
        this.id_bodega = id_bodega;
    }

    public Recepcion() {
    ;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Proveedor getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Proveedor id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public Bodega getId_bodega() {
        return id_bodega;
    }

    public void setId_bodega(Bodega id_bodega) {
        this.id_bodega = id_bodega;
    }

    
}
