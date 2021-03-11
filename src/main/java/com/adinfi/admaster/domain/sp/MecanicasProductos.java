package com.adinfi.admaster.domain.sp;

import java.io.Serializable;

/**
 * Created by jdominguez on 2/11/17.
 */
public class MecanicasProductos implements Serializable{

    private boolean seleccionado;
    private String combo;
    private int componente;
    private String cobertura;
    private String descripcion;
    private double preciosOferta;
    private double porcentajeDescuento;
    private String tipoMedios;
    private String espaciosPromocional;
    private String productosId;
    private Long subCategoriaId;

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public String getCombo() {
        return combo;
    }

    public void setCombo(String combo) {
        this.combo = combo;
    }

    public int getComponente() {
        return componente;
    }

    public void setComponente(int componente) {
        this.componente = componente;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPreciosOferta() {
        return preciosOferta;
    }

    public void setPreciosOferta(double preciosOferta) {
        this.preciosOferta = preciosOferta;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public String getTipoMedios() {
        return tipoMedios;
    }

    public void setTipoMedios(String tipoMedios) {
        this.tipoMedios = tipoMedios;
    }

    public String getEspaciosPromocional() {
        return espaciosPromocional;
    }

    public void setEspaciosPromocional(String espaciosPromocional) {
        this.espaciosPromocional = espaciosPromocional;
    }

    public String getProductosId() {
        return productosId;
    }

    public void setProductosId(String productosId) {
        this.productosId = productosId;
    }

    public Long getSubCategoriaId() {
        return subCategoriaId;
    }

    public void setSubCategoriaId(Long subCategoriaId) {
        this.subCategoriaId = subCategoriaId;
    }
}
