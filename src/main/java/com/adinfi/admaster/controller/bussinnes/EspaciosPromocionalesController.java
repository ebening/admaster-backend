package com.adinfi.admaster.controller.bussinnes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adinfi.admaster.domain.bussinnes.Categorias;
import com.adinfi.admaster.domain.bussinnes.EspacioPromocionales;
import com.adinfi.admaster.domain.bussinnes.TipoMedios;
import com.adinfi.admaster.repository.bussinnes.CategoriasRepository;
import com.adinfi.admaster.repository.bussinnes.EspacioPromocionalesRepository;
import com.adinfi.admaster.repository.bussinnes.TipoMediosRepository;

@RestController
@RequestMapping("rest/espaciosPromocionales")
public class EspaciosPromocionalesController {
	
	 private final EspacioPromocionalesRepository espacioPromocionalesRepository;
	 
	 @Autowired
	 public EspaciosPromocionalesController(EspacioPromocionalesRepository espacioPromocionalesRepository){
		 this.espacioPromocionalesRepository = espacioPromocionalesRepository;
	 }
	 
	@RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<List<EspacioPromocionales>> findAll() {
        List<EspacioPromocionales> d = this.espacioPromocionalesRepository.findAll();
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

}
