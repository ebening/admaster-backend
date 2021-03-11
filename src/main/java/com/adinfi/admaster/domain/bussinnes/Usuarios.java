package com.adinfi.admaster.domain.bussinnes;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

/**
 * Created by jdominguez on 1/27/17.
 */
@Entity
public class Usuarios {
    private long usuariosId;
    private String usuario;
    private String password;
    private Boolean cambioPassword;
    private Boolean sesion;
    private String nombre;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String direccion;
    private String correo;
    private boolean activo;
    private Timestamp fechaCreacion;
    private Timestamp fechaModificacion;
    private Long usuariosIdJefe;
    private Long usuarioCreadorId;
    private Long usuarioModificadorId;
    private Boolean nIvel1;
    private Collection<UsuariosCategorias> usuariosCategoriassByUsuariosId;
    private Collection<UsuariosPerfiles> usuariosPerfilesByUsuariosId;

    @Id
    @Column(name = "UsuariosId", nullable = false)
    public long getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(long usuariosId) {
        this.usuariosId = usuariosId;
    }

    @Basic
    @Column(name = "Usuario", nullable = true, length = 20)
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Basic
    @Column(name = "Password", nullable = true, length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "CambioPassword", nullable = true)
    public Boolean getCambioPassword() {
        return cambioPassword;
    }

    public void setCambioPassword(Boolean cambioPassword) {
        this.cambioPassword = cambioPassword;
    }

    @Basic
    @Column(name = "Sesion", nullable = true)
    public Boolean getSesion() {
        return sesion;
    }

    public void setSesion(Boolean sesion) {
        this.sesion = sesion;
    }

    @Basic
    @Column(name = "Nombre", nullable = true, length = 200)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "ApellidoMaterno", nullable = true, length = 100)
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    @Basic
    @Column(name = "ApellidoPaterno", nullable = true, length = 100)
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    @Basic
    @Column(name = "Direccion", nullable = true, length = 200)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "Correo", nullable = true, length = 100)
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Basic
    @Column(name = "Activo", nullable = false)
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Basic
    @Column(name = "FechaCreacion", nullable = true)
    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Basic
    @Column(name = "FechaModificacion", nullable = true)
    public Timestamp getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Timestamp fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Basic
    @Column(name = "UsuariosIdJefe", nullable = true)
    public Long getUsuariosIdJefe() {
        return usuariosIdJefe;
    }

    public void setUsuariosIdJefe(Long usuariosIdJefe) {
        this.usuariosIdJefe = usuariosIdJefe;
    }

    @Basic
    @Column(name = "UsuarioCreadorId", nullable = true)
    public Long getUsuarioCreadorId() {
        return usuarioCreadorId;
    }

    public void setUsuarioCreadorId(Long usuarioCreadorId) {
        this.usuarioCreadorId = usuarioCreadorId;
    }

    @Basic
    @Column(name = "UsuarioModificadorId", nullable = true)
    public Long getUsuarioModificadorId() {
        return usuarioModificadorId;
    }

    public void setUsuarioModificadorId(Long usuarioModificadorId) {
        this.usuarioModificadorId = usuarioModificadorId;
    }

    @Basic
    @Column(name = "NIvel1", nullable = true)
    public Boolean getnIvel1() {
        return nIvel1;
    }

    public void setnIvel1(Boolean nIvel1) {
        this.nIvel1 = nIvel1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuarios usuarios = (Usuarios) o;
        return usuariosId == usuarios.usuariosId &&
                activo == usuarios.activo &&
                Objects.equals(usuario, usuarios.usuario) &&
                Objects.equals(password, usuarios.password) &&
                Objects.equals(cambioPassword, usuarios.cambioPassword) &&
                Objects.equals(sesion, usuarios.sesion) &&
                Objects.equals(nombre, usuarios.nombre) &&
                Objects.equals(apellidoMaterno, usuarios.apellidoMaterno) &&
                Objects.equals(apellidoPaterno, usuarios.apellidoPaterno) &&
                Objects.equals(direccion, usuarios.direccion) &&
                Objects.equals(correo, usuarios.correo) &&
                Objects.equals(fechaCreacion, usuarios.fechaCreacion) &&
                Objects.equals(fechaModificacion, usuarios.fechaModificacion) &&
                Objects.equals(usuariosIdJefe, usuarios.usuariosIdJefe) &&
                Objects.equals(usuarioCreadorId, usuarios.usuarioCreadorId) &&
                Objects.equals(usuarioModificadorId, usuarios.usuarioModificadorId) &&
                Objects.equals(nIvel1, usuarios.nIvel1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuariosId, usuario, password, cambioPassword, sesion, nombre, apellidoMaterno, apellidoPaterno, direccion, correo, activo, fechaCreacion, fechaModificacion, usuariosIdJefe, usuarioCreadorId, usuarioModificadorId, nIvel1);
    }

    @OneToMany(mappedBy = "usuariosByUsuariosId")
    public Collection<UsuariosCategorias> getUsuariosCategoriassByUsuariosId() {
        return usuariosCategoriassByUsuariosId;
    }

    public void setUsuariosCategoriassByUsuariosId(Collection<UsuariosCategorias> usuariosCategoriassByUsuariosId) {
        this.usuariosCategoriassByUsuariosId = usuariosCategoriassByUsuariosId;
    }

    @OneToMany(mappedBy = "usuariosByUsuariosId")
    public Collection<UsuariosPerfiles> getUsuariosPerfilesByUsuariosId() {
        return usuariosPerfilesByUsuariosId;
    }

    public void setUsuariosPerfilesByUsuariosId(Collection<UsuariosPerfiles> usuariosPerfilesByUsuariosId) {
        this.usuariosPerfilesByUsuariosId = usuariosPerfilesByUsuariosId;
    }
}
