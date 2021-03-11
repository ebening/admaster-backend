package com.adinfi.admaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adinfi.admaster.domain.DataStructure;

public interface DataStructureRepository extends JpaRepository<DataStructure, Long> {
	DataStructure findByDataStructureId(Long id);
}
