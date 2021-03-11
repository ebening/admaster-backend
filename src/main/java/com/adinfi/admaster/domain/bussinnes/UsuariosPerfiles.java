package com.adinfi.admaster.domain.bussinnes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by jdominguez on 1/27/17.
 */
@Entity
@IdClass(UsuariosPerfilesPK.class)
public class UsuariosPerfiles {
    private int perfilesId;
    private long usuariosId;
    private Boolean aprobatorio;
    private Boolean activo;
    private Timestamp fechaCreacion;
    private Timestamp fechaModificacion;
    private Long usuarioCreadorId;
    private Long usuarioModificadorId;

    @JsonIgnore
    private Perfiles perfilesByPerfilesId;

    @JsonIgnore
    private Usuarios usuariosByUsuariosId;

    @Id
    @Column(name = "PerfilesId", nullable = false)
    public int getPerfilesId() {
        return perfilesId;
    }

    public void setPerfilesId(int perfilesId) {
        this.perfilesId = perfilesId;
    }

    @Id
    @Column(name = "UsuariosId", nullable = false)
    public long getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(long usuariosId) {
        this.usuariosId = usuariosId;
    }

    @Basic
    @Column(name = "Aprobatorio", nullable = true)
    public Boolean getAprobatorio() {
        return aprobatorio;
    }

    public void setAprobatorio(Boolean aprobatorio) {
        this.aprobatorio = aprobatorio;
    }

    @Basic
    @Column(name = "Activo", nullable = true)
    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
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
        UsuariosPerfiles that = (UsuariosPerfiles) o;
        return perfilesId == that.perfilesId &&
                usuariosId == that.usuariosId &&
                Objects.equals(aprobatorio, that.aprobatorio) &&
                Objects.equals(activo, that.activo) &&
                Objects.equals(fechaCreacion, that.fechaCreacion) &&
                Objects.equals(fechaModificacion, that.fechaModificacion) &&
                Objects.equals(usuarioCreadorId, that.usuarioCreadorId) &&
                Objects.equals(usuarioModificadorId, that.usuarioModificadorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(perfilesId, usuariosId, aprobatorio, activo, fechaCreacion, fechaModificacion, usuarioCreadorId, usuarioModificadorId);
    }

    @ManyToOne
    @JoinColumn(name = "PerfilesId", referencedColumnName = "PerfilesId", nullable = false, insertable = false, updatable = false)
    public Perfiles getPerfilesByPerfilesId() {
        return perfilesByPerfilesId;
    }

    public void setPerfilesByPerfilesId(Perfiles perfilesByPerfilesId) {
        this.perfilesByPerfilesId = perfilesByPerfilesId;
    }

    @ManyToOne
    @JoinColumn(name = "UsuariosId", referencedColumnName = "UsuariosId", nullable = false, insertable = false, updatable = false)
    public Usuarios getUsuariosByUsuariosId() {
        return usuariosByUsuariosId;
    }

    public void setUsuariosByUsuariosId(Usuarios usuariosByUsuariosId) {
        this.usuariosByUsuariosId = usuariosByUsuariosId;
    }
}
