package com.adinfi.admaster.repository.bussinnes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adinfi.admaster.domain.bussinnes.Categorias;

public interface CategoriasRepository extends JpaRepository<Categorias, Long> {

    public Categorias findByCategoriasId(Long categoriasId);
    public Categorias findByNombre(String nombre);
}
