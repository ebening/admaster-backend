package com.adinfi.admaster.dto;

import java.util.Date;

public class EspaciosRequestDTO {

	private Integer paginasId;
	private Integer espaciosId;
	private Long categoriasId;
	private Long subCategoriasId;
	
	public Integer getPaginasId() {
		return paginasId;
	}
	public void setPaginasId(Integer paginasId) {
		this.paginasId = paginasId;
	}
	public Integer getEspaciosId() {
		return espaciosId;
	}
	public void setEspaciosId(Integer espaciosId) {
		this.espaciosId = espaciosId;
	}
	public Long getCategoriasId() {
		return categoriasId;
	}
	public void setCategoriasId(Long categoriasId) {
		this.categoriasId = categoriasId;
	}
	public Long getSubCategoriasId() {
		return subCategoriasId;
	}
	public void setSubCategoriasId(Long subCategoriasId) {
		this.subCategoriasId = subCategoriasId;
	}
	
}
