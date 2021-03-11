package com.adinfi.admaster.repository.bussinnes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adinfi.admaster.domain.bussinnes.Marcas;
import com.adinfi.admaster.domain.bussinnes.Presentaciones;

public interface PresentacionesRepository extends JpaRepository<Presentaciones, Long> {

}
