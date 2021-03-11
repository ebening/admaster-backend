package com.adinfi.admaster.repository.bussinnes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adinfi.admaster.domain.bussinnes.SubCategoria;

public interface SubCategoriaRepository extends JpaRepository<SubCategoria, Long> {
	List<SubCategoria> findByCategoriasId(Long categoriasId);
	SubCategoria findBySubCategoriasId(Long id);
	SubCategoria findByNombre(String nombre);
}
