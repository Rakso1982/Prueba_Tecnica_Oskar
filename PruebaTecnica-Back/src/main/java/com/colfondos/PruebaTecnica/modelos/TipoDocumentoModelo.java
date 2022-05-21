package com.colfondos.PruebaTecnica.modelos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Oskar
 */
@Entity
@Table(name = "Tipo_Documento_Modelo")
public class TipoDocumentoModelo implements Serializable {
    @Id
    @Column(name = "id", unique = true)
    private int id;

    private String descripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
