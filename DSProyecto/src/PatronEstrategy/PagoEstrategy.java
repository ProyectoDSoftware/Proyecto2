/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatronEstrategy;

import Modelo.Pedido;

/**
 *
 * @author Usuario
 */
public interface PagoEstrategy {
    void pagar(Pedido pedido);
}
