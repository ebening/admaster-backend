package com.adinfi.admaster.domain.bussinnes;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jdominguez on 2/3/17.
 */
@Entity
@IdClass(EspaciosMecanicasPK.class)
public class EspaciosMecanicas implements Serializable {

    private Long mecanicasId;
    private Long subCategoriasId;
    private Long mediosId;
    private boolean seleccionado;

    @Id
    @Column(name = "MecanicasId")
    public Long getMecanicasId() {
        return mecanicasId;
    }

    public void setMecanicasId(Long mecanicasId) {
        this.mecanicasId = mecanicasId;
    }

    @Id
    @Column(name = "SubCategoriasId")
    public Long getSubCategoriasId() {
        return subCategoriasId;
    }

    public void setSubCategoriasId(Long subCategoriasId) {
        this.subCategoriasId = subCategoriasId;
    }

    @Id
    @Column(name = "MediosId")
    public Long getMediosId() {
        return mediosId;
    }

    public void setMediosId(Long mediosId) {
        this.mediosId = mediosId;
    }

    @Basic
    @Column(name = "Seleccionado")
    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
}
