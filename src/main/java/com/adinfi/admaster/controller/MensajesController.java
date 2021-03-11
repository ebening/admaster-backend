package com.adinfi.admaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;

/**
 * Created by jdominguez on 2/6/17.
 */
@PropertySource(value = "classpath:etiquetas.properties", encoding = "UTF-8")
@RestController
@RequestMapping("rest/mensajes")
public class MensajesController {

    @Autowired
    private Environment env;

    @RequestMapping(value = "getMsjByKey", method = RequestMethod.POST)
    public String getMsjByKey(@RequestBody String key) throws ServletException{
        if (key == null || key.isEmpty()){
            throw new ServletException("Key no puede ser vacio");
        }
        return env.getProperty(key.replace("\"",""), String.class);
    }

}
