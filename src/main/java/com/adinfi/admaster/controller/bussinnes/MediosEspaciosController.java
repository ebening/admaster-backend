package com.adinfi.admaster.controller.bussinnes;

import com.adinfi.admaster.domain.sp.*;
import com.adinfi.admaster.repository.sp.SPIndicadoresMediosEspaciosDAO;
import com.adinfi.admaster.repository.sp.SPMecanicasEspaciosDAO;
import com.adinfi.admaster.repository.sp.SPMediosEspaciosDAO;
import com.adinfi.admaster.repository.sp.SPTiposMediosMecanicasDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jdominguez on 2/4/17.
 */
@RestController
@RequestMapping("rest/udpMediosEspacios")
public class MediosEspaciosController {


    private final SPMediosEspaciosDAO dao;
    private final SPIndicadoresMediosEspaciosDAO indicadoresDao;
    private final SPMecanicasEspaciosDAO mecanicasEspaciosDAO;
    private final SPTiposMediosMecanicasDAO tiposMediosMecanicasDAO;

    @Autowired
    public MediosEspaciosController(SPMediosEspaciosDAO dao, SPIndicadoresMediosEspaciosDAO indicadoresDao, SPMecanicasEspaciosDAO mecanicasEspaciosDAO, SPTiposMediosMecanicasDAO tiposMediosMecanicasDAO) {
        this.dao = dao;
        this.indicadoresDao = indicadoresDao;
        this.mecanicasEspaciosDAO = mecanicasEspaciosDAO;
        this.tiposMediosMecanicasDAO = tiposMediosMecanicasDAO;
    }




    @RequestMapping(value = "saveMZ", method = RequestMethod.POST)
    public void guardarTodoMerza  (@RequestBody List<UdpMediosUpsMerza> list) throws ServletException {
        if (list == null || list.isEmpty()){
            throw new ServletException("Informacion Incompleta o Lista vacia");
        }
        for (UdpMediosUpsMerza x : list){
            mecanicasEspaciosDAO.udpEspaciosMecanicasIni(x.getMecanicasId(), x.getMediosId());
            Long id = mecanicasEspaciosDAO.udpMediosUps(x);
            mecanicasEspaciosDAO.udpEspaciosMecanicasUps(id, x.getSubCategoriaId(), x.getMecanicasId());
            mecanicasEspaciosDAO.udpMediosEspaciosUbicacionesUps(id, x.getEspaciosUbicacionesId());
            mecanicasEspaciosDAO.udpEspaciosMecanicasDel(id, x.getSubCategoriaId());
        }
    }

    @RequestMapping(value = "indicadores", method = RequestMethod.POST)
    public IndicadoresMediosEspacios getIndicadoresMediosOferta(@RequestBody Map<String, String> json)throws ServletException{
        if (json.get("eventosId") == null || json.get("usuariosId") == null){
            throw new ServletException("Informacion incompleta");
        }
        IndicadoresMediosEspacios indicadores = indicadoresDao.getIndicadores(
                Long.valueOf(json.get("eventosId")),
                Long.valueOf(json.get("usuariosId"))
        );
        return indicadores;
    }

    @RequestMapping(value = "tiposMediosByMecanica", method = RequestMethod.POST)
    public List<UdpTipoMedioMecanicas> getTipoMediosMecanicas (@RequestBody Map<String, String> json) throws ServletException {
        if (json.get("eventosId") == null || json.get("mecanicasId") == null || json.get("usuariosId") == null){
            throw new ServletException("Informacion Incompleta");
        }
        List<UdpTipoMedioMecanicas> listreturn = tiposMediosMecanicasDAO.getTipoMediosMecanicas(
                Long.valueOf(json.get("eventosId")),
                Integer.valueOf(json.get("mecanicasId")),
                null,
                Long.valueOf(json.get("usuariosId"))
        );
        return listreturn;
    }

