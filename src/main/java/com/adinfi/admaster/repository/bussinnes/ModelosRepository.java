package com.adinfi.admaster.repository.bussinnes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adinfi.admaster.domain.bussinnes.Marcas;
import com.adinfi.admaster.domain.bussinnes.Modelos;

public interface ModelosRepository extends JpaRepository<Modelos, Long> {

}
