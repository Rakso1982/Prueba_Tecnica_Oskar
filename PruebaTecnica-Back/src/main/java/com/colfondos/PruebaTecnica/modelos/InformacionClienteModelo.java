package com.colfondos.PruebaTecnica.modelos;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Oskar
 */
@Entity
@Table(name = "Informacion_Cliente_Modelo")
public class InformacionClienteModelo implements Serializable {
    @Id
    @Column(name = "identificacion", unique = true, length = 10)
    private String identificacion;

    private int id;
    private String correo;
    @Column(length = 10)
    private String celular;

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
