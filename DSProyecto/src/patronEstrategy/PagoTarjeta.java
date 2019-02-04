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
    protected String Numero;
    protected Usuario usuario;
    protected double cantidad;

    @Override
    public void pagar(Pedido pedido) {
        if(cantidad<pedido.getCosto()){
            MetodosChangeWindow.alarm("No se puede hacer el pago");
        }else{
            cantidad-=pedido.getCosto();
        }
    }
    
}
