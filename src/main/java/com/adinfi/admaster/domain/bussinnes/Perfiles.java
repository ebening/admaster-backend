package com.adinfi.admaster.domain.bussinnes;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

/**
 * Created by jdominguez on 1/27/17.
 */
@Entity
public class Perfiles {
    private int perfilesId;
    private String nombre;
    private boolean activo;
    private Timestamp fechaCreacion;
    private Timestamp fechaModificacion;
    private Long usuarioCreadorId;
    private Long usuarioModificadorId;
    private Collection<AccionesPerfiles> accionesPerfilesByPerfilesId;
    private Collection<ModulosPerfiles> modulosPerfilesByPerfilesId;
    private Collection<UsuariosPerfiles> usuariosPerfilesByPerfilesId;

    @Id
    @Column(name = "PerfilesId", nullable = false)
    public int getPerfilesId() {
        return perfilesId;
    }

    public void setPerfilesId(int perfilesId) {
        this.perfilesId = perfilesId;
    }

    @Basic
    @Column(name = "Nombre", nullable = true, length = 50)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        Perfiles perfiles = (Perfiles) o;
        return perfilesId == perfiles.perfilesId &&
                activo == perfiles.activo &&
                Objects.equals(nombre, perfiles.nombre) &&
                Objects.equals(fechaCreacion, perfiles.fechaCreacion) &&
                Objects.equals(fechaModificacion, perfiles.fechaModificacion) &&
                Objects.equals(usuarioCreadorId, perfiles.usuarioCreadorId) &&
                Objects.equals(usuarioModificadorId, perfiles.usuarioModificadorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(perfilesId, nombre, activo, fechaCreacion, fechaModificacion, usuarioCreadorId, usuarioModificadorId);
    }

    @OneToMany(mappedBy = "perfilesByPerfilesId")
    public Collection<AccionesPerfiles> getAccionesPerfilesByPerfilesId() {
        return accionesPerfilesByPerfilesId;
    }

    public void setAccionesPerfilesByPerfilesId(Collection<AccionesPerfiles> accionesPerfilesByPerfilesId) {
        this.accionesPerfilesByPerfilesId = accionesPerfilesByPerfilesId;
    }

    @OneToMany(mappedBy = "perfilesByPerfilesId")
    public Collection<ModulosPerfiles> getModulosPerfilesByPerfilesId() {
        return modulosPerfilesByPerfilesId;
    }

    public void setModulosPerfilesByPerfilesId(Collection<ModulosPerfiles> modulosPerfilesByPerfilesId) {
        this.modulosPerfilesByPerfilesId = modulosPerfilesByPerfilesId;
    }

    @OneToMany(mappedBy = "perfilesByPerfilesId")
    public Collection<UsuariosPerfiles> getUsuariosPerfilesByPerfilesId() {
        return usuariosPerfilesByPerfilesId;
    }

    public void setUsuariosPerfilesByPerfilesId(Collection<UsuariosPerfiles> usuariosPerfilesByPerfilesId) {
        this.usuariosPerfilesByPerfilesId = usuariosPerfilesByPerfilesId;
    }
}
