package com.adinfi.admaster.repository.bussinnes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adinfi.admaster.domain.bussinnes.ObjectoUbicaciones;

public interface ObjectoUbicacionesRepository extends JpaRepository<ObjectoUbicaciones, Long> {
	ObjectoUbicaciones findByMediosIdAndZonasId(Long mediosId, Long zonasId);
}
