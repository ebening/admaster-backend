package com.adinfi.admaster.repository.bussinnes;

import com.adinfi.admaster.domain.bussinnes.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jdominguez on 1/26/17.
 */
@Repository
public interface UsuariosRepository extends CrudRepository<Usuarios, Long> {

    public Usuarios findByUsuario(String usuario);
}
