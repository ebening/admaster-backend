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
public class Modulos {
    private int modulosId;
    private Integer modulosPadreId;
    private String nombre;
    private boolean activo;
    private Timestamp fechaCreacion;
    private Timestamp fechaModificacion;
    private Long usuarioCreadorOid;
    private Long usuarioModificador;

    @Id
    @Column(name = "ModulosID", nullable = false)
    public int getModulosId() {
        return modulosId;
    }

    public void setModulosId(int modulosId) {
        this.modulosId = modulosId;
    }

    @Basic
    @Column(name = "ModulosPadreId", nullable = true)
    public Integer getModulosPadreId() {
        return modulosPadreId;
    }

    public void setModulosPadreId(Integer modulosPadreId) {
        this.modulosPadreId = modulosPadreId;
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
    @Column(name = "UsuarioCreadorOID", nullable = true)
    public Long getUsuarioCreadorOid() {
        return usuarioCreadorOid;
    }

    public void setUsuarioCreadorOid(Long usuarioCreadorOid) {
        this.usuarioCreadorOid = usuarioCreadorOid;
    }

    @Basic
    @Column(name = "UsuarioModificador", nullable = true)
    public Long getUsuarioModificador() {
        return usuarioModificador;
    }

    public void setUsuarioModificador(Long usuarioModificador) {
        this.usuarioModificador = usuarioModificador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modulos modulos = (Modulos) o;
        return modulosId == modulos.modulosId &&
                activo == modulos.activo &&
                Objects.equals(modulosPadreId, modulos.modulosPadreId) &&
                Objects.equals(nombre, modulos.nombre) &&
                Objects.equals(fechaCreacion, modulos.fechaCreacion) &&
                Objects.equals(fechaModificacion, modulos.fechaModificacion) &&
                Objects.equals(usuarioCreadorOid, modulos.usuarioCreadorOid) &&
                Objects.equals(usuarioModificador, modulos.usuarioModificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modulosId, modulosPadreId, nombre, activo, fechaCreacion, fechaModificacion, usuarioCreadorOid, usuarioModificador);
    }
}
