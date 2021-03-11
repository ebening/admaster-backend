package com.adinfi.admaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adinfi.admaster.domain.Application;
import com.adinfi.admaster.domain.form.CatView;
import com.adinfi.admaster.domain.form.View;

public interface ViewRepository extends JpaRepository<View, Long> {
	View findByViewId(Long viewId);
	
	View findByCatViewAndApplicationAndActive(CatView catView, Application app, boolean active);
}
