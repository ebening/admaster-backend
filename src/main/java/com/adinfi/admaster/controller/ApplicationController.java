package com.adinfi.admaster.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.adinfi.admaster.domain.*;
import com.adinfi.admaster.domain.bussinnes.EspacioPromocionales;
import com.adinfi.admaster.domain.bussinnes.Eventos;
import com.adinfi.admaster.domain.bussinnes.Medios;
import com.adinfi.admaster.domain.bussinnes.Parametros;
import com.adinfi.admaster.domain.bussinnes.TipoMedios;
import com.adinfi.admaster.domain.bussinnes.UsuariosPerfiles;
import com.adinfi.admaster.dto.EtiquetasDTO;
import com.adinfi.admaster.repository.bussinnes.EspacioPromocionalesRepository;
import com.adinfi.admaster.repository.bussinnes.EventosRepository;
import com.adinfi.admaster.repository.bussinnes.MediosRepository;
import com.adinfi.admaster.repository.bussinnes.ObjectoUbicacionesRepository;
import com.adinfi.admaster.repository.bussinnes.ParametrosRepository;
import com.adinfi.admaster.repository.bussinnes.TipoMediosRepository;
import com.adinfi.admaster.repository.bussinnes.UsuariosPerfilesRepository;
import com.adinfi.admaster.repository.raw.ExcelValidationDAO;
import com.adinfi.admaster.repository.sp.SPMediosEspaciosDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.adinfi.admaster.domain.form.CatView;
import com.adinfi.admaster.domain.form.View;
import com.adinfi.admaster.domain.workflow.WorkFlowConfig;
import com.adinfi.admaster.domain.workflow.WorkFlowConfigActions;
import com.adinfi.admaster.dto.WorkFlowRequestDTO;
import com.adinfi.admaster.exception.ResourceNotFoundException;
import com.adinfi.admaster.repository.ApplicationRespository;
import com.adinfi.admaster.repository.CatViewRepository;
import com.adinfi.admaster.repository.DataStructureRepository;
import com.adinfi.admaster.repository.StructureDataHistoryRepository;
import com.adinfi.admaster.repository.StructureDataRepository;
import com.adinfi.admaster.repository.ViewRepository;
import com.adinfi.admaster.repository.WorkFlowConfigRepository;
import com.adinfi.admaster.repository.WorkFlowRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
@PropertySource(value = "classpath:etiquetas.properties", encoding = "UTF-8")
@RestController
@RequestMapping("/rest/appController")
public class ApplicationController {

    @Autowired
    private Environment env;

    private final ApplicationRespository applicationRepository;

    private final DataStructureRepository dataStructureRepository;

    private final StructureDataRepository structureDataRepository;

    private final WorkFlowRepository workFlowRepository;

    private final WorkFlowConfigRepository workFlowConfigRepository;

    private final ViewRepository viewRepository;
    
    private final CatViewRepository catViewRepository;

    private final StructureDataHistoryRepository structureDataHistoryRepository;

    private final EventosRepository eventosRepository;
    
    private final MediosRepository mediosRepository;
	private final TipoMediosRepository tipoMediosRepository;
	private final ObjectoUbicacionesRepository objectoUbicacionesRepository;
	private final EspacioPromocionalesRepository espacioPromocionalesRepository;
	
	private final UsuariosPerfilesRepository usuariosPerfilesRepository;
	
	private final ParametrosRepository parametrosRepository;
	
	 private final ExcelValidationDAO excelValidationDAO;


