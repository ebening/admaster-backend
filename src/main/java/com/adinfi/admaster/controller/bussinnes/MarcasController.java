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
import com.adinfi.admaster.domain.bussinnes.Zonas;
import com.adinfi.admaster.repository.bussinnes.MarcasRepository;
import com.adinfi.admaster.repository.bussinnes.ZonasRepository;

@RestController
@RequestMapping("/marcas")
public class MarcasController {
	
	 private final MarcasRepository marcasRepository;
	 
	 @Autowired
	 public MarcasController(MarcasRepository marcasRepository){
		 this.marcasRepository = marcasRepository;
	 }
	 
	 @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Marcas>> findAll() {
        List<Marcas> d = this.marcasRepository.findAll();
        List<Marcas> f = new ArrayList<Marcas>();
        f.add(new Marcas(-1L, "Seleccionar..."));
        f.addAll(d);
        return new ResponseEntity<>(f, HttpStatus.OK);
    }

}
