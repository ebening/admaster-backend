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
import com.adinfi.admaster.domain.bussinnes.Modelos;
import com.adinfi.admaster.domain.bussinnes.Zonas;
import com.adinfi.admaster.repository.bussinnes.MarcasRepository;
import com.adinfi.admaster.repository.bussinnes.ModelosRepository;
import com.adinfi.admaster.repository.bussinnes.ZonasRepository;

@RestController
@RequestMapping("/modelos")
public class ModelosController {
	
	 private final ModelosRepository modelosRepository;
	 
	 @Autowired
	 public ModelosController(ModelosRepository modelosRepository){
		 this.modelosRepository = modelosRepository;
	 }
	 
	 @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Modelos>> findAll() {
        List<Modelos> d = this.modelosRepository.findAll();
        List<Modelos> f = new ArrayList<Modelos>();
        f.add(new Modelos(-1L, "Seleccionar..."));
        f.addAll(d);
        return new ResponseEntity<>(f, HttpStatus.OK);
    }

}
