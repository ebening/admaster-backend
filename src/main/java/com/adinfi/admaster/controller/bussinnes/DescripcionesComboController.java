package com.adinfi.admaster.controller.bussinnes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adinfi.admaster.domain.bussinnes.Categorias;
import com.adinfi.admaster.domain.bussinnes.TipoMedios;
import com.adinfi.admaster.dto.DescripcionesComboDTO;
import com.adinfi.admaster.repository.bussinnes.CategoriasRepository;
import com.adinfi.admaster.repository.bussinnes.TipoMediosRepository;

import javax.servlet.ServletException;

@RestController
@RequestMapping("/descripcionesCombo")
public class DescripcionesComboController {

    
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<List<DescripcionesComboDTO>> findAll() {
        List<DescripcionesComboDTO> d = new ArrayList<DescripcionesComboDTO>();
        d.add(new DescripcionesComboDTO(-1L, "Otra"));
        d.add(new DescripcionesComboDTO(1L, "Descripción A"));
        d.add(new DescripcionesComboDTO(2L, "Descripción B"));
 
        return new ResponseEntity<>(d, HttpStatus.OK);
    }
}
