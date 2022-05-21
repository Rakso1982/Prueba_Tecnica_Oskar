package com.colfondos.PruebaTecnica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class PruebaTecnicaApplication {
    
    @Autowired
    private JdbcTemplate template;

    public static void main(String[] args) {
        SpringApplication.run(PruebaTecnicaApplication.class, args);
    }
    
    /*
    public void run(String... args) throws Exception {
        System.out.println("Oskar3");
        System.out.println("Oskar4");
        template.execute("CREATE TABLE Tipo_Documento_Modelo(idTipoDocumento INTEGER NOT NULL,descripcion VARCHAR(255) NOT NULL,PRIMARY KEY (idTipoDocumento))");
        template.execute("CREATE TABLE Informacion_Cliente_Modelo(identificacion VARCHAR(10) NOT NULL,idTipoDocumento INTEGER NOT NULL,correo VARCHAR(255) NOT NULL,celular INTEGER NOT NULL,PRIMARY KEY (identificacion))");
        template.execute("INSERT INTO TipoDocumento (idTipoDocumento, descripcion) VALUES (1, 'Cedula')");

    }
    */

}
