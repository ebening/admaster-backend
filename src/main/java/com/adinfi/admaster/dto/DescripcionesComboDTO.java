package com.adinfi.admaster.dto;

import com.adinfi.admaster.domain.bussinnes.ICatalog;

/**
 * Created by jgonzalez
 */

public class DescripcionesComboDTO implements ICatalog {

	private Long descripcionesComboId;
	private String descripcionesCombo;
	
	public DescripcionesComboDTO(){
	}
	
	public DescripcionesComboDTO(Long descripcionesComboId, String descripcionesCombo){
		this.descripcionesComboId = descripcionesComboId;
		this.descripcionesCombo = descripcionesCombo;
	}
	
	public Long getDescripcionesComboId() {
		return descripcionesComboId;
	}
	public void setDescripcionesComboId(Long descripcionesComboId) {
		this.descripcionesComboId = descripcionesComboId;
	}
	public String getDescripcionesCombo() {
		return descripcionesCombo;
	}
	public void setDescripcionesCombo(String descripcionesCombo) {
		this.descripcionesCombo = descripcionesCombo;
	}

	@Override
	public Long getId() {
		return this.getDescripcionesComboId();
	}

	@Override
	public String getName() {
		return this.getDescripcionesCombo();
	}

	@Override
	public String getText() {
		return this.getDescripcionesCombo();
	}
}
