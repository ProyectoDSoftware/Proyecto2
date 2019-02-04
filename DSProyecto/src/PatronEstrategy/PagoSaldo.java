/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatronEstrategy;


import Modelo.ConexionDB;
import Modelo.Pedido;
import dsproyecto.MetodosChangeWindow;
import java.sql.Connection;

/**
 *
 * @author Usuario
 */
public class PagoSaldo implements PagoEstrategy{

    @Override
    public void pagar(Pedido pedido) {
        /*
        if(4<pedido.getCosto()){
            MetodosChangeWindow.alarm("el saldo es menor al actual, no se puede ejecutar dicha operación");
        }else{
            comprador.setSaldo(comprador.getSaldo-pedido.getCosto());
            conexion.actualizarDataBaseUsuario(conexion, comprador);
        }*/
    }
    
}
