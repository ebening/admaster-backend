package com.adinfi.admaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adinfi.admaster.domain.form.CatView;

public interface CatViewRepository extends JpaRepository<CatView, Long> {
	CatView findByCatViewId(Long viewId);
}
