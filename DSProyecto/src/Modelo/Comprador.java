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
public class Comprador extends Usuario{

    public Comprador(String rol, String usuario, String contraseña, String nombre, String apellido, String telefono, String email, boolean whassapt, String direccion, String cedula, double saldo, int disponible) {
        super("comprador", usuario, contraseña, nombre, apellido, telefono, email, whassapt, direccion, cedula, saldo, disponible);
    }
    

    @Override
    public String toString() {
        return "Comprador{" + '}';
    }
    
    
    
}
