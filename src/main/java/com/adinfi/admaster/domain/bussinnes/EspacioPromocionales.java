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
@Table(name = "EspacioPromocionales")
public class EspacioPromocionales implements ICatalog{

	@Id
	@Column(name = "EspacioPromocionalesId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long espacioPromocionalesId;

	
	@Column(name = "MediosId")
	@NotNull
	private Long mediosId;

	@Column(name="NumeroParte")
	private Integer numeroParte;
	
	@Column(name="NumeroSeccion")
	private Integer numeroSeccion;

	@Column(name = "CategoriasId")
	@NotNull
	private Long categoriasId;
	
	@Column(name = "SubCategoriasId")
	@NotNull
	private Long subCategoriasId;

	@Column(name="Dueña")
	private Boolean dueña;
	
	@Column(name="Activo")
	private Boolean activo;
	
	@Column(name="FechaCreacion")
	private Timestamp fechaCreacion;
	
	@Column(name="FechaModificacion")
	private Timestamp fechaModificacion;
	
	@Column(name="UsuarioCreadorId")
	private Long usuarioCreadorId;
	
	@Column(name="UsuarioModificadorId")
	private Long usuarioModificadorId;

	public Long getMediosId() {
		return mediosId;
	}

	public void setMediosId(Long mediosId) {
		this.mediosId = mediosId;
	}

	public Integer getNumeroParte() {
		return numeroParte;
	}

	public void setNumeroParte(Integer numeroParte) {
		this.numeroParte = numeroParte;
	}

	public Integer getNumeroSeccion() {
		return numeroSeccion;
	}

	public void setNumeroSeccion(Integer numeroSeccion) {
		this.numeroSeccion = numeroSeccion;
	}

	public Long getSubCategoriasId() {
		return subCategoriasId;
	}

	public void setSubCategoriasId(Long subCategoriasId) {
		this.subCategoriasId = subCategoriasId;
	}

	public Boolean getDueña() {
		return dueña;
	}

	public void setDueña(Boolean dueña) {
		this.dueña = dueña;
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
		return this.getMediosId();
	}

	@Override
	public String getName() {
		return this.mediosId.toString();
	}

	@Override
	public String getText() {
		return this.mediosId.toString();
	}

	public Long getEspacioPromocionalesId() {
		return espacioPromocionalesId;
	}

	public void setEspacioPromocionalesId(Long espacioPromocionalesId) {
		this.espacioPromocionalesId = espacioPromocionalesId;
	}

	public Long getCategoriasId() {
		return categoriasId;
	}

	public void setCategoriasId(Long categoriasId) {
		this.categoriasId = categoriasId;
	}
}

