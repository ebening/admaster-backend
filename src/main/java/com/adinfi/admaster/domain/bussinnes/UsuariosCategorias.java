package com.adinfi.admaster.domain.bussinnes;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by jdominguez on 1/27/17.
 */
@Entity
@IdClass(UsuariosCategoriasPK.class)
public class UsuariosCategorias {
    private long usuariosId;
    private int categoriasId;
    private Boolean dueno;
    private boolean activo;
    private Timestamp fechaCreacion;
    private Timestamp fechaModificacion;
    private Long usuarioCreadorId;
    private Long usuarioModificadorId;
    private Usuarios usuariosByUsuariosId;
    private Categorias categoriasByCategoriasId;

    @Id
    @Column(name = "UsuariosId", nullable = false)
    public long getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(long usuariosId) {
        this.usuariosId = usuariosId;
    }

    @Id
    @Column(name = "CategoriasId", nullable = false)
    public int getCategoriasId() {
        return categoriasId;
    }

    public void setCategoriasId(int categoriasId) {
        this.categoriasId = categoriasId;
    }

    @Basic
    @Column(name = "Dueno", nullable = true)
    public Boolean getDueno() {
        return dueno;
    }

    public void setDueno(Boolean dueno) {
        this.dueno = dueno;
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
        UsuariosCategorias that = (UsuariosCategorias) o;
        return usuariosId == that.usuariosId &&
                categoriasId == that.categoriasId &&
                activo == that.activo &&
                Objects.equals(dueno, that.dueno) &&
                Objects.equals(fechaCreacion, that.fechaCreacion) &&
                Objects.equals(fechaModificacion, that.fechaModificacion) &&
                Objects.equals(usuarioCreadorId, that.usuarioCreadorId) &&
                Objects.equals(usuarioModificadorId, that.usuarioModificadorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuariosId, categoriasId, dueno, activo, fechaCreacion, fechaModificacion, usuarioCreadorId, usuarioModificadorId);
    }

    @ManyToOne
    @JoinColumn(name = "UsuariosId", referencedColumnName = "UsuariosId", nullable = false, insertable = false, updatable = false)
    public Usuarios getUsuariosByUsuariosId() {
        return usuariosByUsuariosId;
    }

    public void setUsuariosByUsuariosId(Usuarios usuariosByUsuariosId) {
        this.usuariosByUsuariosId = usuariosByUsuariosId;
    }

    @ManyToOne
    @JoinColumn(name = "CategoriasId", referencedColumnName = "CategoriasId", nullable = false, insertable = false, updatable = false)
    public Categorias getCategoriasByCategoriasId() {
        return categoriasByCategoriasId;
    }

    public void setCategoriasByCategoriasId(Categorias categoriasByCategoriasId) {
        this.categoriasByCategoriasId = categoriasByCategoriasId;
    }
}
