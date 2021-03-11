package com.adinfi.admaster.domain;

import com.adinfi.admaster.domain.bussinnes.Eventos;

/**
 * Created by jdominguez on 1/15/17.
 */
public class AddEventoModel {

    private StructureData structureData;
    private Eventos eventos;

    public AddEventoModel() {
    }

    public AddEventoModel(StructureData structureData, Eventos eventos) {
        this.structureData = structureData;
        this.eventos = eventos;
    }

    public StructureData getStructureData() {
        return structureData;
    }

    public void setStructureData(StructureData structureData) {
        this.structureData = structureData;
    }

    public Eventos getEventos() {
        return eventos;
    }

    public void setEventos(Eventos eventos) {
        this.eventos = eventos;
    }
}
