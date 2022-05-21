package com.colfondos.PruebaTecnica.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.colfondos.PruebaTecnica.modelos.InformacionClienteModelo;

/**
 *
 * @author Oskar
 */
public interface InformacionClienteRepositorio extends CrudRepository<InformacionClienteModelo, Long>{
    List<InformacionClienteModelo> findByIdentificacion(String identificacion);
}
