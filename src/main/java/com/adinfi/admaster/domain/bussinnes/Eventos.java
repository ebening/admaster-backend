package com.adinfi.admaster.domain.bussinnes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jdominguez on 1/15/17.
 */
@Entity
@Table(name = "Eventos")
public class Eventos {

    @Id
    @Column(name = "EventosId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventosId;

    @Column(name = "Nombre")
    @NotNull
    @Size(min = 2, max = 50)
    private String nombre;

    @Column(name = "NumeroEvento")
    @Size(max = 10)
    private String numeroEvento;

    @Column(name = "ProgramasID")
    private Long programasId;

    @Column(name = "PeriodosId")
    private Long periodosId;

    @ManyToOne
    @JoinColumn(name = "TipoEventosId")
    private TipoEventos tipoEventos;

    @Column(name = "StatusId")
    private Integer statusId;

    @Column(name = "FechaInicial")
    private Date fechaInicial;

    @Column(name = "FechaFinal")
    private Date fechaFinal;

    @Column(name = "FechaModificacionStatus")
    private Timestamp fechaModificacionStatus;

    @Column(name = "HoraInicial")
    private Timestamp horaInicial;

    @Column(name = "HoraFinal")
    private Timestamp horaFinal;

    @Column(name = "IngresosPOPReal")
    private Double ingresosPopReal;

    @Column(name = "Activo")
    private boolean activo;

    @Column(name = "UsuariosID")
    private Long usuariosID;

    @Column(name = "Tag1")
    private String tag1;

    @Column(name = "Tag2")
    private String tag2;

    @Column(name = "Tag3")
    private String tag3;

    @Column(name = "FechaCreacion")
    private Date fechaCreacion;

    @Column(name = "FechaModificacion")
    private Date fechaModificacion;

    @Column(name = "UsuarioCreadorId")
    private Long usuarioCreadorId;

    @Column(name = "UsuraioModificadorId")
    private Long usuarioModificadorId;

    public Eventos() {
    }

    public Long getEventosId() {
        return eventosId;
    }

    public void setEventosId(Long eventosId) {
        this.eventosId = eventosId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroEvento() {
        return numeroEvento;
    }

    public void setNumeroEvento(String numeroEvento) {
        this.numeroEvento = numeroEvento;
    }

    public Long getProgramasId() {
        return programasId;
    }

    public void setProgramasId(Long programasId) {
        this.programasId = programasId;
    }

    public Long getPeriodosId() {
        return periodosId;
    }

    public void setPeriodosId(Long periodosId) {
        this.periodosId = periodosId;
    }

    public TipoEventos getTipoEventos() {
        return tipoEventos;
    }

    public void setTipoEventos(TipoEventos tipoEventos) {
        this.tipoEventos = tipoEventos;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
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

    public Timestamp getFechaModificacionStatus() {
        return fechaModificacionStatus;
    }

    public void setFechaModificacionStatus(Timestamp fechaModificacionStatus) {
        this.fechaModificacionStatus = fechaModificacionStatus;
    }

    public Timestamp getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Timestamp horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Timestamp getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Timestamp horaFinal) {
        this.horaFinal = horaFinal;
    }

    public Double getIngresosPopReal() {
        return ingresosPopReal;
    }

    public void setIngresosPopReal(Double ingresosPopReal) {
        this.ingresosPopReal = ingresosPopReal;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Long getUsuariosID() {
        return usuariosID;
    }

    public void setUsuariosID(Long usuariosID) {
        this.usuariosID = usuariosID;
    }

    public String getTag1() {
        return tag1;
    }

    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

    public String getTag2() {
        return tag2;
    }

    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }

    public String getTag3() {
        return tag3;
    }

    public void setTag3(String tag3) {
        this.tag3 = tag3;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Long getUsuarioCreadorId() {
        return usuarioCreadorId;
    }

    public void setUsuarioCreadorId(Long usuarioCreadorId) {
        this.usuarioCreadorId = usuarioCreadorId;
    }

    public Long getUsuarioModificadorId() {
        return usuarioModificadorId;
    }

    public void setUsuarioModificadorId(Long usuarioModificadorId) {
        this.usuarioModificadorId = usuarioModificadorId;
    }
    
    public String getFechaInicialStr(){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	return sdf.format(this.fechaInicial);
    }
    public String getFechaFinalStr(){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	return sdf.format(this.fechaFinal);
    }
    
    public Long getFechaInicialTime(){
    	return this.fechaInicial.getTime();
    }
    public Long getFechaFinalTime(){
    	return this.fechaFinal.getTime();
    }
}
