package com.adinfi.admaster.domain.bussinnes;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by jdominguez on 1/27/17.
 */
@Entity
@IdClass(ModulosPerfilesPK.class)
public class ModulosPerfiles {
    private int modulosId;
    private int perfilesId;
    private Integer nIvel;
    private Integer diasArobacion;
    private boolean activo;
    private Timestamp fechaCreacion;
    private Timestamp fechaModificacion;
    private Long usuarioCreadorId;
    private Long usuarioModificadorId;
    private Modulos modulosByModulosId;
    private Perfiles perfilesByPerfilesId;

    @Id
    @Column(name = "ModulosId", nullable = false)
    public int getModulosId() {
        return modulosId;
    }

    public void setModulosId(int modulosId) {
        this.modulosId = modulosId;
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
    @Column(name = "NIvel", nullable = true)
    public Integer getnIvel() {
        return nIvel;
    }

    public void setnIvel(Integer nIvel) {
        this.nIvel = nIvel;
    }

    @Basic
    @Column(name = "DiasArobacion", nullable = true)
    public Integer getDiasArobacion() {
        return diasArobacion;
    }

    public void setDiasArobacion(Integer diasArobacion) {
        this.diasArobacion = diasArobacion;
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
        ModulosPerfiles that = (ModulosPerfiles) o;
        return modulosId == that.modulosId &&
                perfilesId == that.perfilesId &&
                activo == that.activo &&
                Objects.equals(nIvel, that.nIvel) &&
                Objects.equals(diasArobacion, that.diasArobacion) &&
                Objects.equals(fechaCreacion, that.fechaCreacion) &&
                Objects.equals(fechaModificacion, that.fechaModificacion) &&
                Objects.equals(usuarioCreadorId, that.usuarioCreadorId) &&
                Objects.equals(usuarioModificadorId, that.usuarioModificadorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modulosId, perfilesId, nIvel, diasArobacion, activo, fechaCreacion, fechaModificacion, usuarioCreadorId, usuarioModificadorId);
    }

    @ManyToOne
    @JoinColumn(name = "ModulosId", referencedColumnName = "ModulosID", nullable = false, insertable = false, updatable = false)
    public Modulos getModulosByModulosId() {
        return modulosByModulosId;
    }

    public void setModulosByModulosId(Modulos modulosByModulosId) {
        this.modulosByModulosId = modulosByModulosId;
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
