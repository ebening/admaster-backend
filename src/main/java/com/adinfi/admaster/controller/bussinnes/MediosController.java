package com.adinfi.admaster.controller.bussinnes;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.adinfi.admaster.domain.StructureData;
import com.adinfi.admaster.domain.bussinnes.Categorias;
import com.adinfi.admaster.domain.bussinnes.EspacioPromocionales;
import com.adinfi.admaster.domain.bussinnes.Eventos;
import com.adinfi.admaster.domain.bussinnes.Medios;
import com.adinfi.admaster.domain.bussinnes.ObjectoUbicaciones;
import com.adinfi.admaster.domain.bussinnes.TipoMedios;
import com.adinfi.admaster.dto.EspaciosRequestDTO;
import com.adinfi.admaster.dto.MediosRequestDTO;
import com.adinfi.admaster.dto.WorkFlowRequestDTO;
import com.adinfi.admaster.repository.StructureDataRepository;
import com.adinfi.admaster.repository.bussinnes.CategoriasRepository;
import com.adinfi.admaster.repository.bussinnes.EspacioPromocionalesRepository;
import com.adinfi.admaster.repository.bussinnes.EventosRepository;
import com.adinfi.admaster.repository.bussinnes.MediosRepository;
import com.adinfi.admaster.repository.bussinnes.ObjectoUbicacionesRepository;
import com.adinfi.admaster.repository.bussinnes.TipoMediosRepository;

@RestController
@RequestMapping("/medios")
public class MediosController {

	private final MediosRepository mediosRepository;
	private final TipoMediosRepository tipoMediosRepository;
	private final ObjectoUbicacionesRepository objectoUbicacionesRepository;
	private final EspacioPromocionalesRepository espacioPromocionalesRepository;

	@Autowired
	public MediosController(MediosRepository mediosRepository, TipoMediosRepository tipoMediosRepository, 
			ObjectoUbicacionesRepository objectoUbicacionesRepository, EspacioPromocionalesRepository espacioPromocionalesRepository) {
		this.mediosRepository = mediosRepository;
		this.tipoMediosRepository = tipoMediosRepository;
		this.objectoUbicacionesRepository = objectoUbicacionesRepository;
		this.espacioPromocionalesRepository = espacioPromocionalesRepository;
	}

