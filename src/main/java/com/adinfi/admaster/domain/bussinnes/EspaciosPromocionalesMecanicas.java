package com.adinfi.admaster.domain.bussinnes;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by jdominguez on 2/1/17.
 */
@Entity
@IdClass(EspaciosPromocionalesMecanicasPK.class)
public class EspaciosPromocionalesMecanicas implements Serializable {

    private Long mediosId;
    private Long mecanicasId;
    private int numeroParte;
    private int numeroSeccion;
    private int subcategoriasId;
    private double precioOferta;
    private String porcentajeOferta;
    private Long vigenciasId;
    private int orden;
    private String urlDiseño;
    private boolean activo;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long usuarioCreadorId;
    private Long usuarioModificadorId;
    private Long usuariosCompradorId;

    @Id
    @Column(name = "MediosId")
    public Long getMediosId() {
        return mediosId;
    }

    public void setMediosId(Long mediosId) {
        this.mediosId = mediosId;
    }

    @Id
    @Column(name = "MecanicasId")
    public Long getMecanicasId() {
        return mecanicasId;
    }

    public void setMecanicasId(Long mecanicasId) {
        this.mecanicasId = mecanicasId;
    }

    @Id
    @Column(name = "NumeroParte")
    public int getNumeroParte() {
        return numeroParte;
    }

    public void setNumeroParte(int numeroParte) {
        this.numeroParte = numeroParte;
    }

    @Id
    @Column(name = "NumeroSeccion")
    public int getNumeroSeccion() {
        return numeroSeccion;
    }

    public void setNumeroSeccion(int numeroSeccion) {
        this.numeroSeccion = numeroSeccion;
    }

    @Id
    @Column(name = "SubCategoriasId")
    public int getSubcategoriasId() {
        return subcategoriasId;
    }

    public void setSubcategoriasId(int subcategoriasId) {
        this.subcategoriasId = subcategoriasId;
    }

    @Basic
    @Column(name = "PrecioOferta")
    public double getPrecioOferta() {
        return precioOferta;
    }

    public void setPrecioOferta(double precioOferta) {
        this.precioOferta = precioOferta;
    }

    @Basic
    @Column(name = "PorcentajeOferta")
    public String getPorcentajeOferta() {
        return porcentajeOferta;
    }

    public void setPorcentajeOferta(String porcentajeOferta) {
        this.porcentajeOferta = porcentajeOferta;
    }

    @Basic
    @Column(name = "VigenciasId")
    public Long getVigenciasId() {
        return vigenciasId;
    }

    public void setVigenciasId(Long vigenciasId) {
        this.vigenciasId = vigenciasId;
    }

    @Basic
    @Column(name = "Orden")
    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    @Basic
    @Column(name = "URLDiseño")
    public String getUrlDiseño() {
        return urlDiseño;
    }

    public void setUrlDiseño(String urlDiseño) {
        this.urlDiseño = urlDiseño;
    }

    @Basic
    @Column(name = "Activo")
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Basic
    @Column(name = "FechaCreacion")
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Basic
    @Column(name = "FechaModificacion")
    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Basic
    @Column(name = "UsuarioCreadorId")
    public Long getUsuarioCreadorId() {
        return usuarioCreadorId;
    }

    public void setUsuarioCreadorId(Long usuarioCreadorId) {
        this.usuarioCreadorId = usuarioCreadorId;
    }

    @Basic
    @Column(name = "UsuarioModificadorId")
    public Long getUsuarioModificadorId() {
        return usuarioModificadorId;
    }

    public void setUsuarioModificadorId(Long usuarioModificadorId) {
        this.usuarioModificadorId = usuarioModificadorId;
    }

    @Basic
    @Column(name = "UsuariosCompradorId")
    public Long getUsuariosCompradorId() {
        return usuariosCompradorId;
    }

    public void setUsuariosCompradorId(Long usuariosCompradorId) {
        this.usuariosCompradorId = usuariosCompradorId;
    }
}
