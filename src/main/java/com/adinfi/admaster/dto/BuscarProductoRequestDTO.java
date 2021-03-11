package com.adinfi.admaster.dto;

import com.adinfi.admaster.domain.bussinnes.ICatalog;

/**
 * Created by jgonzalez
 */

public class BuscarProductoRequestDTO {

	private Long categoriasId;
	private Long subCategoriasId;
	private Long marcasId;
	private Long modelosId;
	private Long presentacionesId;
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
	public Long getMarcasId() {
		return marcasId;
	}
	public void setMarcasId(Long marcasId) {
		this.marcasId = marcasId;
	}
	public Long getModelosId() {
		return modelosId;
	}
	public void setModelosId(Long modelosId) {
		this.modelosId = modelosId;
	}
	public Long getPresentacionesId() {
		return presentacionesId;
	}
	public void setPresentacionesId(Long presentacionesId) {
		this.presentacionesId = presentacionesId;
	}
	
}
