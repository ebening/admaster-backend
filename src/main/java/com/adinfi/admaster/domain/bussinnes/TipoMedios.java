package com.adinfi.admaster.domain.bussinnes;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TipoMedios")
public class TipoMedios implements ICatalog{

	@Id
	@Column(name = "TipoMediosId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long tipoMediosId;

	@Column(name = "Nombre", length = 50)
	@NotNull
	@Size(min = 4, max = 50)
	private String nombre;
	
	@Column(name="DimensionAncho")
	private Float dimensionAncho;
	
	@Column(name="DimensionAlto")
	private Float dimensionAlto;
	
	@Column(name="DimensionProfundo")
	private Float dimensionProfundo;
	
	@Column(name="Color")
	private Integer color;
	
	@Column(name="Impreso")
	private Boolean impreso;
	
	@Column(name="Imagenes")
	private Boolean imagenes;
	
	@Column(name="RequiereEspacioEnPortada")
	private Boolean requiereEspacioEnPortada;
	
	@Column(name="PaginasMinimasConEspacio")
	private Integer paginasMinimasConEspacio;
	
	@Column(name="RequiereOrdenEnEspaciosPorPagina")
	private Boolean requiereOrdenEnEspaciosPorPagina;
	
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
	
	
	@Column(name="numeroPaginas")
	private Integer numeroPaginas;
	
	@Column(name="maximoDeEspacios")
	private Integer maximoDeEspacios;
	
	@Column(name="aplicaPortadaYContraportada")
	private Boolean aplicaPortadaYContraportada;

	public Long getTipoMediosId() {
		return tipoMediosId;
	}

	public void setTipoMediosId(Long tipoMediosId) {
		this.tipoMediosId = tipoMediosId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getDimensionAncho() {
		return dimensionAncho;
	}

	public void setDimensionAncho(Float dimensionAncho) {
		this.dimensionAncho = dimensionAncho;
	}

	public Float getDimensionAlto() {
		return dimensionAlto;
	}

	public void setDimensionAlto(Float dimensionAlto) {
		this.dimensionAlto = dimensionAlto;
	}

	public Float getDimensionProfundo() {
		return dimensionProfundo;
	}

	public void setDimensionProfundo(Float dimensionProfundo) {
		this.dimensionProfundo = dimensionProfundo;
	}

	public Integer getColor() {
		return color;
	}

	public void setColor(Integer color) {
		this.color = color;
	}

	public Boolean getImpreso() {
		return impreso;
	}

	public void setImpreso(Boolean impreso) {
		this.impreso = impreso;
	}

	public Boolean getImagenes() {
		return imagenes;
	}

	public void setImagenes(Boolean imagenes) {
		this.imagenes = imagenes;
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
	
	public Long getId(){
		return this.getTipoMediosId();
	}
	
	public String getName(){
		return this.getNombre();
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public Integer getMaximoDeEspacios() {
		return maximoDeEspacios;
	}

	public void setMaximoDeEspacios(Integer maximoDeEspacios) {
		this.maximoDeEspacios = maximoDeEspacios;
	}

	public Boolean getAplicaPortadaYContraportada() {
		return aplicaPortadaYContraportada;
	}

	public void setAplicaPortadaYContraportada(Boolean aplicaPortadaYContraportada) {
		this.aplicaPortadaYContraportada = aplicaPortadaYContraportada;
	}

	@Override
	public String getText() {
		return this.getName();
	}

	public Boolean getRequiereEspacioEnPortada() {
		return requiereEspacioEnPortada;
	}

	public void setRequiereEspacioEnPortada(Boolean requiereEspacioEnPortada) {
		this.requiereEspacioEnPortada = requiereEspacioEnPortada;
	}

	public Integer getPaginasMinimasConEspacio() {
		return paginasMinimasConEspacio;
	}

	public void setPaginasMinimasConEspacio(Integer paginasMinimasConEspacio) {
		this.paginasMinimasConEspacio = paginasMinimasConEspacio;
	}

	public Boolean getRequiereOrdenEnEspaciosPorPagina() {
		return requiereOrdenEnEspaciosPorPagina;
	}

	public void setRequiereOrdenEnEspaciosPorPagina(Boolean requiereOrdenEnEspaciosPorPagina) {
		this.requiereOrdenEnEspaciosPorPagina = requiereOrdenEnEspaciosPorPagina;
	}
	

}
