package com.adinfi.admaster.controller;

import com.adinfi.admaster.domain.bussinnes.Usuarios;
import com.adinfi.admaster.repository.UserRepository;
import com.adinfi.admaster.repository.bussinnes.ParametrosRepository;
import com.adinfi.admaster.repository.bussinnes.UsuariosRepository;
import com.adinfi.admaster.util.Constants;
import com.adinfi.admaster.util.PwdGenerator;
import com.adinfi.admaster.util.SendMail;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by jdominguez on 1/5/17.
 */
@PropertySource(value = "classpath:etiquetas.properties", encoding = "UTF-8")
@RestController
@RequestMapping("public")
public class LoginController {

    @Autowired
    private Environment env;

    private final UsuariosRepository userRepository;
    private final ParametrosRepository parametrosRepository;

    @Autowired
    public LoginController(UsuariosRepository userRepository, ParametrosRepository parametrosRepository) {
        this.userRepository = userRepository;
        this.parametrosRepository = parametrosRepository;
    }

    @RequestMapping(value = "resetpwd", method = RequestMethod.POST)
    public String resetPwd (@RequestBody String login) throws ServletException{
        if (login == null || login.isEmpty()){
            throw new ServletException("Debe mandar login");
        }

        Usuarios user = userRepository.findByUsuario(login.replace("\"","").replace(" ",""));
        if (user == null){
            throw new ServletException("Usuario no existe");
        }

        String newpwd = PwdGenerator.generatePassword(8);
        System.out.println("INFO: Password Generado: " + newpwd);
        user.setCambioPassword(true);
        try {
            System.out.println("INFO: Password MD5: " + PwdGenerator.passwordMD5(newpwd) );
            user.setPassword(PwdGenerator.passwordMD5(newpwd));
        } catch (NoSuchAlgorithmException e) {
            throw new ServletException(e.getMessage());
        } catch (UnsupportedEncodingException e) {
            throw new ServletException(e.getMessage());
        }

        userRepository.save(user);

        SendMail mail = new SendMail(parametrosRepository);
        String [] to = {user.getCorreo()};
        try {
            mail.sendResetPwd("Nueva Contraseña - AdMaster", newpwd, to);
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }

        return env.getProperty("msj.user.reset.pwd", String.class);
    }

    @RequestMapping("login")
    public String login(@RequestBody Map<String, String> json) throws ServletException {

        if (json.get("username") == null || json.get("pwd") == null){
            throw  new ServletException("Usuario y contraseña no pueden estar vacios");
        }

        String login = json.get("username");
        String password = json.get("pwd");

        Usuarios users = userRepository.findByUsuario(login);

        if (users == null){
            throw new ServletException(env.getProperty("msj.login.userInvalido"));
        }

        if (!users.getPassword().replace(" ","").equals(password)){
           throw new ServletException(env.getProperty("msj.login.pwdInvalido"));
        }

        if (users.getSesion()){
            throw new ServletException(env.getProperty("msj.login.sesion.active"));
        }

        if (!users.getCambioPassword()){
            users.setSesion(true);
            userRepository.save(users);
        }

        String token = Jwts.builder().setSubject(login+password).claim("roles", "user")
                .setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, Constants.SECRET).compact();

        return token;

    }

}
