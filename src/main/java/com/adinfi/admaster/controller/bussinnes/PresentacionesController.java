package com.adinfi.admaster.controller.bussinnes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adinfi.admaster.domain.bussinnes.Marcas;
import com.adinfi.admaster.domain.bussinnes.Presentaciones;
import com.adinfi.admaster.domain.bussinnes.Zonas;
import com.adinfi.admaster.repository.bussinnes.MarcasRepository;
import com.adinfi.admaster.repository.bussinnes.PresentacionesRepository;
import com.adinfi.admaster.repository.bussinnes.ZonasRepository;

@RestController
@RequestMapping("/presentaciones")
public class PresentacionesController {
	
	 private final PresentacionesRepository presentacionesRepository;
	 
	 @Autowired
	 public PresentacionesController(PresentacionesRepository presentacionesRepository){
		 this.presentacionesRepository = presentacionesRepository;
	 }
	 
	 @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Presentaciones>> findAll() {
        List<Presentaciones> d = this.presentacionesRepository.findAll();
        List<Presentaciones> f = new ArrayList<Presentaciones>();
        f.add(new Presentaciones(-1L, "Seleccionar..."));
        f.addAll(d);
        return new ResponseEntity<>(f, HttpStatus.OK);
    }

}
