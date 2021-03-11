package com.adinfi.admaster.domain.sp;

import java.io.Serializable;

/**
 * Created by jdominguez on 2/8/17.
 */
public class UdpEspaciosProductosSel implements Serializable {

    private boolean seleccionado;
    private int componente;
    private String producto;
    private double preciazoClub;
    private String productosId;
    private int subCategoriaId;
    private int mecanicasId;
    private double preciosOferta;
    private boolean canonazo;
    private String combo;
    private boolean selected;
    private int row;

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public int getComponente() {
        return componente;
    }

    public void setComponente(int componente) {
        this.componente = componente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getPreciazoClub() {
        return preciazoClub;
    }

    public void setPreciazoClub(double preciazoClub) {
        this.preciazoClub = preciazoClub;
    }

    public String getProductosId() {
        return productosId;
    }

    public void setProductosId(String productosId) {
        this.productosId = productosId;
    }

    public int getSubCategoriaId() {
        return subCategoriaId;
    }

    public void setSubCategoriaId(int subCategoriaId) {
        this.subCategoriaId = subCategoriaId;
    }

    public int getMecanicasId() {
        return mecanicasId;
    }

    public void setMecanicasId(int mecanicasId) {
        this.mecanicasId = mecanicasId;
    }

    public double getPreciosOferta() {
        return preciosOferta;
    }

    public void setPreciosOferta(double preciosOferta) {
        this.preciosOferta = preciosOferta;
    }

    public boolean isCanonazo() {
        return canonazo;
    }

    public void setCanonazo(boolean canonazo) {
        this.canonazo = canonazo;
    }

    public String getCombo() {
        return combo;
    }

    public void setCombo(String combo) {
        this.combo = combo;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