    @Autowired
    public ApplicationController(ApplicationRespository applicationRepository,
                                 DataStructureRepository dataStructureRepository,
                                 StructureDataRepository structureDataRepository,
                                 WorkFlowRepository workFlowRepository,
                                 WorkFlowConfigRepository workFlowConfigRepository,
                                 ViewRepository viewRepository,
                                 StructureDataHistoryRepository structureDataHistoryRepository,
                                 CatViewRepository catViewRepository, EventosRepository eventosRepository,
                                 MediosRepository mediosRepository,
                                 TipoMediosRepository tipoMediosRepository,
                                 ObjectoUbicacionesRepository objectoUbicacionesRepository,
                                 EspacioPromocionalesRepository espacioPromocionalesRepository,
                                 UsuariosPerfilesRepository usuariosPerfilesRepository,
                                 ParametrosRepository parametrosRepository,
                                 ExcelValidationDAO excelValidationDAO) {
        this.applicationRepository = applicationRepository;
        this.dataStructureRepository = dataStructureRepository;
        this.structureDataRepository = structureDataRepository;
        this.workFlowRepository = workFlowRepository;
        this.workFlowConfigRepository = workFlowConfigRepository;
        this.viewRepository = viewRepository;
        this.structureDataHistoryRepository = structureDataHistoryRepository;
        this.catViewRepository = catViewRepository;
        this.mediosRepository = mediosRepository;
        this.tipoMediosRepository =tipoMediosRepository;
        this.objectoUbicacionesRepository = objectoUbicacionesRepository;
        this.espacioPromocionalesRepository = espacioPromocionalesRepository;
        this.eventosRepository = eventosRepository;
        this.usuariosPerfilesRepository = usuariosPerfilesRepository;
        this.parametrosRepository = parametrosRepository;
        this.excelValidationDAO = excelValidationDAO;
    }


    @RequestMapping(path = "etiquetas", method = RequestMethod.POST)
    public EtiquetasDTO getEtiquetas(){
        EtiquetasDTO et = new EtiquetasDTO();
        et.setEVENTO(env.getProperty("evento"));
        et.setEVENTO_PLURAL(env.getProperty("evento.plural"));
        et.setMECANICA(env.getProperty("mecanica"));
        et.setMECANICA_PLURAL(env.getProperty("mecanica.plural"));
        et.setCATEGORIA(env.getProperty("categoria"));
        et.setSUBCATEGORIA(env.getProperty("subcategoria"));
        et.setBTN_BORRAR(env.getProperty("btn.borrar"));
        et.setMENU_BANDEJA(env.getProperty("menu.bandeja"));
        return et;
    }

    /**
     * path para solicitar una version de una forma
     */
    @RequestMapping(path = "/showForm/{dataId}/{viewId}", method = RequestMethod.GET)
    public ResponseEntity<View> getView(@PathVariable Long dataId, @PathVariable Long viewId) {
        List<Application> apps = this.applicationRepository.findAll();

        View view = this.viewRepository.findByViewId(viewId);

        return new ResponseEntity<>(view, HttpStatus.OK);
    }
    
    private List<String> mediumValidation(Long eventosId){
    	List<Medios> medios =  this.mediosRepository.findByEventosIdAndActivo(eventosId, true);
    	List<String> errores = new ArrayList<String>();
    	
    	Map<Integer, Integer> espaciosAsignados = new HashMap<Integer, Integer>();
    	
    	for(Medios medio : medios){
    		TipoMedios tipoMedios = this.tipoMediosRepository.findByTipoMediosId(medio.getTipoMediosId());
    		Integer paginas = tipoMedios.getNumeroPaginas();
    		
    		List<EspacioPromocionales> espacios = this.espacioPromocionalesRepository.findByMediosId(medio.getMediosId());
    		for(EspacioPromocionales espacio : espacios){
				if(espaciosAsignados.containsKey(espacio.getNumeroParte())){
					Integer current = espaciosAsignados.get(espacio.getNumeroParte());
					espaciosAsignados.put(espacio.getNumeroParte(), current + 1);
				}else{
					espaciosAsignados.put(espacio.getNumeroParte(), 1);
				}
			}
    		
    		Map<Integer, Integer> mapPages =  new HashMap<Integer,Integer>(espaciosAsignados);
    		if(mapPages.containsKey(0)){
    			mapPages.remove(0);
    		}if(mapPages.containsKey(paginas + 1)){
    			mapPages.remove(paginas + 1);
    		}
    		
    		if(tipoMedios.getAplicaPortadaYContraportada() && tipoMedios.getRequiereEspacioEnPortada()){
    			boolean tienePaginaEnPortada = espaciosAsignados.containsKey(0);
    			boolean tienePaginaEnContraportada = espaciosAsignados.containsKey(paginas + 1);
    			
    			if(!tienePaginaEnPortada || !tienePaginaEnContraportada){
    				errores.add("Medio: " + medio.getDescripcion() + " requiere al menos un espacio asignado en portada y contraportada. Verifique.");
    			}
    		}
    		if(tipoMedios.getPaginasMinimasConEspacio() > 0){
    			Integer pages = mapPages.size();
    			if(pages < tipoMedios.getPaginasMinimasConEspacio()){
    				errores.add("Medio: " + medio.getDescripcion() + " requiere al menos un espacio asignado en " + 
    				tipoMedios.getPaginasMinimasConEspacio() +
    				" pagina(s). Verifique.");
    			}	
    		}
    	}
    	return errores;
    }
    
