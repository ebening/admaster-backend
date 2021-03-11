package com.adinfi.admaster.dto;

import com.adinfi.admaster.domain.bussinnes.ICatalog;

/**
 * Created by jgonzalez
 */

public class DescripcionesPromocionDTO implements ICatalog {

	private Long descripcionesPromocionId;
	private String descripcionesPromocion;
	
	public DescripcionesPromocionDTO(){
	}
	
	public DescripcionesPromocionDTO(Long descripcionesPromocionId, String descripcionesPromocion){
		this.descripcionesPromocionId = descripcionesPromocionId;
		this.descripcionesPromocion = descripcionesPromocion;
	}

	public Long getDescripcionesPromocionId() {
		return descripcionesPromocionId;
	}

	public void setDescripcionesPromocionId(Long descripcionesPromocionId) {
		this.descripcionesPromocionId = descripcionesPromocionId;
	}

	public String getDescripcionesPromocion() {
		return descripcionesPromocion;
	}

	public void setDescripcionesPromocion(String descripcionesPromocion) {
		this.descripcionesPromocion = descripcionesPromocion;
	}

	@Override
	public Long getId() {
		return this.descripcionesPromocionId;
	}

	@Override
	public String getName() {
		return this.descripcionesPromocion;
	}

	@Override
	public String getText() {
		return this.descripcionesPromocion;
	}
}
