package com.adinfi.admaster.domain.sp;

/**
 * Created by jdominguez on 3/7/17.
 */
public class UdpMediosUbicacionesMecanicas {

    private int espaciosUbicacionesId;
    private String espaciosPromocionales;
    private boolean seleccionado;

    public int getEspaciosUbicacionesId() {
        return espaciosUbicacionesId;
    }

    public void setEspaciosUbicacionesId(int espaciosUbicacionesId) {
        this.espaciosUbicacionesId = espaciosUbicacionesId;
    }

    public String getEspaciosPromocionales() {
        return espaciosPromocionales;
    }

    public void setEspaciosPromocionales(String espaciosPromocionales) {
        this.espaciosPromocionales = espaciosPromocionales;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
}
