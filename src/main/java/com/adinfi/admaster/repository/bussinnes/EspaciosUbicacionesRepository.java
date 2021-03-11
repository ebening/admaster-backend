package com.adinfi.admaster.repository.bussinnes;

import com.adinfi.admaster.domain.bussinnes.EspaciosUbicaciones;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jdominguez on 2/11/17.
 */
@Repository
public interface EspaciosUbicacionesRepository extends CrudRepository<EspaciosUbicaciones, Integer> {
}
