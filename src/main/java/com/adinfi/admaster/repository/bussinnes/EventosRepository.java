package com.adinfi.admaster.repository.bussinnes;

import com.adinfi.admaster.domain.bussinnes.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jdominguez on 1/15/17.
 */
public interface EventosRepository extends JpaRepository<Eventos, Long> {
	Eventos findByEventosId(Long eventosId);
}
