package com.adinfi.admaster.util;

import com.adinfi.admaster.domain.bussinnes.Parametros;
import com.adinfi.admaster.repository.bussinnes.ParametrosRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.List;

/**
 * Created by jdominguez on 1/27/17.
 */
public class SendMail {

    private JavaMailSenderImpl mailSender;
    private List<Parametros> params;
    private String txtFullResetPwd;
    
    private String textActivityAsign;
    private String textSubjectActivityAsign;
    
    private final ParametrosRepository paramsRepository;

    public SendMail(ParametrosRepository paramsRepository) {
        this.paramsRepository = paramsRepository;
        prepareParams();
    }

    public void prepareParams(){
        mailSender = new JavaMailSenderImpl();
        params = paramsRepository.findByNombreContaining("%email%");
        for (Parametros p : params){
            switch (p.getNombre()){
                case "emailServidor": mailSender.setHost(p.getValor()); break;
                case "emailUsuario": mailSender.setUsername(p.getValor()); break;
                case "emailPuerto": mailSender.setPort(Integer.valueOf(p.getValor())); break;
                case "emailContrasena": mailSender.setPassword(p.getValor());break;
                case "emailMsjRecuperaClave": txtFullResetPwd = p.getValor();
                case "emailMsjAsignacionActividad": textActivityAsign = p.getValor();
            }
        }
    }

    public void sendResetPwd(String subject, String newPwd, String[] to) throws Exception {

        String txt = txtFullResetPwd.replace("{clave}", newPwd);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailSender.getUsername());
        message.setTo(to);
        message.setSubject(subject);
        message.setText(txt);
        try{
            mailSender.send(message);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    
    public void eventActivityAsignationEmail(Long eventId, String eventName, String[] to) throws Exception{
    	String txt = this.textActivityAsign.replace("{NoEvento}", eventId.toString());
    	String txtFinal = txt.replace("{NombreEvento}", eventName);
    	
    	String s = this.textSubjectActivityAsign.replace("{NoEvento}", eventId.toString());
    	String sf = s.replace("{NombreEvento}", eventName);
    	
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailSender.getUsername());
        message.setTo(to);
        message.setSubject(sf);
        message.setText(txtFinal);
        try{
            mailSender.send(message);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
