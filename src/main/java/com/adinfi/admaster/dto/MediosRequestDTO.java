package com.adinfi.admaster.dto;

import java.util.Date;
import java.util.List;

public class MediosRequestDTO {

	private Long tipoMediosId;
	private String tipoMediosStr;
	private Long zonasId;
	private String zonasStr;
	private Date fechaInicial;
	private Date fechaFinal;
	private Long fechaInicialTime;
	private Long fechaFinalTime;
	private Long eventosId;
	private String description;
	
	private List<EspaciosRequestDTO> espacios;
	
	public Long getTipoMediosId() {
		return tipoMediosId;
	}
	public void setTipoMediosId(Long tipoMediosId) {
		this.tipoMediosId = tipoMediosId;
	}
	public Long getZonasId() {
		return zonasId;
	}
	public void setZonasId(Long zonasId) {
		this.zonasId = zonasId;
	}
	public Date getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public Long getFechaInicialTime() {
		return fechaInicialTime;
	}
	public void setFechaInicialTime(Long fechaInicialTime) {
		this.fechaInicialTime = fechaInicialTime;
	}
	public Long getFechaFinalTime() {
		return fechaFinalTime;
	}
	public void setFechaFinalTime(Long fechaFinalTime) {
		this.fechaFinalTime = fechaFinalTime;
	}
	public Long getEventosId() {
		return eventosId;
	}
	public void setEventosId(Long eventosId) {
		this.eventosId = eventosId;
	}
	public String getZonasStr() {
		return zonasStr;
	}
	public void setZonasStr(String zonasStr) {
		this.zonasStr = zonasStr;
	}
	public String getTipoMediosStr() {
		return tipoMediosStr;
	}
	public void setTipoMediosStr(String tipoMediosStr) {
		this.tipoMediosStr = tipoMediosStr;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<EspaciosRequestDTO> getEspacios() {
		return espacios;
	}
	public void setEspacios(List<EspaciosRequestDTO> espacios) {
		this.espacios = espacios;
	}
}
