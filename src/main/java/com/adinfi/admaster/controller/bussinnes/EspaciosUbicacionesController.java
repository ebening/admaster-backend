package com.adinfi.admaster.controller.bussinnes;

import com.adinfi.admaster.domain.bussinnes.EspaciosUbicaciones;
import com.adinfi.admaster.repository.bussinnes.EspaciosUbicacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.util.List;

/**
 * Created by jdominguez on 2/11/17.
 */
@RestController
@RequestMapping("rest/espaciosUbicaciones")
public class EspaciosUbicacionesController {

    @Autowired
    private EspaciosUbicacionesRepository dao;

    @RequestMapping("list")
    public List<EspaciosUbicaciones> getEspaciosAll() throws ServletException{
        List<EspaciosUbicaciones> list = (List<EspaciosUbicaciones>) dao.findAll();
        return list;
    }
}
