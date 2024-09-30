package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "proovedores")
public class Proveedor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String NIT; 
    private String direccion;
    private String nombrePersonaC;
    private String telefonoPersonaC;

    public Proveedor(int id, String nIT, String direccion, String nombrePersonaC, String telefonoPersonaC) {
        this.id = id;
        NIT = nIT;
        this.direccion = direccion;
        this.nombrePersonaC = nombrePersonaC;
        this.telefonoPersonaC = telefonoPersonaC;
    } 
    
    public Proveedor() 
    {;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String nIT) {
        NIT = nIT;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombrePersonaC() {
        return nombrePersonaC;
    }

    public void setNombrePersonaC(String nombrePersonaC) {
        this.nombrePersonaC = nombrePersonaC;
    }

    public String getTelefonoPersonaC() {
        return telefonoPersonaC;
    }

    public void setTelefonoPersonaC(String telefonoPersonaC) {
        this.telefonoPersonaC = telefonoPersonaC;
    }

    
    
}
