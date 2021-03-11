package com.adinfi.admaster.domain.bussinnes;

import com.adinfi.admaster.domain.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by jdominguez on 1/15/17.
 */
@Entity
@Table(name = "TipoEventos")
public class TipoEventos {

    @Id
    @Column(name = "TipoEventosId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tipoEventosId;

    @Column(name = "Nombre")
    @NotNull
    @Size(min = 2, max = 50)
    private String nombre;

    @Column(name = "Activo")
    private boolean activo;

    @Column(name = "FechaCreacion")
    private Timestamp fechaCreacion;

    @Column(name = "FechaModificacion")
    private Timestamp fechaModificacion;

    @Column(name = "UsuarioCreadorId")
    private Long usuarioCreadorId;

    @Column(name = "UsuraioModificacionId")
    private Long usuarioModificacionId;

    public TipoEventos() {
    }

    public int getTipoEventosId() {
        return tipoEventosId;
    }

    public void setTipoEventosId(int tipoEventosId) {
        this.tipoEventosId = tipoEventosId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
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

    public Long getUsuarioModificacionId() {
        return usuarioModificacionId;
    }

    public void setUsuarioModificacionId(Long usuarioModificacionId) {
        this.usuarioModificacionId = usuarioModificacionId;
    }
}