    @RequestMapping(value = "mediosUbicacionesMecanicas", method = RequestMethod.POST)
    public List<UdpMediosUbicacionesMecanicas> getMediosUbicacionesMecanicas (@RequestBody Map<String, String> json) throws ServletException {
        if (json.get("eventosId") == null || json.get("mecanicasId") == null){
            throw new ServletException("Informacion Incompleta");
        }
        List<UdpMediosUbicacionesMecanicas> listReturn = tiposMediosMecanicasDAO.getMediosUbicacionesMecanicas(
                Long.valueOf(json.get("eventosId")),
                Integer.valueOf(json.get("mecanicasId"))
        );
        return listReturn;
    }

    @RequestMapping(value = "saveALS", method = RequestMethod.POST)
    public void guardarTodoAlSuper(@RequestBody List<EspaciosMecanicas> array) throws ServletException{
        if (array == null || array.isEmpty()){
            throw new ServletException("Lista vacia, nada que guardar");
        }
        for (EspaciosMecanicas x : array){
            dao.callUdpEspaciosMecanicaIniDel(x.getMedioId(), x.getSubCategoriaId(), false);
            if (x.getMecanicaId() == null){
                x.setMecanicaId(new ArrayList<Long>());
            }
            for (Long y: x.getMecanicaId()){
                dao.callUdpEspaciosMecanicasUps(x.getMedioId(), x.getSubCategoriaId(), y);
            }
            dao.callUdpEspaciosMecanicaIniDel(x.getMedioId(), x.getSubCategoriaId(), true);
        }
    }

    @RequestMapping(value = "selectEspaciosProductos", method = RequestMethod.POST)
    public List<UdpEspaciosProductosSel> espaciosProductosList (@RequestBody Map<String, String> json) throws ServletException {
        if (json.get("mediosId") == null || json.get("subCategoId") == null || json.get("userId") == null){
            throw new ServletException("Informacion Incompleta");
        }
        return dao.callUdpEspaciosProductosSel(Long.valueOf(json.get("mediosId")), Integer.valueOf(json.get("subCategoId")), Long.valueOf(json.get("userId")));
    }

    @RequestMapping(value = "copyMecanicasSel", method = RequestMethod.POST)
    public void copyMecanicasUps (@RequestBody Map<String, String> json) throws ServletException {
        if (json.get("sourceId") == null || json.get("targetId") == null || json.get("userId") == null){
            throw new ServletException("Informacion Incompleta");
        }
        dao.callUdpCopyMediosMecanicasUps(Long.valueOf(json.get("sourceId")), Long.valueOf(json.get("targetId")), Long.valueOf(json.get("userId")));
    }

    @RequestMapping(value = "copyMecanicasVal", method = RequestMethod.POST)
    public Map<String, Integer> copyMecanicasVal (@RequestBody Map<String, String> json) throws ServletException {
        if (json.get("sourceId") == null || json.get("targetId") == null || json.get("userId") == null){
            throw new ServletException("Informacion Incompleta");
        }
        Map<String, Integer> r = dao.callUdpCopyMediosMecanicasVal(Long.valueOf(json.get("sourceId")), Long.valueOf(json.get("targetId")), Long.valueOf(json.get("userId")));
        return r;
    }

    @RequestMapping(value = "selectEspaciosCategorias", method = RequestMethod.POST)
    public List<UdpEspaciosCategoriaSel> mediosCategoriaSelList (@RequestBody Map<String, String> json) throws ServletException {
        if (json.get("usuariosId") == null || json.get("mediosId") == null){
            throw new ServletException("Usuarios ID o MediosID no puede ser Nulo");
        }
        List<UdpEspaciosCategoriaSel> list = dao.callUdpEspaciosCategoriasSel(
                Long.valueOf(json.get("mediosId")),
                true,
                Integer.valueOf(json.get("statusId")) ,
                Long.valueOf(json.get("usuariosId")));
        return list;
    }

    @RequestMapping(value = "selectMediosEspacios", method = RequestMethod.POST)
    public UdpMediosEspaciosSel udpMediosEspaciosSel (@RequestBody Map<String, String> json) throws ServletException {
        if (json.get("eventosId") == null || json.get("usuariosId") == null){
            throw new ServletException("Informacion incompleta");
        }
        UdpMediosEspaciosSel udp = dao.callUdpMediosEspaciosSel(Long.valueOf(json.get("eventosId")), Long.valueOf(json.get("usuariosId")));
        return udp;
    }
}
