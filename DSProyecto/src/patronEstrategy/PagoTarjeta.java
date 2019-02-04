/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronEstrategy;

import dsproyecto.MetodosChangeWindow;
import modelo.Pedido;
import modelo.Usuario;

/**
 *
 * @author Usuario
 */
public class PagoTarjeta implements PagoEstrategy{
    private String Numero;
    private Usuario usuario;
    private double cantidad;

    public PagoTarjeta(String Numero, Usuario usuario, double cantidad) {
        this.Numero = Numero;
        this.usuario = usuario;
        this.cantidad = cantidad;
    }

    public PagoTarjeta() {
    }

    
    @Override
    public void pagar(Pedido pedido) {
        if(cantidad<pedido.getCosto()){
            MetodosChangeWindow.alarm("No se puede hacer el pago");
        }else{
            cantidad-=pedido.getCosto();
        }
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
}
