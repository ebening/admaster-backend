package com.adinfi.admaster.dto;

/**
 * Created by jdominguez on 1/24/17.
 */

public class EtiquetasDTO {

    private String EVENTO;

    private String EVENTO_PLURAL;

    private String MECANICA;

    private String MECANICA_PLURAL;

    private String CATEGORIA;

    private String SUBCATEGORIA;

    private String BTN_BORRAR;

    private String MENU_BANDEJA;

    public EtiquetasDTO() {

    }


    public String getEVENTO() {
        return EVENTO;
    }

    public void setEVENTO(String EVENTO) {
        this.EVENTO = EVENTO;
    }

    public String getEVENTO_PLURAL() {
        return EVENTO_PLURAL;
    }

    public void setEVENTO_PLURAL(String EVENTO_PLURAL) {
        this.EVENTO_PLURAL = EVENTO_PLURAL;
    }

    public String getMECANICA() {
        return MECANICA;
    }

    public void setMECANICA(String MECANICA) {
        this.MECANICA = MECANICA;
    }

    public String getMECANICA_PLURAL() {
        return MECANICA_PLURAL;
    }

    public void setMECANICA_PLURAL(String MECANICA_PLURAL) {
        this.MECANICA_PLURAL = MECANICA_PLURAL;
    }

    public String getCATEGORIA() {
        return CATEGORIA;
    }

    public void setCATEGORIA(String CATEGORIA) {
        this.CATEGORIA = CATEGORIA;
    }

    public String getSUBCATEGORIA() {
        return SUBCATEGORIA;
    }

    public void setSUBCATEGORIA(String SUBCATEGORIA) {
        this.SUBCATEGORIA = SUBCATEGORIA;
    }

    public String getBTN_BORRAR() {
        return BTN_BORRAR;
    }

    public void setBTN_BORRAR(String BTN_BORRAR) {
        this.BTN_BORRAR = BTN_BORRAR;
    }

    public String getMENU_BANDEJA() {
        return MENU_BANDEJA;
    }

    public void setMENU_BANDEJA(String MENU_BANDEJA) {
        this.MENU_BANDEJA = MENU_BANDEJA;
    }
}
