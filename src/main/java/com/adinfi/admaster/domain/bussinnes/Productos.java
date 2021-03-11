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
@Table(name = "Productos")
public class Productos implements ICatalog{

	@Id
	@Column(name = "ProductosId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long productosId;

	@Column(name = "UPCs", length = 50)
	@Size(min = 2, max = 50)
	private String upcs;
	
	@Column(name = "Nombre", length = 50)
	@Size(min = 2, max = 50)
	private String nombre;
	
	@Column(name = "Precio")
	private Double precio;
	
	@Column(name = "SubCategoriaId")
	private Long subCategoriaId;
	
	@Column(name = "MarcasId")
	private Long marcasId;
	
	@Column(name = "PresentacionesId")
	private Long presentacionesId;
	
	@Column(name = "ModelosId")
	private Long modelosId;
	
	@Column(name = "Activo")
	private Boolean activo;
	
	@Column(name = "Vigencia")
	private Boolean vigencia;
	
	@Column(name="FechaCreacion")
	private Timestamp fechaCreacion;
	
	@Column(name="FechaModificacion")
	private Timestamp fechaModificacion;
	
	@Column(name="UsuarioCreadorId")
	private Long usuarioCreadorId;
	
	@Column(name="UsuarioModificadorId")
	private Long usuarioModificadorId;
	
	@Column(name = "Tag1")
	private String tag1;
	
	@Column(name = "Tag2")
	private String tag2;
	
	@Column(name = "Tag3")
	private String tag3;
	
	@Column(name = "Tag4")
	private String tag4;
	
	@Column(name = "Tag5")
	private String tag5;

	@Column(name = "CostoImpuesto")
	private Double costoImpuesto;

	public Long getProductosId() {
		return productosId;
	}

	public void setProductosId(Long productosId) {
		this.productosId = productosId;
	}

	public String getUpcs() {
		return upcs;
	}

	public void setUpcs(String upcs) {
		this.upcs = upcs;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Long getSubCategoriaId() {
		return subCategoriaId;
	}

	public void setSubCategoriaId(Long subCategoriaId) {
		this.subCategoriaId = subCategoriaId;
	}

	public Long getMarcasId() {
		return marcasId;
	}

	public void setMarcasId(Long marcasId) {
		this.marcasId = marcasId;
	}

	public Long getPresentacionesId() {
		return presentacionesId;
	}

	public void setPresentacionesId(Long presentacionesId) {
		this.presentacionesId = presentacionesId;
	}

	public Long getModelosId() {
		return modelosId;
	}

	public void setModelosId(Long modelosId) {
		this.modelosId = modelosId;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Boolean getVigencia() {
		return vigencia;
	}

	public void setVigencia(Boolean vigencia) {
		this.vigencia = vigencia;
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

	public String getTag1() {
		return tag1;
	}

	public void setTag1(String tag1) {
		this.tag1 = tag1;
	}

	public String getTag2() {
		return tag2;
	}

	public void setTag2(String tag2) {
		this.tag2 = tag2;
	}

	public String getTag3() {
		return tag3;
	}

	public void setTag3(String tag3) {
		this.tag3 = tag3;
	}

	public String getTag4() {
		return tag4;
	}

	public void setTag4(String tag4) {
		this.tag4 = tag4;
	}

	public String getTag5() {
		return tag5;
	}

	public void setTag5(String tag5) {
		this.tag5 = tag5;
	}

	public Double getCostoImpuesto() {
		return costoImpuesto;
	}

	public void setCostoImpuesto(Double costoImpuesto) {
		this.costoImpuesto = costoImpuesto;
	}

	@Override
	public Long getId() {
		return this.getProductosId();
	}

	@Override
	public String getName() {
		return this.getNombre();
	}

	@Override
	public String getText() {
		return this.getNombre();
	}
}
