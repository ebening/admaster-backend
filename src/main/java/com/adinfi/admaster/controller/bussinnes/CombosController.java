package com.adinfi.admaster.controller.bussinnes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adinfi.admaster.domain.bussinnes.Combos;
import com.adinfi.admaster.domain.bussinnes.Marcas;
import com.adinfi.admaster.domain.bussinnes.Zonas;
import com.adinfi.admaster.repository.bussinnes.CombosRepository;
import com.adinfi.admaster.repository.bussinnes.MarcasRepository;
import com.adinfi.admaster.repository.bussinnes.ZonasRepository;

@RestController
@RequestMapping("/combos")
public class CombosController {
	
	 private final CombosRepository combosRepository;
	 
	 @Autowired
	 public CombosController(CombosRepository combosRepository){
		 this.combosRepository = combosRepository;
	 }
	 
	 @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Combos>> findAll() {
        List<Combos> d = this.combosRepository.findAll();
        List<Combos> f = new ArrayList<Combos>();
        Combos s = new Combos();
        s.setCombosId(-1L);
        s.setDescripcion("Seleccionar...");
        s.setActivo(true);
        f.add(s);
        f.addAll(d);
        return new ResponseEntity<>(f, HttpStatus.OK);
    }

}
