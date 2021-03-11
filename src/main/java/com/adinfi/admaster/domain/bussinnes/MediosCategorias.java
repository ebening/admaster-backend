package com.adinfi.admaster.domain.bussinnes;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.adinfi.admaster.domain.StructureDataDetail;

@Entity
@Table(name = "MediosCategorias")
public class MediosCategorias implements ICatalog{

	@Id
	@Column(name = "MediosId")
	private Long mediosId;
	
	@Column(name = "CategoriasId")
	@NotNull
	private Long categoriasId;
	
	@Column(name = "SubCategoriaId")
	@NotNull
	private Long subCategoriaId;
	
	@Column(name="Pagina")
	@NotNull
	private Integer pagina;
	
	@Column(name="Espacio")
	@NotNull
	private Integer espacio;
	
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

	public Long getCategoriasId() {
		return categoriasId;
	}

	public void setCategoriasId(Long categoriasId) {
		this.categoriasId = categoriasId;
	}

	public Long getSubCategoriaId() {
		return subCategoriaId;
	}

	public void setSubCategoriaId(Long subCategoriaId) {
		this.subCategoriaId = subCategoriaId;
	}

	public Integer getPagina() {
		return pagina;
	}

	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}

	public Integer getEspacio() {
		return espacio;
	}

	public void setEspacio(Integer espacio) {
		this.espacio = espacio;
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
		return this.mediosId;
	}

	@Override
	public String getName() {
		return this.mediosId.toString();
	}

	@Override
	public String getText() {
		return this.mediosId.toString();
	}
}
