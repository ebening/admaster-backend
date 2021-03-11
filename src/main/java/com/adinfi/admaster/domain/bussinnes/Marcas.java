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
@Table(name = "Marcas")
public class Marcas implements ICatalog{

	@Id
	@Column(name = "MarcasId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long marcasId;

	@Column(name = "Nombre", length = 50)
	@NotNull
	@Size(min = 2, max = 50)
	private String nombre;
	
	@Column(name = "SubMarcasId")
	@NotNull
	private Long subMarcasId;

	public Marcas(){
		
	}
	
	public Marcas(Long marcasId, String nombre){
		this.marcasId = marcasId;
		this.nombre = nombre;
	}
	
	public Long getMarcasId() {
		return marcasId;
	}

	public void setMarcasId(Long marcasId) {
		this.marcasId = marcasId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getSubMarcasId() {
		return subMarcasId;
	}

	public void setSubMarcasId(Long subMarcasId) {
		this.subMarcasId = subMarcasId;
	}

	@Override
	public Long getId() {
		return this.marcasId;
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
