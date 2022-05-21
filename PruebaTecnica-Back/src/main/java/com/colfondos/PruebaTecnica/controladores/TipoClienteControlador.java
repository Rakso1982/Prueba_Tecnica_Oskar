package com.colfondos.PruebaTecnica.controladores;

import com.colfondos.PruebaTecnica.modelos.TipoDocumentoModelo;
import com.colfondos.PruebaTecnica.servicios.TipoDocumentoServicio;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Oskar
 */
@RestController
@RequestMapping("/tipo")
public class TipoClienteControlador {
    
    @Autowired
    TipoDocumentoServicio tipoDocumentoServicio;
    TipoDocumentoModelo tipoDocumentoModelo;
    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Map<String,Object>> consultarTipoDocumento(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(tipoDocumentoServicio.consultarTipoDocumento(id));
    }
    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(path = "")
    public ArrayList<TipoDocumentoModelo> consultarTiposDocumentos() {
            return this.tipoDocumentoServicio.consultarTiposDocumentos();
    }
    
}
