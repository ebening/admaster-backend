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
@Table(name = "Combos")
public class Combos implements ICatalog{

	@Id
	@Column(name = "CombosId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long combosId;

	@Column(name = "Descripcion", length = 50)
	@NotNull
	@Size(min = 2, max = 50)
	private String descripcion;
	
	@Column(name="Activo")
	private Boolean activo;
	
	@Column(name="FechaCreacion")
	private Timestamp fechaCreacion;
	
	@Column(name="FechaModificacion")
	private Timestamp fechaModificacion;
	
	@Column(name="UsuarioCreador")
	private Long usuarioCreadorId;
	
	@Column(name="UsuarioModificador")
	private Long usuarioModificadorId;

	public Combos(){
		
	}
	
	public Combos(Long combosId, String descripcion){
		this.combosId = combosId;
		this.descripcion = descripcion;
	}
	public Long getCombosId() {
		return combosId;
	}

	public void setCombosId(Long combosId) {
		this.combosId = combosId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	@Override
	public Long getId() {
		return this.combosId;
	}

	@Override
	public String getName() {
		return this.descripcion;
	}

	@Override
	public String getText() {
		return this.descripcion;
	}

}
