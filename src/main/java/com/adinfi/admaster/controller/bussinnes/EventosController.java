package com.adinfi.admaster.controller.bussinnes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adinfi.admaster.domain.StructureData;
import com.adinfi.admaster.domain.bussinnes.Categorias;
import com.adinfi.admaster.domain.bussinnes.Eventos;
import com.adinfi.admaster.domain.bussinnes.TipoMedios;
import com.adinfi.admaster.repository.StructureDataRepository;
import com.adinfi.admaster.repository.bussinnes.CategoriasRepository;
import com.adinfi.admaster.repository.bussinnes.EventosRepository;
import com.adinfi.admaster.repository.bussinnes.TipoMediosRepository;

@RestController
@RequestMapping("/eventos")
public class EventosController {

	private final EventosRepository eventosRepository;
	private final StructureDataRepository structureDataRepository;

	@Autowired
	public EventosController(EventosRepository eventosRepository, StructureDataRepository structureDataRepository) {
		this.eventosRepository = eventosRepository;
		this.structureDataRepository = structureDataRepository;
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Eventos>> findAll() {
		List<Eventos> d = this.eventosRepository.findAll();
		return new ResponseEntity<>(d, HttpStatus.OK);
	}

	@RequestMapping(path = "/{eventosId}", method = RequestMethod.GET)
	public ResponseEntity<Eventos> findById(@PathVariable Long eventosId) {
		Eventos e = this.eventosRepository.findByEventosId(eventosId);
		return new ResponseEntity<>(e, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/findByStructureDataId/{structureDataId}", method = RequestMethod.GET)
	public ResponseEntity<Eventos> findByStructureDataId(@PathVariable Long structureDataId) {
		System.out.println("dataId: " +  structureDataId);
		StructureData s = this.structureDataRepository.findByDataId(structureDataId);
		System.out.println("eventosId: " + s.getEventosId());
		Eventos e = this.eventosRepository.findByEventosId(s.getEventosId());
		return new ResponseEntity<>(e, HttpStatus.OK);
	}

}
