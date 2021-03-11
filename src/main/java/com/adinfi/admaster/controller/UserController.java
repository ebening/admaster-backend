package com.adinfi.admaster.controller;

import com.adinfi.admaster.domain.bussinnes.Usuarios;
import com.adinfi.admaster.repository.bussinnes.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.util.Map;

/**
 * Created by jdominguez on 1/5/17.
 */
@PropertySource(value = "classpath:etiquetas.properties", encoding = "UTF-8")
@RestController
@RequestMapping("rest/users")
public class UserController {

    @Autowired
    private Environment env;

    private final UsuariosRepository userRepository;

    @Autowired
    public UserController(UsuariosRepository userRepository) {
        this.userRepository = userRepository;
    }


    @RequestMapping(value = "byusername", method = RequestMethod.POST)
    public Usuarios getUserByUserName(@RequestBody String login) throws ServletException {

        if (login == null || login.isEmpty()){
            throw new ServletException("Debe mandar login");
        }
        Usuarios user = userRepository.findByUsuario(login.replace("\"", ""));

        if (user == null){
            throw new ServletException("Usuario no existe");
        }
        return user;
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public void logout (@RequestBody String username) throws ServletException {
        Usuarios user = userRepository.findByUsuario(username.replace("\"","").replace(" ",""));

        if (user == null){
            throw new ServletException("Usuario no existe");
        }

        user.setSesion(false);
        userRepository.save(user);
    }

    @RequestMapping(value = "chpwd", method = RequestMethod.POST)
    public String changePwd (@RequestBody Map<String, String> json) throws ServletException {
        if (json.get("username") == null || json.get("pwd") == null){
            throw  new ServletException("Usuario y contraseña no pueden estar vacios");
        }

        String login = json.get("username");
        String password = json.get("pwd");

        Usuarios users = userRepository.findByUsuario(login);

        if (users == null){
            throw new ServletException(env.getProperty("msj.login.userInvalido"));
        }

        users.setPassword(password);
        users.setCambioPassword(false);
        userRepository.save(users);

        return env.getProperty("msj.user.change.pwd", String.class);

    }
}
