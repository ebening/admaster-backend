package com.adinfi.admaster.domain.bussinnes;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by jdominguez on 2/11/17.
 */
@Entity
@Table(name = "EspaciosUbicaciones")
public class EspaciosUbicaciones {

    @Id
    @Column(name = "EspaciosUbicacionesId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int espaciosUbicacionesId;

    @Basic
    @Column(name = "Nombre", length = 50)
    @NotNull
    private String nombre;

    @Basic
    @Column(name = "Activo")
    private boolean activo;

    @Basic
    @Column(name = "FechaCreacion")
    private Date fechaCreacion;

    @Basic
    @Column(name = "FechaModificacion")
    private Date fechaModificacion;

    @Basic
    @Column(name = "UsuarioCreadorId")
    private Long usuarioCreadorId;

    @Basic
    @Column(name = "UsuarioModificadorId")
    private Long usuarioModificadorId;

    public int getEspaciosUbicacionesId() {
        return espaciosUbicacionesId;
    }

    public void setEspaciosUbicacionesId(int espaciosUbicacionesId) {
        this.espaciosUbicacionesId = espaciosUbicacionesId;
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Long getUsuarioCreadorId() {
        return usuarioCreadorId;
    }

    public void setUsuarioCreadorId(Long usuarioCreadorId) {
        this.usuarioCreadorId = usuarioCreadorId;
    }

    public Long getUsuarioModificadorId() {
        return usuarioModificadorId;
    }

    public void setUsuarioModificadorId(Long usuarioModificadorId) {
        this.usuarioModificadorId = usuarioModificadorId;
    }
}
