package com.adinfi.admaster.controller;

import com.adinfi.admaster.domain.bussinnes.Parametros;
import com.adinfi.admaster.repository.bussinnes.ParametrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.util.List;

/**
 * Created by jdominguez on 1/28/17.
 */
@RestController
@RequestMapping("rest/params/")
public class ParamsController {

    private final ParametrosRepository parametrosRepository;

    @Autowired
    public ParamsController(ParametrosRepository parametrosRepository) {
        this.parametrosRepository = parametrosRepository;
    }

    @RequestMapping(value = "idle", method = RequestMethod.POST)
    public List<Parametros> getParametrosIdle () throws ServletException {
        List<Parametros> params = parametrosRepository.findByNombreContaining("%idle%");
        if (params == null || params.isEmpty()){
            throw new ServletException("No existe configuracion para Idle");
        }
        return params;
    }
}
