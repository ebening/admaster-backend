package com.adinfi.admaster.domain.bussinnes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Presentaciones")
public class Presentaciones implements ICatalog{

	@Id
	@Column(name = "PresentacionesId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long presentacionesId;

	@Column(name = "Nombre", length = 50)
	@NotNull
	@Size(min = 2, max = 50)
	private String nombre;
	
	public Presentaciones(){
		
	}
	
	public Presentaciones(Long presentacionesId, String nombre){
		this.presentacionesId = presentacionesId;
		this.nombre = nombre;
	}

	public Long getPresentacionesId() {
		return presentacionesId;
	}

	public void setPresentacionesId(Long presentacionesId) {
		this.presentacionesId = presentacionesId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public Long getId() {
		return this.presentacionesId;
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
