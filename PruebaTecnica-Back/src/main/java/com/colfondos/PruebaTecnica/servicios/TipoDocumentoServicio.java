package com.colfondos.PruebaTecnica.servicios;

import com.colfondos.PruebaTecnica.modelos.TipoDocumentoModelo;
import com.colfondos.PruebaTecnica.repositorios.TipoDocumentoRepositorio;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Oskar
 */
@Service
public class TipoDocumentoServicio {
    
    @Autowired
    TipoDocumentoRepositorio tipoDocumentoRepositorio;
    
    /*
    public ArrayList<TipoDocumentoModelo> consultarTipoDocumento(int id){
        return (ArrayList<TipoDocumentoModelo>) tipoDocumentoRepositorio.findById(id);
    }
    */

    
    public Map<String,Object> consultarTipoDocumento(int id){
        List<TipoDocumentoModelo> tipoDocumentoModelo;
        Map<String,Object> respuesta = new LinkedHashMap();
        
        tipoDocumentoModelo = tipoDocumentoRepositorio.findById(id);
        
        respuesta.put("id", tipoDocumentoModelo.get(0).getId());
        respuesta.put("descripcion", tipoDocumentoModelo.get(0).getDescripcion());
        return respuesta;
    }
    
    public ArrayList<TipoDocumentoModelo> consultarTiposDocumentos(){
        return (ArrayList<TipoDocumentoModelo>) tipoDocumentoRepositorio.findAll();
    }
}
