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
@Table(name = "SubCategoria")
public class SubCategoria implements ICatalog{

	@Id
	@Column(name = "SubCategoriasId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long subCategoriasId;

	@Column(name = "Nombre", length = 50)
	@NotNull
	@Size(min = 4, max = 50)
	private String nombre;
	
	@Column(name = "CategoriasId")
	@NotNull
	private Long categoriasId;

	public Long getSubCategoriasId() {
		return subCategoriasId;
	}

	public void setSubCategoriasId(Long subCategoriasId) {
		this.subCategoriasId = subCategoriasId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCategoriasId() {
		return categoriasId;
	}

	public void setCategoriasId(Long categoriasId) {
		this.categoriasId = categoriasId;
	}

	@Override
	public Long getId() {
		return this.getSubCategoriasId();
	}

	@Override
	public String getName() {
		return this.getNombre();
	}

	@Override
	public String getText() {
		return this.getName();
	}

}