	/* 
	 * funcion para crear un medio nuevo
	 * */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> createMedio(@RequestBody MediosRequestDTO data) throws Exception {
    	
    	//si no existe el evento en el periodo
    	Medios medios = this.mediosRepository.findByTipoMediosIdAndEventosIdAndFechaInicialAndFechaFinalAndZones_zonasIdAndActivo(
    			data.getTipoMediosId(),
    			data.getEventosId(), 
    			data.getFechaInicial(), 
    			data.getFechaFinal(), 
    			data.getZonasId(),
    			true);
    	
    	if( medios == null ){
    		
    		if(data.getDescription() != null && data.getDescription().length() > 0){
    			
    			List<Medios> mediosList = this.mediosRepository.findByEventosIdAndDescripcionIgnoreCaseAndActivo(data.getEventosId(), data.getDescription(), true);
    			
    			if(mediosList != null && !mediosList.isEmpty()){
    				return new ResponseEntity<>("La descripción capturada ya existe en otro medio. Verifique.", HttpStatus.INTERNAL_SERVER_ERROR);
    			}
    		}

    		medios = this.saveMediosAndZones(data);    
    		
    		//override de los espacios del medio
    		this.overrideSpaces(medios.getMediosId(), data.getEspacios());
    		
    		HttpHeaders responseHeader = new HttpHeaders();
    		responseHeader.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(medios.getMediosId()).toUri());
    		return new ResponseEntity<>(medios, responseHeader, HttpStatus.CREATED);
    	//si existe, pregunto por la zona
    	}else{
    		return new ResponseEntity<>("El medio que se intenta agregar ya existe. Verifique.", HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /*
     * Funcion para actualizar datos de medio
     * */
    @RequestMapping(value = "/{mediosId}", method = RequestMethod.POST)
    public ResponseEntity<?> updateMedio(@RequestBody MediosRequestDTO data, @PathVariable Long mediosId) throws Exception {
    	
    	Medios element = this.mediosRepository.findByMediosId(mediosId);
    	
    	TipoMedios tm = this.tipoMediosRepository.findByTipoMediosId(data.getTipoMediosId());
    	
    	element.setTipoMediosId(tm.getTipoMediosId());
    	element.setNumeroPartes(tm.getNumeroPaginas());
    	element.setNumeroSecciones(tm.getMaximoDeEspacios());
    	
    	element.setFechaInicial(data.getFechaInicial());
    	element.setFechaFinal(data.getFechaFinal());
    	
    	ObjectoUbicaciones zone = getObjectoUbicacionesByRequest(mediosId, data);
    	element.getZones().clear();
    	element.getZones().add(zone);
    	
    	Medios current = this.mediosRepository.findByTipoMediosIdAndEventosIdAndFechaInicialAndFechaFinalAndZones_zonasIdAndActivo(
    			element.getTipoMediosId(), 
    			element.getEventosId(), 
    			element.getFechaInicial(), 
    			element.getFechaFinal(), 
    			zone.getZonasId(), true);
    	
    	if(current != null && current.getMediosId() != element.getMediosId()){
    		return new ResponseEntity<>("La información que modificó ya existe en otro medio. Verifique.", HttpStatus.INTERNAL_SERVER_ERROR);
    	}
 
    	element.setDescripcion(data.getDescription());
    	
    	List<Medios> sameName = this.mediosRepository.findByEventosIdAndDescripcionIgnoreCaseAndActivo(element.getEventosId(), data.getDescription(), true);
    	
    	boolean existsName = false;
    	if(sameName != null && sameName.size() > 0){
    		for(Medios m : sameName){
    			if(m.getMediosId() != element.getMediosId()){
    				existsName = true;
    				break;
    			}
    		}
    	}
    	if(existsName){
    		return new ResponseEntity<>("La descripción ingresada ya existe en otro medio. Verifique.", HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
    	this.mediosRepository.save(element);
    	//override de los espacios del medio
		this.overrideSpaces(element.getMediosId(), data.getEspacios());
    	
		return new ResponseEntity<>(element, HttpStatus.OK);
    }
    
    /*
     * funcion para eliminar los datos de un medio
     * */
    @RequestMapping(value = "/{mediosId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMedio(@PathVariable Long mediosId) throws Exception {
    	
    	Medios element = this.mediosRepository.findByMediosId(mediosId);
    	
    	List<EspacioPromocionales> espacios = this.espacioPromocionalesRepository.findByMediosId(element.getMediosId());
    	
    	for(EspacioPromocionales espacio : espacios){
    		this.espacioPromocionalesRepository.delete(espacio);
    	}
    	
    	element.setActivo(false);
    	this.mediosRepository.save(element);
    	
		return new ResponseEntity<>(element, HttpStatus.OK);
    }
    
    /*
     * Funcion para obtener medios en base al id del evento
     * */
    @RequestMapping(path = "/findByEventosId/{eventosId}", method = RequestMethod.GET)
   	public ResponseEntity<Page<Medios>> findByStructureDataId(@PathVariable Long eventosId, Pageable pageable) {
       	Page<Medios> m = this.mediosRepository.findByEventosIdAndActivo(eventosId, true, pageable);
   		return new ResponseEntity<>(m, HttpStatus.OK);
   	}
    
    /*
     * Funcion para obtener medios en base al id del evento y el nombre del medio (Busqueda de tabla)
     * */
    @RequestMapping(path = "/findByEventosIdAndName/{eventosId}/{text}", method = RequestMethod.GET)
   	public ResponseEntity<Page<Medios>> findByStructureDataId(@PathVariable Long eventosId, @PathVariable String text, Pageable pageable) {
       	Page<Medios> result = this.mediosRepository.findByEventosIdAndActivoAndDescripcionLikeIgnoreCase(eventosId, true, "%"+text+"%", pageable);
   		return new ResponseEntity<>(result, HttpStatus.OK);
   	}
    

    private void overrideSpaces(Long mediosId, List<EspaciosRequestDTO> espacios){
    	List<EspacioPromocionales> currentMediosSpaces = this.espacioPromocionalesRepository.findByMediosId(mediosId);
		
		if(currentMediosSpaces != null && !currentMediosSpaces.isEmpty()){
			this.espacioPromocionalesRepository.delete(currentMediosSpaces);
		}
		
		for(EspaciosRequestDTO e : espacios){
			EspacioPromocionales c = new EspacioPromocionales();
			c.setMediosId(mediosId);
			c.setNumeroParte(e.getPaginasId());
			c.setNumeroSeccion(e.getEspaciosId());
			c.setCategoriasId(e.getCategoriasId());
			c.setSubCategoriasId(e.getSubCategoriasId());
			c.setDueña(true);
			c.setActivo(true);
			c.setFechaCreacion(new Timestamp(new Date().getTime()));	
			this.espacioPromocionalesRepository.save(c);
		}
    }

    private Medios saveMediosAndZones(MediosRequestDTO data){
    	Medios medios = this.getMediosByRequest(data);
		medios = this.mediosRepository.save(medios);
		ObjectoUbicaciones o = this.getObjectoUbicacionesByRequest(medios.getMediosId(), data);
		o = this.objectoUbicacionesRepository.save(o);
		return medios;
    }
    
    private ObjectoUbicaciones getObjectoUbicacionesByRequest(Long mediosId, MediosRequestDTO data){
    	ObjectoUbicaciones o = new ObjectoUbicaciones();
    	o.setPaisId(1L);
    	o.setRegionesId(1L);
    	o.setZonasId(data.getZonasId());
    	o.setTipoUbicacionesId(1L);
    	o.setMediosId(mediosId);
    	o.setTipoObjetoId(1L);
    	o.setActivo(true);
    	o.setFechaCreacion(new Timestamp(new Date().getTime()));
    	o.setUsuarioCreadorId(1L);
    	return o;
    }
    
    private Medios getMediosByRequest(MediosRequestDTO data){
    	Medios e = new Medios();
		e.setActivo(true);
		if(data.getDescription() != null && data.getDescription().length() > 0 ){
		e.setDescripcion(data.getDescription());
		}else{
			e.setDescripcion(data.getTipoMediosStr() + " " + data.getZonasStr() + " " + this.getDateCode(data.getFechaInicial()) + "-" + this.getDateCode(data.getFechaFinal()));
		}
		e.setTipoMediosId(data.getTipoMediosId());
		
		TipoMedios tm = this.tipoMediosRepository.findByTipoMediosId(data.getTipoMediosId());
		e.setNumeroPartes(tm.getNumeroPaginas());
		e.setNumeroSecciones(tm.getMaximoDeEspacios());
		
		e.setFechaInicial(data.getFechaInicial());
		e.setFechaFinal(data.getFechaFinal());
		e.setStatusId(1L);
		e.setEventosId(data.getEventosId());
		e.setFechaCreacion(new Timestamp(new Date().getTime()));
		e.setUsuarioCreadorId(1L);
		e.setUsuariosId(1L);
		return e;
    }
    
    private String getDateCode(Date date){
    	String[] days = new String[]{"D","L","M","M","J","V","S"};
    	String[] months = new String[]{"ENE","FEB","MAR","ABR","MAY","JUN","JUL","AGO","SEP","OCT","NOV","DIC"};
    	Calendar c = Calendar.getInstance();
    	c.setTime(date);
    	
    	String day = days[c.get(Calendar.DAY_OF_WEEK)-1];
    	String dayNumber = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
    	String month = months[c.get(Calendar.MONTH)];
    	
    	return day + month + (dayNumber.length() == 1 ? "0".concat(dayNumber) : dayNumber);
    }
}
