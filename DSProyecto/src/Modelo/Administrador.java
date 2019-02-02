/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class Administrador extends Usuario{
    protected List<Usuario>usuarios;

    public Administrador(String rol, String usuario, String contraseña, String nombre, String apellido, String telefono, String email, boolean whassapt, String direccion, String cedula, double saldo, int disponible) {
        super(rol, usuario, contraseña, nombre, apellido, telefono, email, whassapt, direccion, cedula, saldo, disponible);
    }
    

    
}
