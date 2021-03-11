package com.adinfi.admaster.domain.bussinnes;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.adinfi.admaster.domain.StructureDataDetail;

@Entity
@Table(name = "Medios")
public class Medios implements ICatalog{

	@Id
	@Column(name = "MediosId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long mediosId;

	@Column(name = "Descripcion", length = 50)
	@NotNull
	@Size(min = 4, max = 50)
	private String descripcion;
	
	@Column(name = "TipoMediosId")
	@NotNull
	private Long tipoMediosId;
	
	@Column(name="NumeroPartes")
	private Integer numeroPartes;
	
	@Column(name="NumeroSecciones")
	private Integer numeroSecciones;
	
	@Column(name="FechaInicial")
	private Date fechaInicial;
	
	@Column(name="FechaFinal")
	private Date fechaFinal;
	
	@Column(name = "StatusId")
	@NotNull
	private Long statusId;
	
	@Column(name = "EventosId")
	@NotNull
	private Long eventosId;
	
	@Column(name="Precio1")
	private Double precio1;
	
	@Column(name="Precio2")
	private Double precio2;
	
	@Column(name="Activo")
	private Boolean activo;
	
	@Column(name="FechaCreacion")
	private Timestamp fechaCreacion;
	
	@Column(name="FechaModificacion")
	private Timestamp fechaModificacion;
	
	@Column(name="UsuarioCreadorId")
	private Long usuarioCreadorId;
	
	@Column(name="UsuarioModificadorId")
	private Long usuarioModificadorId;
	
	@Column(name="UsuariosId")
	private Long usuariosId;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="MediosId")
	@OrderBy
	private Set<ObjectoUbicaciones> zones;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="MediosId")
	@OrderBy
	private Set<EspacioPromocionales> espacios;

	public Long getMediosId() {
		return mediosId;
	}

	public void setMediosId(Long mediosId) {
		this.mediosId = mediosId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getTipoMediosId() {
		return tipoMediosId;
	}

	public void setTipoMediosId(Long tipoMediosId) {
		this.tipoMediosId = tipoMediosId;
	}

	public Integer getNumeroPartes() {
		return numeroPartes;
	}

	public void setNumeroPartes(Integer numeroPartes) {
		this.numeroPartes = numeroPartes;
	}

	public Integer getNumeroSecciones() {
		return numeroSecciones;
	}

	public void setNumeroSecciones(Integer numeroSecciones) {
		this.numeroSecciones = numeroSecciones;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public Long getEventosId() {
		return eventosId;
	}

	public void setEventosId(Long eventosId) {
		this.eventosId = eventosId;
	}

	public Double getPrecio1() {
		return precio1;
	}

	public void setPrecio1(Double precio1) {
		this.precio1 = precio1;
	}

	public Double getPrecio2() {
		return precio2;
	}

	public void setPrecio2(Double precio2) {
		this.precio2 = precio2;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
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

	public Long getUsuariosId() {
		return usuariosId;
	}

	public void setUsuariosId(Long usuariosId) {
		this.usuariosId = usuariosId;
	}

	@Override
	public Long getId() {
		return this.mediosId;
	}

	@Override
	public String getName() {
		return this.descripcion;
	}

	@Override
	public String getText() {
		return this.descripcion;
	}
	
	public void setFechaInicialTime(Long time){
		this.fechaInicial.setTime(time);
	}
	public void setFechaFinalTime(Long time){
		this.fechaFinal.setTime(time);
	}

	public Set<ObjectoUbicaciones> getZones() {
		return zones;
	}

	public void setZones(Set<ObjectoUbicaciones> zones) {
		this.zones = zones;
	}

	public Set<EspacioPromocionales> getEspacios() {
		return espacios;
	}

	public void setEspacios(Set<EspacioPromocionales> espacios) {
		this.espacios = espacios;
	}

}
