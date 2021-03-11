package com.adinfi.admaster.domain.sp;

import java.io.Serializable;

/**
 * Created by jdominguez on 2/4/17.
 */
public class UdpEspaciosCategoriaSel implements Serializable {

    private Long mediosId;
    private Long categoriasId;
    private Long subcategoriasId;
    private String desCategoria;
    private String desSubCategoria;
    private int pendientes;
    private int total;
    private boolean selected;

    public Long getMediosId() {
        return mediosId;
    }

    public void setMediosId(Long mediosId) {
        this.mediosId = mediosId;
    }

    public Long getCategoriasId() {
        return categoriasId;
    }

    public void setCategoriasId(Long categoriasId) {
        this.categoriasId = categoriasId;
    }

    public Long getSubcategoriasId() {
        return subcategoriasId;
    }

    public void setSubcategoriasId(Long subcategoriasId) {
        this.subcategoriasId = subcategoriasId;
    }

    public String getDesCategoria() {
        return desCategoria;
    }

    public void setDesCategoria(String desCategoria) {
        this.desCategoria = desCategoria;
    }

    public String getDesSubCategoria() {
        return desSubCategoria;
    }

    public void setDesSubCategoria(String desSubCategoria) {
        this.desSubCategoria = desSubCategoria;
    }

    public int getPendientes() {
        return pendientes;
    }

    public void setPendientes(int pendientes) {
        this.pendientes = pendientes;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
