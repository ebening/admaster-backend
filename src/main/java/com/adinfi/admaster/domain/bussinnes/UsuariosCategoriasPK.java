package com.adinfi.admaster.domain.bussinnes;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by jdominguez on 1/27/17.
 */
public class UsuariosCategoriasPK implements Serializable {
    private long usuariosId;
    private int categoriasId;

    @Column(name = "UsuariosId", nullable = false)
    @Id
    public long getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(long usuariosId) {
        this.usuariosId = usuariosId;
    }

    @Column(name = "CategoriasId", nullable = false)
    @Id
    public int getCategoriasId() {
        return categoriasId;
    }

    public void setCategoriasId(int categoriasId) {
        this.categoriasId = categoriasId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuariosCategoriasPK that = (UsuariosCategoriasPK) o;
        return usuariosId == that.usuariosId &&
                categoriasId == that.categoriasId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuariosId, categoriasId);
    }
}
