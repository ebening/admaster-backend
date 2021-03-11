package com.adinfi.admaster.domain.sp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jdominguez on 3/1/17.
 */
public class IndicadoresMediosEspacios {

    private List<InnerTotales> totales;
    private List<InnerTipoMedio> tipoMedio;
    private List<InnerEspacio> espacios;

    public IndicadoresMediosEspacios() {
        this.totales = new ArrayList<>();
        this.tipoMedio = new ArrayList<>();
        this.espacios = new ArrayList<>();
    }

    public List<InnerTotales> getTotales() {
        return totales;
    }

    public void setTotales(List<InnerTotales> totales) {
        this.totales = totales;
    }

    public List<InnerTipoMedio> getTipoMedio() {
        return tipoMedio;
    }

    public void setTipoMedio(List<InnerTipoMedio> tipoMedio) {
        this.tipoMedio = tipoMedio;
    }

    public List<InnerEspacio> getEspacios() {
        return espacios;
    }

    public void setEspacios(List<InnerEspacio> espacios) {
        this.espacios = espacios;
    }

    public class InnerTotales {
        private int total;
        private int asignados;

        public InnerTotales() {
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getAsignados() {
            return asignados;
        }

        public void setAsignados(int asignados) {
            this.asignados = asignados;
        }
    }

    public class InnerTipoMedio {
        private int tipoMediosId;
        private String medios;
        private int ofertas;

        public int getTipoMediosId() {
            return tipoMediosId;
        }

        public void setTipoMediosId(int tipoMediosId) {
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

    public class InnerEspacio {
        private int espaciosUbicacionesId;
        private String espaciosPromocionales;
        private int cantidad;

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

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }
    }
}
