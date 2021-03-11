package com.adinfi.admaster.domain.sp;


import java.io.Serializable;
import java.util.List;

/**
 * Created by jdominguez on 2/4/17.
 */

public class UdpMediosEspaciosSel implements Serializable {

    private int asignados;
    private int total;
    private List<MediosEspacios> mediosEspaciosList;

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

    public List<MediosEspacios> getMediosEspaciosList() {
        return mediosEspaciosList;
    }

    public void setMediosEspaciosList(List<MediosEspacios> mediosEspaciosList) {
        this.mediosEspaciosList = mediosEspaciosList;
    }
}
