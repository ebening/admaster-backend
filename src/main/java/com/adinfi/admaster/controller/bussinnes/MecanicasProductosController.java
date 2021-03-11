package com.adinfi.admaster.controller.bussinnes;

import com.adinfi.admaster.domain.sp.MecanicasProductos;
import com.adinfi.admaster.repository.sp.SPMecanicasProductosDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.util.List;
import java.util.Map;

/**
 * Created by jdominguez on 2/11/17.
 */
@RestController
@RequestMapping("rest/mecanicasProductos")
public class MecanicasProductosController {

    @Autowired
    private SPMecanicasProductosDAO dao;

    @RequestMapping("listByMedio")
    public List<MecanicasProductos> getMecanicasProductos(@RequestBody Map<String, String> json) throws ServletException{
        if (json.get("usuariosId") == null){
            throw new ServletException("Informacion Incompleta");
        }
        List<MecanicasProductos> list = dao.callUdpMecanicasProductosSel(Long.valueOf(json.get("usuariosId")));
        return list;
    }
}
