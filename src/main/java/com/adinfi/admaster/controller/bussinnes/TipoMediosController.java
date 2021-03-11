package com.adinfi.admaster.controller.bussinnes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adinfi.admaster.domain.bussinnes.TipoMedios;
import com.adinfi.admaster.repository.bussinnes.TipoMediosRepository;

@RestController
@RequestMapping("/tipoMedios")
public class TipoMediosController {

	private final TipoMediosRepository tipoMediosRepository;

	@Autowired
	public TipoMediosController(TipoMediosRepository tipoMediosRepository) {
		this.tipoMediosRepository = tipoMediosRepository;
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity<List<TipoMedios>> findAll() {
		List<TipoMedios> d = this.tipoMediosRepository.findAll();
		return new ResponseEntity<>(d, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{tipoMediosId}", method = RequestMethod.GET)
	public ResponseEntity<TipoMedios> findById(@PathVariable Long tipoMediosId) {
		TipoMedios tipoMedios = this.tipoMediosRepository.findByTipoMediosId(tipoMediosId);
		return new ResponseEntity<>(tipoMedios, HttpStatus.OK);
	}

}
