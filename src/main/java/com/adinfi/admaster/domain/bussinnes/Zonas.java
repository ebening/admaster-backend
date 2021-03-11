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
@Table(name = "Zonas")
public class Zonas implements ICatalog{

	@Id
	@Column(name = "ZonasId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long zonasId;

	@Column(name = "Nombre", length = 50)
	@NotNull
	@Size(min = 4, max = 50)
	private String nombre;
	
	@Column(name="Activo")
	private Boolean activo;
	
	@Column(name = "RegionesId")
	@NotNull
	private Long regionesId;

	@Column(name="FechaCreacion")
	private Timestamp fechaCreacion;
	
	@Column(name="FechaModificacion")
	private Timestamp fechaModificacion;
	
	@Column(name="UsuarioCreadorId")
	private Long usuarioCreadorId;
	
	@Column(name="UsuarioModificadorId")
	private Long usuarioModificadorId;

	public Long getZonasId() {
		return zonasId;
	}

	public void setZonasId(Long zonasId) {
		this.zonasId = zonasId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Long getRegionesId() {
		return regionesId;
	}

	public void setRegionesId(Long regionesId) {
		this.regionesId = regionesId;
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

	@Override
	public Long getId() {
		return this.zonasId;
	}

	@Override
	public String getName() {
		return this.nombre;
	}

	@Override
	public String getText() {
		return this.getName();
	}

}
