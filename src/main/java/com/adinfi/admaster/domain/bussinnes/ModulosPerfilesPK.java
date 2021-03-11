package com.adinfi.admaster.domain.bussinnes;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by jdominguez on 1/27/17.
 */
public class ModulosPerfilesPK implements Serializable {
    private int modulosId;
    private int perfilesId;

    @Column(name = "ModulosId", nullable = false)
    @Id
    public int getModulosId() {
        return modulosId;
    }

    public void setModulosId(int modulosId) {
        this.modulosId = modulosId;
    }

    @Column(name = "PerfilesId", nullable = false)
    @Id
    public int getPerfilesId() {
        return perfilesId;
    }

    public void setPerfilesId(int perfilesId) {
        this.perfilesId = perfilesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModulosPerfilesPK that = (ModulosPerfilesPK) o;
        return modulosId == that.modulosId &&
                perfilesId == that.perfilesId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(modulosId, perfilesId);
    }
}
