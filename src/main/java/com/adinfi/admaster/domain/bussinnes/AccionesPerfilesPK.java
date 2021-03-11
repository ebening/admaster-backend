package com.adinfi.admaster.domain.bussinnes;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by jdominguez on 1/27/17.
 */
public class AccionesPerfilesPK implements Serializable {
    private int accionesId;
    private int perfilesId;

    @Column(name = "AccionesId", nullable = false)
    @Id
    public int getAccionesId() {
        return accionesId;
    }

    public void setAccionesId(int accionesId) {
        this.accionesId = accionesId;
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
        AccionesPerfilesPK that = (AccionesPerfilesPK) o;
        return accionesId == that.accionesId &&
                perfilesId == that.perfilesId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accionesId, perfilesId);
    }
}