    private String getError(List<String> errors){
    	StringBuilder error = new StringBuilder();
    	for(String s: errors){
    		error.append(s).append("<br/>");
    	}
    	return error.toString();
    }
    
    /*agregar datos de estructura*/
    @RequestMapping(value = "Transition/Medium/", method = RequestMethod.POST)
    public ResponseEntity<?> endMedium(@RequestBody WorkFlowRequestDTO data) throws Exception {
        System.out.println(data);
        
        List<String> errores = this.mediumValidation(data.getEventosId());
        
        if(errores.size() > 0){
        	return new ResponseEntity<>(this.getError(errores), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        StructureData requestData = this.structureDataRepository.findByDataId(data.getDataId());

        System.out.println("transiciones: " + requestData.getHistory().size());

        List<StructureDataHistory> res = new ArrayList<StructureDataHistory>();
        for (StructureDataHistory e : requestData.getHistory()) {
            if (e.getActive()) {
                res.add(e);
            }
        }
        // se apaga la transicion actual
        StructureDataHistory activeTransition = res.get(0);
        activeTransition.setActive(false);
        this.structureDataHistoryRepository.save(activeTransition);

        //se busca la siguiente transicion
        Application app = this.applicationRepository.findById(requestData.getAppId());
        System.out.println("buscando transicion de flujo: " + app.getWorkFlow().getWorkFlowId() + ", etapa: " + activeTransition.getWorkFlowConfig().getNextStageConfig().getStageId() + ", code: " + data.getValueCode());
        List<WorkFlowConfig> nextTransition = this.workFlowConfigRepository.findByWorkFlowAndStageConfigAndValueCode(app.getWorkFlow(),
                activeTransition.getWorkFlowConfig().getNextStageConfig(), data.getValueCode());

        WorkFlowConfig nextTrans = nextTransition.get(0);
        
        System.out.println("total de siguientes etapas: " + nextTransition.size());
        StructureDataHistory state = new StructureDataHistory();
        state.setWorkFlowConfig(nextTrans);
        state.setConsecutive(activeTransition.getConsecutive() + 1);
        state.setActive(true);
        state.setDataId(data.getDataId());
        state = this.structureDataHistoryRepository.save(state);
        
        //busca las actividades a realizar al llegar a nueva etapa
        try{
        this.checkTransitionActions(nextTrans, requestData.getEventosId());
        }catch(Exception e){
        	System.out.println("Error a ejecutar acciones de transicion");
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    public void checkTransitionActions(WorkFlowConfig workFlowConfig, Long eventId) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
    	Class<? extends ApplicationController> clazz = this.getClass();
    	for(WorkFlowConfigActions action :  workFlowConfig.getActions()){
    		Method method = clazz.getMethod(action.getValueCode(), Long.class);
        	method.invoke(this, eventId);
    	}
    }
    
    public void dinamicSendOfferMail(Long eventId){
    	System.out.println("Enviando correo a quien corresponda para evento: " + eventId);
    }
    
    /*agregar datos de estructura*/
    @RequestMapping(value = "Transition/Offer/", method = RequestMethod.POST)
    public ResponseEntity<?> endOffer(@RequestBody WorkFlowRequestDTO data) throws Exception {
        System.out.println(data);

        StructureData requestData = this.structureDataRepository.findByDataId(data.getDataId());
        System.out.println("transiciones: " + requestData.getHistory().size());

        List<StructureDataHistory> res = new ArrayList<StructureDataHistory>();
        for (StructureDataHistory e : requestData.getHistory()) {
            if (e.getActive()) {
                res.add(e);
            }
        }
        // se apaga la transicion actual
        StructureDataHistory activeTransition = res.get(0);
        activeTransition.setActive(false);
        this.structureDataHistoryRepository.save(activeTransition);

        //se busca la siguiente transicion
        Application app = this.applicationRepository.findById(requestData.getAppId());
        System.out.println("buscando transicion de flujo: " + app.getWorkFlow().getWorkFlowId() + ", etapa: " + activeTransition.getWorkFlowConfig().getNextStageConfig().getStageId() + ", code: " + data.getValueCode());
        List<WorkFlowConfig> nextTransition = this.workFlowConfigRepository.findByWorkFlowAndStageConfigAndValueCode(app.getWorkFlow(),
                activeTransition.getWorkFlowConfig().getNextStageConfig(), data.getValueCode());

        System.out.println("total de siguientes etapas: " + nextTransition.size());
        StructureDataHistory state = new StructureDataHistory();
        state.setWorkFlowConfig(nextTransition.get(0));
        state.setConsecutive(activeTransition.getConsecutive() + 1);
        state.setActive(true);
        state.setDataId(data.getDataId());
        this.structureDataHistoryRepository.save(state);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    /*agregar datos de estructura*/
    @RequestMapping(value = "Transition/save/", method = RequestMethod.POST)
    public ResponseEntity<?> genericSave(@RequestBody WorkFlowRequestDTO data) throws Exception {
        System.out.println(data);

        StructureData requestData = this.structureDataRepository.findByDataId(data.getDataId());
        System.out.println("transiciones: " + requestData.getHistory().size());

        List<StructureDataHistory> res = new ArrayList<StructureDataHistory>();
        for (StructureDataHistory e : requestData.getHistory()) {
            if (e.getActive()) {
                res.add(e);
            }
        }
        // se apaga la transicion actual
        StructureDataHistory activeTransition = res.get(0);
        activeTransition.setActive(false);
        this.structureDataHistoryRepository.save(activeTransition);

        //se busca la siguiente transicion
        Application app = this.applicationRepository.findById(requestData.getAppId());
        System.out.println("buscando transicion de flujo: " + app.getWorkFlow().getWorkFlowId() + ", etapa: " + activeTransition.getWorkFlowConfig().getNextStageConfig().getStageId() + ", code: " + data.getValueCode());
        List<WorkFlowConfig> nextTransition = this.workFlowConfigRepository.findByWorkFlowAndStageConfigAndValueCode(app.getWorkFlow(),
                activeTransition.getWorkFlowConfig().getNextStageConfig(), data.getValueCode());

        System.out.println("total de siguientes etapas: " + nextTransition.size());
        StructureDataHistory state = new StructureDataHistory();
        state.setWorkFlowConfig(nextTransition.get(0));
        state.setConsecutive(activeTransition.getConsecutive() + 1);
        state.setActive(true);
        state.setDataId(data.getDataId());
        this.structureDataHistoryRepository.save(state);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    

    /*agregar datos de estructura*/
    @RequestMapping(value = "Transition/", method = RequestMethod.POST)
    public ResponseEntity<?> createTransition(@RequestBody WorkFlowRequestDTO data) throws Exception {
        System.out.println(data);

        StructureData requestData = this.structureDataRepository.findByDataId(data.getDataId());

        System.out.println("transiciones: " + requestData.getHistory().size());

        List<StructureDataHistory> res = new ArrayList<StructureDataHistory>();
        for (StructureDataHistory e : requestData.getHistory()) {
            if (e.getActive()) {
                res.add(e);
            }
        }
        System.out.println("transiciones filtradas: " + res.size());

        // se apaga la transicion actual
        StructureDataHistory activeTransition = res.get(0);
        activeTransition.setActive(false);
        this.structureDataHistoryRepository.save(activeTransition);

        //se busca la siguiente transicion
        Application app = this.applicationRepository.findById(requestData.getAppId());
        System.out.println("buscando transicion de flujo: " + app.getWorkFlow().getWorkFlowId() + ", etapa: " + activeTransition.getWorkFlowConfig().getNextStageConfig().getStageId() + ", code: " + data.getValueCode());
        List<WorkFlowConfig> nextTransition = this.workFlowConfigRepository.findByWorkFlowAndStageConfigAndValueCode(app.getWorkFlow(),
                activeTransition.getWorkFlowConfig().getNextStageConfig(), data.getValueCode());

        System.out.println("total de siguientes etapas: " + nextTransition.size());

        StructureDataHistory state = new StructureDataHistory();
        state.setWorkFlowConfig(nextTransition.get(0));
        state.setConsecutive(activeTransition.getConsecutive() + 1);
        state.setActive(true);
        state.setDataId(data.getDataId());
        this.structureDataHistoryRepository.save(state);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*agregar datos de estructura*/
    @RequestMapping(value = "StructureData/", method = RequestMethod.POST)
    public ResponseEntity<?> createStructureData(@RequestBody AddEventoModel model) throws ServletException {

        StructureData data = model.getStructureData();
        Eventos eventos = model.getEventos();

        if (eventos == null || eventos.getNombre().length() == 0){
            throw new ServletException("Evento Nulo o debe contener nombre");
        }
        try{
            eventos = eventosRepository.save(eventos);
        }catch (Exception e){
            throw new ServletException("Error al guardar Evento => " + e.getMessage());
        }


        System.out.println("valores objeto: " + data);

        if (data.getDetail() == null || data.getDetail().size() == 0) {
            System.out.println("sin detalle, generando uno");
            StructureDataDetail detail = new StructureDataDetail();
            detail.setProperty("description");
            detail.setValue(data.getDescription());
            detail.setStructureId(1L);
            detail.setActive(true);
            Set<StructureDataDetail> detailList = new HashSet<StructureDataDetail>();
            detailList.add(detail);
            data.setDetail(detailList);
        }

        //buscamos el id de la aplicacion para obtener el flujo
        if (data.getAppId() == null || data.getAppId().longValue() <= 0) {
            throw new ServletException("Informacion incorrecta");
        }
        Application app = this.applicationRepository.findById(data.getAppId());

        List<WorkFlowConfig> wc = this.workFlowConfigRepository.findByWorkFlowAndStageConfigAndValueCode(app.getWorkFlow(), app.getWorkFlow().getFirstStageConfig(), app.getWorkFlow().getFirstValueCode());

        WorkFlowConfig config = wc.get(0);

        StructureDataHistory state = new StructureDataHistory();
        state.setWorkFlowConfig(config);
        state.setConsecutive(1L);
        state.setActive(true);
        Set<StructureDataHistory> history = new HashSet<StructureDataHistory>();
        history.add(state);

        data.setHistory(history);

        System.out.println("total en detalle. " + data.getDetail().size());
        System.out.println("total en historia. " + data.getHistory().size());


        data.setEventosId(eventos.getEventosId());
        data = structureDataRepository.save(data);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI dataURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(data.getDataId()).toUri();
        responseHeaders.setLocation(dataURI);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "StructureData/", method = RequestMethod.GET)
    public ResponseEntity<List<StructureData>> getStructureData(HttpServletRequest request, @RequestHeader(value = "userid", defaultValue = "-1") String userId) {
    	
    	//List<StructureData> elements = structureDataRepository.findAll();
    	//List<StructureData> elements = structureDataRepository.findByActiveOrderByDataIdDesc(true);
    	List<StructureData> elements = new ArrayList<StructureData>();
    	
    	Long user = new Long(userId);
    	if(user.intValue() > 0){
    		elements = this.structureDataRepository.loadInboxInfo(user);
    	}else{
    		elements = structureDataRepository.findByActiveOrderByDataIdDesc(true);
    	}
    	
        return new ResponseEntity<>(elements, HttpStatus.OK);
    }
        
    @RequestMapping(value = "hasUserRequestCreationProfile/", method = RequestMethod.GET)
    public ResponseEntity<Boolean> hasUserRequestCreationProfile(@RequestHeader(value = "userid", defaultValue = "-1") String userId) {
    	
    	Boolean canCreateRequest = false;
    	Long user = new Long(userId);
    	
    	List<UsuariosPerfiles> profiles = this.usuariosPerfilesRepository.findByUsuariosId(user);
    	Parametros admin = this.parametrosRepository.findByNombreContaining("idPerfilAdministrador").get(0);
    	Parametros creator = this.parametrosRepository.findByNombreContaining("idPerfilCreadorTramites").get(0);
    	
    	for(UsuariosPerfiles profile : profiles){
    		if(profile.getPerfilesId() == Integer.parseInt(admin.getValor()) || 
    		   profile.getPerfilesId() == Integer.parseInt(creator.getValor())){
    			canCreateRequest = true;
    			break;
    		}
    	}
        return new ResponseEntity<>(canCreateRequest, HttpStatus.OK);
    }
    
    @RequestMapping(value = "getCatalogExcelValidationResult/", method = RequestMethod.POST)
    public ResponseEntity<Integer> getCatalogExcelValidationResult(@RequestBody CatalogValidationModel model) {
    	System.out.println(model.getQ());
    	Integer result = this.excelValidationDAO.executeQueryValidation(model.getQ());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @RequestMapping(path = "Apps/", method = RequestMethod.GET)
    public ResponseEntity<List<Application>> getUsers() {
        List<Application> apps = this.applicationRepository.findAll();
        return new ResponseEntity<>(apps, HttpStatus.OK);
    }

    @RequestMapping(path = "DataStructures/{structureId}", method = RequestMethod.GET)
    public ResponseEntity<?> getDataStructure(@PathVariable Long structureId) {
        DataStructure dataStructure = dataStructureRepository.findByDataStructureId(structureId);
        if (dataStructure == null) {
            throw new ResourceNotFoundException("Estructura: " + structureId + " no encontrada");
        }
        return new ResponseEntity<>(dataStructure, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "showView/{dataId}/{viewId}", method = RequestMethod.GET)
    public ResponseEntity<View> getViewInfo(@PathVariable Long dataId, @PathVariable Long viewId) {
    	
    	System.out.println("dataId: " + dataId);
    	System.out.println("VIEWID: " + viewId);
    	
    	//sacar la aplicacion del request
    	StructureData data = this.structureDataRepository.findByDataId(dataId);
    	Application app = this.applicationRepository.findById(data.getAppId());
    	
    	CatView cv = this.catViewRepository.findByCatViewId(viewId);
    	//sacar la configuracion de la vista por app
    	View resultView = viewRepository.findByCatViewAndApplicationAndActive(cv, app, true);
    	
        return new ResponseEntity<>(resultView, HttpStatus.OK);
    }

    @RequestMapping(value = "showViewByApp/{appId}/{viewId}", method = RequestMethod.GET)
    public ResponseEntity<View> getViewByAppInfo(@PathVariable Long appId, @PathVariable Long viewId) {

        System.out.println("dataId: " + appId);
        System.out.println("VIEWID: " + viewId);

        //sacar la aplicacion del request
        Application app = this.applicationRepository.findById(appId);

        CatView cv = this.catViewRepository.findByCatViewId(viewId);
        //sacar la configuracion de la vista por app
        View resultView = viewRepository.findByCatViewAndApplicationAndActive(cv, app, true);
        
        System.out.println("resultado : " + resultView);

        return new ResponseEntity<>(resultView, HttpStatus.OK);
    }
}
