package com.adinfi.admaster.domain.bussinnes;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by jdominguez on 2/3/17.
 */
public class EspaciosMecanicasPK implements Serializable {

    private Long mecanicasId;
    private Long subCategoriasId;
    private Long mediosId;

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
}
