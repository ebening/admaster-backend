package com.adinfi.admaster.repository.bussinnes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adinfi.admaster.domain.bussinnes.TipoMedios;

public interface TipoMediosRepository extends JpaRepository<TipoMedios, Long> {
	TipoMedios findByTipoMediosId(Long tipoMediosId);

}
