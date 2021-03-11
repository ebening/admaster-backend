package com.adinfi.admaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adinfi.admaster.domain.Application;

public interface ApplicationRespository extends JpaRepository<Application, Long> {
	Application findById(Long id);
}
