/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Usuario {
    protected String rol;
    protected String usuario;
    protected String contraseña;
    protected String nombre;
    protected String apellido;
    protected String telefono;
    protected String email;
    protected boolean whassapt;
    protected String direccion;
    protected String cedula;
    protected int disponible;
    

    public Usuario(String rol, String usuario, String contraseña, String nombre, String apellido, String telefono, String email, boolean whassapt, String direccion, String cedula, int disponible) {
        this.rol = rol;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.whassapt = whassapt;
        this.direccion = direccion;
        this.cedula = cedula;
        this.disponible = disponible;
    }


    public Usuario(String username){
        this.usuario=username;
    }
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isWhassapt() {
        return whassapt;
    }

    public void setWhassapt(boolean whassapt) {
        this.whassapt = whassapt;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return cedula+","+nombre+","+apellido+","+telefono+","+whassapt+","+email+","+direccion+","+usuario+","+contraseña+","+rol+","+disponible;
    }
    
    
    
}
