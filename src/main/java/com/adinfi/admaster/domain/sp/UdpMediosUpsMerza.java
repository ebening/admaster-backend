package com.adinfi.admaster.domain.sp;


import java.sql.Date;

/**
 * Created by jdominguez on 3/2/17.
 */
public class UdpMediosUpsMerza {

    private Long eventosId;
    private int tipoMediosId;
    private int numeroPartes;
    private int numeroSecciones;
    private Date fechaInicial;
    private Date fechaFinal;
    private Long usuariosId;
    private Long mediosId;
    private String descripcion;
    private Long mecanicasId;
    private Long subCategoriaId;
    private Long espaciosUbicacionesId;

    public Long getEventosId() {
        return eventosId;
    }

    public void setEventosId(Long eventosId) {
        this.eventosId = eventosId;
    }

    public int getTipoMediosId() {
        return tipoMediosId;
    }

    public void setTipoMediosId(int tipoMediosId) {
        this.tipoMediosId = tipoMediosId;
    }

    public int getNumeroPartes() {
        return numeroPartes;
    }

    public void setNumeroPartes(int numeroPartes) {
        this.numeroPartes = numeroPartes;
    }

    public int getNumeroSecciones() {
        return numeroSecciones;
    }

    public void setNumeroSecciones(int numeroSecciones) {
        this.numeroSecciones = numeroSecciones;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Long getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(Long usuariosId) {
        this.usuariosId = usuariosId;
    }

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

    public Long getMecanicasId() {
        return mecanicasId;
    }

    public void setMecanicasId(Long mecanicasId) {
        this.mecanicasId = mecanicasId;
    }

    public Long getSubCategoriaId() {
        return subCategoriaId;
    }

    public void setSubCategoriaId(Long subCategoriaId) {
        this.subCategoriaId = subCategoriaId;
    }

    public Long getEspaciosUbicacionesId() {
        return espaciosUbicacionesId;
    }

    public void setEspaciosUbicacionesId(Long espaciosUbicacionesId) {
        this.espaciosUbicacionesId = espaciosUbicacionesId;
    }
}
