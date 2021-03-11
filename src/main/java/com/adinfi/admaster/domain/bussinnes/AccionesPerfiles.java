package com.adinfi.admaster.domain.bussinnes;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by jdominguez on 1/27/17.
 */
@Entity
@IdClass(AccionesPerfilesPK.class)
public class AccionesPerfiles {
    private int accionesId;
    private int perfilesId;
    private boolean activo;
    private Timestamp fechaCreacion;
    private Timestamp fechaModificacion;
    private Long usuarioCreadorId;
    private Long usuarioModificadorId;
    private Acciones accionesByAccionesId;
    private Perfiles perfilesByPerfilesId;

    @Id
    @Column(name = "AccionesId", nullable = false)
    public int getAccionesId() {
        return accionesId;
    }

    public void setAccionesId(int accionesId) {
        this.accionesId = accionesId;
    }

    @Id
    @Column(name = "PerfilesId", nullable = false)
    public int getPerfilesId() {
        return perfilesId;
    }

    public void setPerfilesId(int perfilesId) {
        this.perfilesId = perfilesId;
    }

    @Basic
    @Column(name = "Activo", nullable = false)
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Basic
    @Column(name = "FechaCreacion", nullable = true)
    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Basic
    @Column(name = "FechaModificacion", nullable = true)
    public Timestamp getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Timestamp fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Basic
    @Column(name = "UsuarioCreadorId", nullable = true)
    public Long getUsuarioCreadorId() {
        return usuarioCreadorId;
    }

    public void setUsuarioCreadorId(Long usuarioCreadorId) {
        this.usuarioCreadorId = usuarioCreadorId;
    }

    @Basic
    @Column(name = "UsuarioModificadorId", nullable = true)
    public Long getUsuarioModificadorId() {
        return usuarioModificadorId;
    }

    public void setUsuarioModificadorId(Long usuarioModificadorId) {
        this.usuarioModificadorId = usuarioModificadorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccionesPerfiles that = (AccionesPerfiles) o;
        return accionesId == that.accionesId &&
                perfilesId == that.perfilesId &&
                activo == that.activo &&
                Objects.equals(fechaCreacion, that.fechaCreacion) &&
                Objects.equals(fechaModificacion, that.fechaModificacion) &&
                Objects.equals(usuarioCreadorId, that.usuarioCreadorId) &&
                Objects.equals(usuarioModificadorId, that.usuarioModificadorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accionesId, perfilesId, activo, fechaCreacion, fechaModificacion, usuarioCreadorId, usuarioModificadorId);
    }

    @ManyToOne
    @JoinColumn(name = "AccionesId", referencedColumnName = "AccionesId", nullable = false, insertable = false, updatable = false)
    public Acciones getAccionesByAccionesId() {
        return accionesByAccionesId;
    }

    public void setAccionesByAccionesId(Acciones accionesByAccionesId) {
        this.accionesByAccionesId = accionesByAccionesId;
    }

    @ManyToOne
    @JoinColumn(name = "PerfilesId", referencedColumnName = "PerfilesId", nullable = false, insertable = false, updatable = false)
    public Perfiles getPerfilesByPerfilesId() {
        return perfilesByPerfilesId;
    }

    public void setPerfilesByPerfilesId(Perfiles perfilesByPerfilesId) {
        this.perfilesByPerfilesId = perfilesByPerfilesId;
    }
}
