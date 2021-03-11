package com.adinfi.admaster.controller.bussinnes;

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
import com.adinfi.admaster.repository.bussinnes.CategoriasRepository;
import com.adinfi.admaster.repository.bussinnes.TipoMediosRepository;

import javax.servlet.ServletException;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    private final CategoriasRepository categoriasRepository;

    @Autowired
    public CategoriasController(CategoriasRepository categoriasRepository) {
        this.categoriasRepository = categoriasRepository;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Categorias>> findAll() {
        List<Categorias> d = this.categoriasRepository.findAll();
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @RequestMapping(path = "byId", method = RequestMethod.POST)
    public Categorias getCategoById(@RequestBody String id) throws ServletException {
        if (id == null || id.isEmpty()){
            throw new ServletException("Debe proporcionar ID");
        }
        Categorias catego = categoriasRepository.findByCategoriasId(Long.valueOf(id));
        return catego;
    }

    @RequestMapping(path = "byName", method = RequestMethod.POST)
    public Categorias getCategoByName(@RequestBody String name) throws ServletException {
        if (name == null || name.isEmpty()){
            throw new ServletException("Debe proporcionar Nombre");
        }
        Categorias catego = categoriasRepository.findByNombre(name);
        return catego;
    }
}
