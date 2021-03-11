package com.adinfi.admaster.domain.sp;

import java.io.Serializable;

/**
 * Created by jdominguez on 2/13/17.
 */
public class UdpIndicadoresMediosOfertaSel implements Serializable {

    private InnerResult1 innerResult1;
    private InnerResult2 innerResult2;
    private InnerResult3 innerResult3;

    // ********** Getters & Setters ************ //

    public InnerResult1 getInnerResult1() {
        return innerResult1;
    }

    public void setInnerResult1(InnerResult1 innerResult1) {
        this.innerResult1 = innerResult1;
    }

    public InnerResult2 getInnerResult2() {
        return innerResult2;
    }

    public void setInnerResult2(InnerResult2 innerResult2) {
        this.innerResult2 = innerResult2;
    }

    public InnerResult3 getInnerResult3() {
        return innerResult3;
    }

    public void setInnerResult3(InnerResult3 innerResult3) {
        this.innerResult3 = innerResult3;
    }

    // ********** Inner Classes ***************** //
    public class InnerResult1 {
        private int total;
        private int asignado;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getAsignado() {
            return asignado;
        }

        public void setAsignado(int asignado) {
            this.asignado = asignado;
        }
    }

    public class InnerResult2 {
        private Long tipoMediosId;
        private String medios;
        private int ofertas;

        public Long getTipoMediosId() {
            return tipoMediosId;
        }

        public void setTipoMediosId(Long tipoMediosId) {
            this.tipoMediosId = tipoMediosId;
        }

        public String getMedios() {
            return medios;
        }

        public void setMedios(String medios) {
            this.medios = medios;
        }

        public int getOfertas() {
            return ofertas;
        }

        public void setOfertas(int ofertas) {
            this.ofertas = ofertas;
        }
    }

    public class InnerResult3 {
        private Long espaciosUbicacionesId;
        private String espaciosPromocionales;
        private int cantidad;

        public Long getEspaciosUbicacionesId() {
            return espaciosUbicacionesId;
        }

        public void setEspaciosUbicacionesId(Long espaciosUbicacionesId) {
            this.espaciosUbicacionesId = espaciosUbicacionesId;
        }

        public String getEspaciosPromocionales() {
            return espaciosPromocionales;
        }

        public void setEspaciosPromocionales(String espaciosPromocionales) {
            this.espaciosPromocionales = espaciosPromocionales;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }
    }
}
