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

import com.adinfi.admaster.domain.bussinnes.Marcas;
import com.adinfi.admaster.domain.bussinnes.Productos;
import com.adinfi.admaster.domain.bussinnes.Zonas;
import com.adinfi.admaster.dto.BuscarProductoRequestDTO;
import com.adinfi.admaster.repository.bussinnes.MarcasRepository;
import com.adinfi.admaster.repository.bussinnes.ProductosRepository;
import com.adinfi.admaster.repository.bussinnes.ZonasRepository;

@RestController
@RequestMapping("/productos")
public class ProductosController {

	private final ProductosRepository productosRepository;

	@Autowired
	public ProductosController(ProductosRepository productosRepository) {
		this.productosRepository = productosRepository;
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Productos>> findAll() {
		List<Productos> d = this.productosRepository.findAll();
		return new ResponseEntity<>(d, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/byProperties", method = RequestMethod.GET)
	public ResponseEntity<List<Productos>> findByPropierties( @RequestBody BuscarProductoRequestDTO request) {
		List<Productos> d = this.productosRepository.findAll();
		System.out.println(request);
		return new ResponseEntity<>(d, HttpStatus.OK);
	}
}
