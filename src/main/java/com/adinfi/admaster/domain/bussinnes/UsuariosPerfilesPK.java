package com.adinfi.admaster.domain.bussinnes;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by jdominguez on 1/27/17.
 */
public class UsuariosPerfilesPK implements Serializable {
    private int perfilesId;
    private long usuariosId;

    @Column(name = "PerfilesId", nullable = false)
    @Id
    public int getPerfilesId() {
        return perfilesId;
    }

    public void setPerfilesId(int perfilesId) {
        this.perfilesId = perfilesId;
    }

    @Column(name = "UsuariosId", nullable = false)
    @Id
    public long getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(long usuariosId) {
        this.usuariosId = usuariosId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuariosPerfilesPK that = (UsuariosPerfilesPK) o;
        return perfilesId == that.perfilesId &&
                usuariosId == that.usuariosId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(perfilesId, usuariosId);
    }
}
