package com.adinfi.admaster.repository.bussinnes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.adinfi.admaster.domain.bussinnes.EspacioPromocionales;

public interface MediosCategoriasRepository extends PagingAndSortingRepository<EspacioPromocionales, Long> {
	List<EspacioPromocionales> findByMediosId(Long mediosId);
	
}
