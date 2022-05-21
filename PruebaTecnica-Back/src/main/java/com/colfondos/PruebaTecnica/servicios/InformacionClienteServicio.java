package com.colfondos.PruebaTecnica.servicios;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colfondos.PruebaTecnica.modelos.InformacionClienteModelo;
import com.colfondos.PruebaTecnica.modelos.TipoDocumentoModelo;
import com.colfondos.PruebaTecnica.repositorios.InformacionClienteRepositorio;
import excepciones.LongitudCelular;
import excepciones.LongitudMaxima;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oskar
 */
@Service
public class InformacionClienteServicio {

    @Autowired
    InformacionClienteRepositorio informacionClienteRepositorio;
    
    public Map<String,Object> consultarCliente(String identificacion){
        List<InformacionClienteModelo> informacionClienteModelo;
        Map<String,Object> respuesta = new LinkedHashMap();
        
        informacionClienteModelo = informacionClienteRepositorio.findByIdentificacion(identificacion);
        
        respuesta.put("identificacion", informacionClienteModelo.get(0).getIdentificacion());
        respuesta.put("idTipoDocumento", informacionClienteModelo.get(0).getId());
        respuesta.put("correo", informacionClienteModelo.get(0).getCorreo());
        respuesta.put("celular", informacionClienteModelo.get(0).getCelular());
        return respuesta;
    }
    
    public ArrayList<InformacionClienteModelo> consultarClientes(){
        return (ArrayList<InformacionClienteModelo>) informacionClienteRepositorio.findAll();
    }
    
    public Map<String,Object> getExisteCliente(String identificacion){
        Map<String,Object> respuesta = new LinkedHashMap();

        if(identificacion.length() > 10){
            throw new LongitudMaxima("La longitud máxima del campo identificacion es de 10 digitos.");   
        }
        
        respuesta.put("Existe", !informacionClienteRepositorio.findByIdentificacion(identificacion).isEmpty());
        Logger.getLogger(InformacionClienteServicio.class.getName()).info("Se verifica la existencia del cliente.");
        return respuesta;
    }
    
    public InformacionClienteModelo guardarCliente(InformacionClienteModelo cliente) {
        if(cliente.getCelular().length() != 10){
            throw new LongitudCelular("La longitud del número de celular debe ser de 10 digitos.");
        }
        Logger.getLogger(InformacionClienteServicio.class.getName()).info("Se inicia el proceso de creacion del cliente.");
        return informacionClienteRepositorio.save(cliente);
    }
    
    public InformacionClienteModelo actualizarCliente(InformacionClienteModelo cliente) {
        if(cliente.getCelular().length() != 10){
            throw new LongitudCelular("La longitud del número de celular debe ser de 10 digitos.");
        }
        Logger.getLogger(InformacionClienteServicio.class.getName()).info("Se inicia el proceso de actualizacion del cliente.");
        return informacionClienteRepositorio.save(cliente);
    }
}
