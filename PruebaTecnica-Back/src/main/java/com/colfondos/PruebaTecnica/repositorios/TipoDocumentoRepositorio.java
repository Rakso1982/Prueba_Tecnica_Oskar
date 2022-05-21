package com.colfondos.PruebaTecnica.repositorios;

import com.colfondos.PruebaTecnica.modelos.TipoDocumentoModelo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Oskar
 */
public interface TipoDocumentoRepositorio extends CrudRepository<TipoDocumentoModelo, Long>{
    List<TipoDocumentoModelo> findById(int id);
}
