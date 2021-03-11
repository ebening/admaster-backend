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
public class Parametros {
    private short parametrosId;
    private String nombre;
    private String titulo;
    private String valor;
    private String tipoDato;
    private Boolean editable;
    private Boolean activo;
    private Timestamp fechaCreacion;
    private Timestamp fechaModificacion;
    private Long usuarioCreadorId;
    private Long usuarioModificadorId;

    @Id
    @Column(name = "ParametrosId", nullable = false)
    public short getParametrosId() {
        return parametrosId;
    }

    public void setParametrosId(short parametrosId) {
        this.parametrosId = parametrosId;
    }

    @Basic
    @Column(name = "Nombre", nullable = true, length = 500)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "Titulo", nullable = true, length = 100)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Basic
    @Column(name = "Valor", nullable = true, length = 500)
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Basic
    @Column(name = "TipoDato", nullable = true, length = 20)
    public String getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(String tipoDato) {
        this.tipoDato = tipoDato;
    }

    @Basic
    @Column(name = "Editable", nullable = true)
    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
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
        Parametros that = (Parametros) o;
        return parametrosId == that.parametrosId &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(titulo, that.titulo) &&
                Objects.equals(valor, that.valor) &&
                Objects.equals(tipoDato, that.tipoDato) &&
                Objects.equals(editable, that.editable) &&
                Objects.equals(activo, that.activo) &&
                Objects.equals(fechaCreacion, that.fechaCreacion) &&
                Objects.equals(fechaModificacion, that.fechaModificacion) &&
                Objects.equals(usuarioCreadorId, that.usuarioCreadorId) &&
                Objects.equals(usuarioModificadorId, that.usuarioModificadorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parametrosId, nombre, titulo, valor, tipoDato, editable, activo, fechaCreacion, fechaModificacion, usuarioCreadorId, usuarioModificadorId);
    }
}
