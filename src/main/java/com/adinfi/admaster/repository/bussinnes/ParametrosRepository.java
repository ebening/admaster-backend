package com.adinfi.admaster.repository.bussinnes;

import com.adinfi.admaster.domain.bussinnes.Parametros;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jdominguez on 1/27/17.
 */
public interface ParametrosRepository extends JpaRepository<Parametros, Long> {

    public List<Parametros> findByNombreContaining(String nombre);
}
