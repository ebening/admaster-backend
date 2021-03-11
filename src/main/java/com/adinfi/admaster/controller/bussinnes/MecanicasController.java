package com.adinfi.admaster.controller.bussinnes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adinfi.admaster.domain.bussinnes.Marcas;
import com.adinfi.admaster.domain.bussinnes.Mecanicas;
import com.adinfi.admaster.domain.bussinnes.Zonas;
import com.adinfi.admaster.repository.bussinnes.MarcasRepository;
import com.adinfi.admaster.repository.bussinnes.MecanicasRepository;
import com.adinfi.admaster.repository.bussinnes.ZonasRepository;

@RestController
@RequestMapping("/mecanicas")
public class MecanicasController {
	
	 private final MecanicasRepository mecanicasRepository;
	 
	 @Autowired
	 public MecanicasController(MecanicasRepository mecanicasRepository){
		 this.mecanicasRepository = mecanicasRepository;
	 }
	 
	@RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Mecanicas>> findAll() {
        List<Mecanicas> d = this.mecanicasRepository.findAll();
        List<Mecanicas> f = new ArrayList<Mecanicas>();
        
        Mecanicas m = new Mecanicas();
        m.setMecanicasId(-1L);
        m.setNombre("Seleccionar");
        m.setActivo(true);
        f.addAll(d);
        return new ResponseEntity<>(f, HttpStatus.OK);
    }
	 
	@RequestMapping(path = "/nombres/", method = RequestMethod.GET)
    public ResponseEntity<List<Mecanicas>> getDistinct() {
        List<Mecanicas> d = this.mecanicasRepository.findAll();
        List<Mecanicas> f = new ArrayList<Mecanicas>();
        
        Mecanicas m = new Mecanicas();
        m.setMecanicasId(-1L);
        m.setNombre("Otra");
        m.setActivo(true);
        f.add(m);
        f.addAll(d);
        
        Map<String, Mecanicas> maps = new HashMap<String, Mecanicas>();
        for(Mecanicas e : f){
        	if(e.getNombre() != null && e.getNombre().length() >0){
        		maps.put(e.getName().toUpperCase(), e);
        	}
        }
        
        List<Mecanicas> finalList = new ArrayList<Mecanicas>();
		for (Map.Entry<String, Mecanicas> entry : maps.entrySet()){
		    finalList.add(entry.getValue());
		}
        
        return new ResponseEntity<>(finalList, HttpStatus.OK);
    }

}
