package com.adinfi.admaster.repository.bussinnes;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.adinfi.admaster.domain.bussinnes.Medios;

public interface MediosRepository extends PagingAndSortingRepository<Medios, Long> {
	Medios findByMediosId(Long mediosId);
	Medios findByEventosIdAndFechaInicialAndFechaFinal(Long eventosId, Date fechaInicial, Date fechaFinal);
	
	Medios findByTipoMediosIdAndEventosIdAndFechaInicialAndFechaFinalAndZones_zonasIdAndActivo(Long tipoMediosId, Long eventosId, Date fechaInicial, Date fechaFinal, Long zonasId, Boolean activo);
	
	Page<Medios> findByEventosIdAndActivo(Long eventosId, Boolean active, Pageable pageable);
	List<Medios> findByEventosIdAndActivo(Long eventosId, Boolean active);
	
	Page<Medios> findByEventosIdAndActivoAndDescripcionLikeIgnoreCase(Long eventosId, Boolean active, String text, Pageable pageable);
	
	List<Medios> findByEventosIdAndDescripcionIgnoreCaseAndActivo(Long eventosId, String description, Boolean activo);
	
}
