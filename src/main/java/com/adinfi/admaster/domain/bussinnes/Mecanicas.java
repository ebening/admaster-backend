package com.adinfi.admaster.domain.bussinnes;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Mecanicas")
public class Mecanicas implements ICatalog{

	@Id
	@Column(name = "MecanicasId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long mecanicasId;

	@Column(name = "Nombre", length = 50)
	@NotNull
	@Size(min = 2, max = 50)
	private String nombre;
	
	@Column(name = "Combo")
	private Long combo;

	@Column(name = "TipoMecanicasId")
	private Long tipoMecanicasId;
	
	@Column(name = "PorcentajeDescuento")
	private Double porcentajdeDescuento;
	
	@Column(name = "CantidadUno")
	private Integer canitadadUno;
	
	@Column(name = "CantidadPor")
	private Integer canitadadPor;
	
	@Column(name = "LMMJVSD")
	private String lmmjvsd;
	
	@Column(name = "PreciosOferta")
	private Double preciosOferta;
	
	@Column(name = "PreciazoClub")
	private Double preciazoClub;
	
	@Column(name = "Cañonazo")
	private Boolean cañonazo;
	
	@Column(name = "CoberturasId")
	private Long coberturasId;
	
	@Column(name="FechaInicio")
	private Timestamp fechaInicio;
	
	@Column(name="FechaFinal")
	private Timestamp fechaFinal;
	
	@Column(name = "SessionId")
	private String sessionId;
	
	@Column(name = "Activo")
	private Boolean activo;
	
	@Column(name = "Observaciones")
	private String observaciones;
	
	@Column(name="FechaCreacion")
	private Timestamp fechaCreacion;
	
	@Column(name="FechaModificacion")
	private Timestamp fechaModificacion;
	
	@Column(name="UsuarioCreadorId")
	private Long usuarioCreadorId;
	
	@Column(name="UsuarioModificadorId")
	private Long usuarioModificadorId;
	
	@Column(name = "NombreArchivo")
	private String nombreArchivo;

	public Long getMecanicasId() {
		return mecanicasId;
	}

	public void setMecanicasId(Long mecanicasId) {
		this.mecanicasId = mecanicasId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCombo() {
		return combo;
	}

	public void setCombo(Long combo) {
		this.combo = combo;
	}

	public Long getTipoMecanicasId() {
		return tipoMecanicasId;
	}

	public void setTipoMecanicasId(Long tipoMecanicasId) {
		this.tipoMecanicasId = tipoMecanicasId;
	}

	public Double getPorcentajdeDescuento() {
		return porcentajdeDescuento;
	}

	public void setPorcentajdeDescuento(Double porcentajdeDescuento) {
		this.porcentajdeDescuento = porcentajdeDescuento;
	}

	public Integer getCanitadadUno() {
		return canitadadUno;
	}

	public void setCanitadadUno(Integer canitadadUno) {
		this.canitadadUno = canitadadUno;
	}

	public Integer getCanitadadPor() {
		return canitadadPor;
	}

	public void setCanitadadPor(Integer canitadadPor) {
		this.canitadadPor = canitadadPor;
	}

	public String getLmmjvsd() {
		return lmmjvsd;
	}

	public void setLmmjvsd(String lmmjvsd) {
		this.lmmjvsd = lmmjvsd;
	}

	public Double getPreciosOferta() {
		return preciosOferta;
	}

	public void setPreciosOferta(Double preciosOferta) {
		this.preciosOferta = preciosOferta;
	}

	public Double getPreciazoClub() {
		return preciazoClub;
	}

	public void setPreciazoClub(Double preciazoClub) {
		this.preciazoClub = preciazoClub;
	}

	public Boolean getCañonazo() {
		return cañonazo;
	}

	public void setCañonazo(Boolean cañonazo) {
		this.cañonazo = cañonazo;
	}

	public Long getCoberturasId() {
		return coberturasId;
	}

	public void setCoberturasId(Long coberturasId) {
		this.coberturasId = coberturasId;
	}

	public Timestamp getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Timestamp getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Timestamp fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Long getUsuarioCreadorId() {
		return usuarioCreadorId;
	}

	public void setUsuarioCreadorId(Long usuarioCreadorId) {
		this.usuarioCreadorId = usuarioCreadorId;
	}

	public Long getUsuarioModificadorId() {
		return usuarioModificadorId;
	}

	public void setUsuarioModificadorId(Long usuarioModificadorId) {
		this.usuarioModificadorId = usuarioModificadorId;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	@Override
	public Long getId() {
		return this.mecanicasId;
	}

	@Override
	public String getName() {
		return this.nombre;
	}

	@Override
	public String getText() {
		return this.nombre;
	}
}
