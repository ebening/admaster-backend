package com.adinfi.admaster.controller.bussinnes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adinfi.admaster.domain.bussinnes.Zonas;
import com.adinfi.admaster.repository.bussinnes.ZonasRepository;

@RestController
@RequestMapping("/zonas")
public class ZonasController {
	
	 private final ZonasRepository zonasRepository;
	 
	 @Autowired
	 public ZonasController(ZonasRepository zonasRepository){
		 this.zonasRepository = zonasRepository;
	 }
	 
	 @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Zonas>> findAll() {
        List<Zonas> d = this.zonasRepository.findAll();
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

}
