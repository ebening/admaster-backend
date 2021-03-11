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
public class TiposAccesos {
    private short tiposAccesosId;
    private String nombre;
    private Boolean activo;
    private Timestamp fechaCreacion;
    private Timestamp fechaModificacion;
    private Long usuarioCreadorId;
    private Long usuarioModificadorId;

    @Id
    @Column(name = "TiposAccesosId", nullable = false)
    public short getTiposAccesosId() {
        return tiposAccesosId;
    }

    public void setTiposAccesosId(short tiposAccesosId) {
        this.tiposAccesosId = tiposAccesosId;
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
        TiposAccesos that = (TiposAccesos) o;
        return tiposAccesosId == that.tiposAccesosId &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(activo, that.activo) &&
                Objects.equals(fechaCreacion, that.fechaCreacion) &&
                Objects.equals(fechaModificacion, that.fechaModificacion) &&
                Objects.equals(usuarioCreadorId, that.usuarioCreadorId) &&
                Objects.equals(usuarioModificadorId, that.usuarioModificadorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tiposAccesosId, nombre, activo, fechaCreacion, fechaModificacion, usuarioCreadorId, usuarioModificadorId);
    }
}
