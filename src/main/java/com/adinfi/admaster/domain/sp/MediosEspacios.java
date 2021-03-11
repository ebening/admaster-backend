package com.adinfi.admaster.domain.sp;

/**
 * Created by jdominguez on 2/4/17.
 */
public class MediosEspacios {

    private Long mediosId;
    private String descripcion;
    private int asignados;
    private int total;

    public Long getMediosId() {
        return mediosId;
    }

    public void setMediosId(Long mediosId) {
        this.mediosId = mediosId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getAsignados() {
        return asignados;
    }

    public void setAsignados(int asignados) {
        this.asignados = asignados;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
