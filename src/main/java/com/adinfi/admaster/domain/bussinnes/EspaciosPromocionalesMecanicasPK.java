package com.adinfi.admaster.domain.bussinnes;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by jdominguez on 2/1/17.
 */
public class EspaciosPromocionalesMecanicasPK implements Serializable {

    private Long mediosId;
    private Long mecanicasId;
    private int numeroParte;
    private int numeroSeccion;
    private int subcategoriasId;

    @Id
    @Column(name = "MediosId")
    public Long getMediosId() {
        return mediosId;
    }

    public void setMediosId(Long mediosId) {
        this.mediosId = mediosId;
    }

    @Id
    @Column(name = "MecanicasId")
    public Long getMecanicasId() {
        return mecanicasId;
    }

    public void setMecanicasId(Long mecanicasId) {
        this.mecanicasId = mecanicasId;
    }

    @Id
    @Column(name = "NumeroParte")
    public int getNumeroParte() {
        return numeroParte;
    }

    public void setNumeroParte(int numeroParte) {
        this.numeroParte = numeroParte;
    }

    @Id
    @Column(name = "NumeroSeccion")
    public int getNumeroSeccion() {
        return numeroSeccion;
    }

    public void setNumeroSeccion(int numeroSeccion) {
        this.numeroSeccion = numeroSeccion;
    }

    @Id
    @Column(name = "SubCategoriasId")
    public int getSubcategoriasId() {
        return subcategoriasId;
    }

    public void setSubcategoriasId(int subcategoriasId) {
        this.subcategoriasId = subcategoriasId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EspaciosPromocionalesMecanicasPK that = (EspaciosPromocionalesMecanicasPK) o;
        return numeroParte == that.numeroParte &&
                numeroSeccion == that.numeroSeccion &&
                subcategoriasId == that.subcategoriasId &&
                Objects.equals(mediosId, that.mediosId) &&
                Objects.equals(mecanicasId, that.mecanicasId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mediosId, mecanicasId, numeroParte, numeroSeccion, subcategoriasId);
    }
}
