package com.adinfi.admaster.domain.bussinnes;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ObjectoUbicaciones")
public class ObjectoUbicaciones implements ICatalog{

	@Id
	@Column(name = "ObjectoUbicacionId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long objectoUbicacionId;
	
	@Column(name = "PaisId")
	@NotNull
	private Long paisId;
	
	@Column(name = "RegionesId")
	@NotNull
	private Long regionesId;
	
	@Column(name = "ZonasId")
	@NotNull
	private Long zonasId;
	
	@Column(name = "GruposId")
	private Long gruposId;
	
	@Column(name = "CadenasId")
	private Long cadenasId;
	
	@Column(name = "TipoUbicacionesId")
	private Long tipoUbicacionesId;
	
	@Column(name = "MecanicasId")
	private Long mecanicasId;
	
	@Column(name = "MediosId")
	private Long mediosId;
	
	@Column(name = "EventosId")
	private Long eventosId;
	
	@Column(name = "TipoObjetoId")
	private Long tipoObjetoId;
	
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

	public Long getObjectoUbicacionId() {
		return objectoUbicacionId;
	}

	public void setObjectoUbicacionId(Long objectoUbicacionId) {
		this.objectoUbicacionId = objectoUbicacionId;
	}

	public Long getPaisId() {
		return paisId;
	}

	public void setPaisId(Long paisId) {
		this.paisId = paisId;
	}

	public Long getRegionesId() {
		return regionesId;
	}

	public void setRegionesId(Long regionesId) {
		this.regionesId = regionesId;
	}

	public Long getZonasId() {
		return zonasId;
	}

	public void setZonasId(Long zonasId) {
		this.zonasId = zonasId;
	}

	public Long getGruposId() {
		return gruposId;
	}

	public void setGruposId(Long gruposId) {
		this.gruposId = gruposId;
	}

	public Long getCadenasId() {
		return cadenasId;
	}

	public void setCadenasId(Long cadenasId) {
		this.cadenasId = cadenasId;
	}

	public Long getTipoUbicacionesId() {
		return tipoUbicacionesId;
	}

	public void setTipoUbicacionesId(Long tipoUbicacionesId) {
		this.tipoUbicacionesId = tipoUbicacionesId;
	}

	public Long getTipoObjetoId() {
		return tipoObjetoId;
	}

	public void setTipoObjetoId(Long tipoObjetoId) {
		this.tipoObjetoId = tipoObjetoId;
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

	public Long getMecanicasId() {
		return mecanicasId;
	}

	public void setMecanicasId(Long mecanicasId) {
		this.mecanicasId = mecanicasId;
	}

	public Long getMediosId() {
		return mediosId;
	}

	public void setMediosId(Long mediosId) {
		this.mediosId = mediosId;
	}

	public Long getEventosId() {
		return eventosId;
	}

	public void setEventosId(Long eventosId) {
		this.eventosId = eventosId;
	}

	@Override
	public Long getId() {
		return this.getTipoObjetoId();
	}

	@Override
	public String getName() {
		return this.getTipoObjetoId().toString();
	}

	@Override
	public String getText() {
		return this.getTipoObjetoId().toString();
	}

}
