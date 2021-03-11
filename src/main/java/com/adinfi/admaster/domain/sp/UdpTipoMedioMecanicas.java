package com.adinfi.admaster.domain.sp;

/**
 * Created by jdominguez on 3/7/17.
 */
public class UdpTipoMedioMecanicas {

    private boolean seleccionado;
    private String tipoMedios;
    private Long tipoMediosId;
    private int numeroSecciones;
    private int numeroPaginas;

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public String getTipoMedios() {
        return tipoMedios;
    }

    public void setTipoMedios(String tipoMedios) {
        this.tipoMedios = tipoMedios;
    }

    public Long getTipoMediosId() {
        return tipoMediosId;
    }

    public void setTipoMediosId(Long tipoMediosId) {
        this.tipoMediosId = tipoMediosId;
    }

    public int getNumeroSecciones() {
        return numeroSecciones;
    }

    public void setNumeroSecciones(int numeroSecciones) {
        this.numeroSecciones = numeroSecciones;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
}
