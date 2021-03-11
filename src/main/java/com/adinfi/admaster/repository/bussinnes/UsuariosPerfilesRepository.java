package com.adinfi.admaster.repository.bussinnes;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adinfi.admaster.domain.bussinnes.UsuariosPerfiles;

/**
 * Created by jdominguez on 1/26/17.
 */
@Repository
public interface UsuariosPerfilesRepository extends CrudRepository<UsuariosPerfiles, Long> {

    public List<UsuariosPerfiles> findByUsuariosId(Long usuariosId);
}
