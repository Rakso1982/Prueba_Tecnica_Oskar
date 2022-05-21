package com.colfondos.pruebatecnica.controladores;

import com.colfondos.PruebaTecnica.modelos.InformacionClienteModelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colfondos.PruebaTecnica.servicios.InformacionClienteServicio;
import java.util.ArrayList;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Oskar
 */
@RestController
@RequestMapping("/cliente")
public class InformacionClienteControlador {
    @Autowired
    InformacionClienteServicio informacionClienteServicio;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Map<String,Object>> consultarCliente(@PathVariable("identificacion") String identificacion) {
        return ResponseEntity.ok().body(informacionClienteServicio.consultarCliente(identificacion));
    }
    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(path = "/existe/{identificacion}")
    public ResponseEntity<Map<String,Object>> getExisteCliente(@PathVariable("identificacion") String identificacion) {
        return ResponseEntity.ok().body(informacionClienteServicio.getExisteCliente(identificacion));
    }
    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(path = "/existe/todos")
    public ArrayList<InformacionClienteModelo> consultarClientes() {
        return this.informacionClienteServicio.consultarClientes();
    }
    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/guardar")
    public ResponseEntity<InformacionClienteModelo> guardarCliente(@RequestBody InformacionClienteModelo cliente) {
        return ResponseEntity.status(HttpStatus.OK).body(informacionClienteServicio.guardarCliente(cliente));
    }
    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/actualizar")
    public ResponseEntity<InformacionClienteModelo> actualizarCliente(@RequestBody InformacionClienteModelo cliente) {
        return ResponseEntity.status(HttpStatus.OK).body(informacionClienteServicio.actualizarCliente(cliente));
    }
}
