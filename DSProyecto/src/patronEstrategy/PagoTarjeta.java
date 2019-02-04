/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronEstrategy;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
