/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronObserver;

/**
 *
 * @author alvaro-pc
 */
public class NotificacionVendedor implements PedidoObserver {

    @Override
    public String notifyObservers() {
       return "El pedido ha sido entregado al comprador";
    }
    
}
