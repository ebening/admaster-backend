package com.adinfi.admaster.domain.bussinnes;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by jdominguez on 1/27/17.
 */
@Entity
public class Acciones {
    private int accionesId;
    private String nombre;
    private String descripcion;
    private boolean activo;
    private Timestamp fechaCreacion;
    private Timestamp fechaModificacion;
    private Long usuarioCreadorId;
    private Long usuarioModificadorId;

    @Id
    @Column(name = "AccionesId", nullable = false)
    public int getAccionesId() {
        return accionesId;
    }

    public void setAccionesId(int accionesId) {
        this.accionesId = accionesId;
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
    @Column(name = "Descripcion", nullable = true, length = 200)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        Acciones acciones = (Acciones) o;
        return accionesId == acciones.accionesId &&
                activo == acciones.activo &&
                Objects.equals(nombre, acciones.nombre) &&
                Objects.equals(descripcion, acciones.descripcion) &&
                Objects.equals(fechaCreacion, acciones.fechaCreacion) &&
                Objects.equals(fechaModificacion, acciones.fechaModificacion) &&
                Objects.equals(usuarioCreadorId, acciones.usuarioCreadorId) &&
                Objects.equals(usuarioModificadorId, acciones.usuarioModificadorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accionesId, nombre, descripcion, activo, fechaCreacion, fechaModificacion, usuarioCreadorId, usuarioModificadorId);
    }
}
