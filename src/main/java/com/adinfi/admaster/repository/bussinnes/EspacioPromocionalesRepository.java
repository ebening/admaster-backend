package com.adinfi.admaster.repository.bussinnes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adinfi.admaster.domain.bussinnes.EspacioPromocionales;

public interface EspacioPromocionalesRepository extends JpaRepository<EspacioPromocionales, Long> {
	
	List<EspacioPromocionales> findByMediosId(Long mediosId);

}
