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
@Table(name = "Modelos")
public class Modelos implements ICatalog{

	@Id
	@Column(name = "ModelosId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long modelosId;

	@Column(name = "Nombre", length = 50)
	@NotNull
	@Size(min = 2, max = 50)
	private String nombre;

	public Modelos(){
		
	}
	
	public Modelos(Long modelosId, String nombre){
		this.modelosId = modelosId;
		this.nombre = nombre;
	}
	
	public Long getModelosId() {
		return modelosId;
	}

	public void setModelosId(Long modelosId) {
		this.modelosId = modelosId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public Long getId() {
		return this.modelosId;
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
