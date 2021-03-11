package com.adinfi.admaster.controller.bussinnes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.adinfi.admaster.domain.StructureData;
import com.adinfi.admaster.domain.bussinnes.Eventos;
import com.adinfi.admaster.domain.bussinnes.SubCategoria;
import com.adinfi.admaster.repository.bussinnes.SubCategoriaRepository;

import javax.servlet.ServletException;

@RestController
@RequestMapping("/subCategoria")
public class SubCategoriaController {

	private final SubCategoriaRepository subCategoriaRepository;

	@Autowired
	public SubCategoriaController(SubCategoriaRepository subCategoriaRepository) {
		this.subCategoriaRepository = subCategoriaRepository;
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity<List<SubCategoria>> findAll() {
		List<SubCategoria> d = this.subCategoriaRepository.findAll();
		List<SubCategoria> f = new ArrayList<SubCategoria>();
		SubCategoria seleccionar = new SubCategoria();
		seleccionar.setSubCategoriasId(-1L);
		seleccionar.setNombre("Seleccionar...");
		f.add(seleccionar);
		f.addAll(d);
		
		return new ResponseEntity<>(f, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/findByCategoriasId/{categoriasId}", method = RequestMethod.GET)
	public ResponseEntity<List<SubCategoria>> findByStructureDataId(@PathVariable Long categoriasId) {
		List<SubCategoria> e = this.subCategoriaRepository.findByCategoriasId(categoriasId);
		
		List<SubCategoria> f = new ArrayList<SubCategoria>();
		SubCategoria seleccionar = new SubCategoria();
		seleccionar.setSubCategoriasId(-1L);
		seleccionar.setNombre("Seleccionar...");
		f.add(seleccionar);
		f.addAll(e);
		
		return new ResponseEntity<>(f, HttpStatus.OK);
	}

	@RequestMapping(path = "byId", method = RequestMethod.POST)
	public SubCategoria findSubCategoById(@RequestBody String id)throws ServletException{
		if (id == null || id.isEmpty()){
			throw new ServletException("Debe proporcionar ID");
		}
		SubCategoria subCategoria = subCategoriaRepository.findBySubCategoriasId(Long.valueOf(id));
		return subCategoria;
	}

	@RequestMapping(path = "byName", method = RequestMethod.POST)
	public SubCategoria findsubCategoByName(@RequestBody String name) throws ServletException{
		if (name == null || name.isEmpty()){
			throw new ServletException("Debe proporcionar nombre");
		}
		SubCategoria subCategoria = subCategoriaRepository.findByNombre(name);
		return subCategoria;
	}

}
