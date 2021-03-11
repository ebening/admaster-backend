package com.adinfi.admaster.domain.sp;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jdominguez on 2/10/17.
 */
public class EspaciosMecanicas implements Serializable {

    private Long eventoId;
    private Long medioId;
    private Long subCategoriaId;
    private List<Long> mecanicaId;

    public Long getEventoId() {
        return eventoId;
    }

    public void setEventoId(Long eventoId) {
        this.eventoId = eventoId;
    }

    public Long getMedioId() {
        return medioId;
    }

    public void setMedioId(Long medioId) {
        this.medioId = medioId;
    }

    public Long getSubCategoriaId() {
        return subCategoriaId;
    }

    public void setSubCategoriaId(Long subCategoriaId) {
        this.subCategoriaId = subCategoriaId;
    }

    public List<Long> getMecanicaId() {
        return mecanicaId;
    }

    public void setMecanicaId(List<Long> mecanicaId) {
        this.mecanicaId = mecanicaId;
    }
}
