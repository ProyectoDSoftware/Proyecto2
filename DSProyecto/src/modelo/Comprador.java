/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Comprador extends Usuario{
    private ArrayList<Pedido>misPedidos;
    public Comprador() {
        super(null);
    }

    public Comprador(ArrayList<Pedido> misPedidos, String username) {
        super(username);
        this.misPedidos = misPedidos;
    }

    
    @Override
    public String toString() {
        return "Comprador{" + '}';
    }

    public ArrayList<Pedido> getMisPedidos() {
        return misPedidos;
    }

    public void setMisPedidos(ArrayList<Pedido> misPedidos) {
        this.misPedidos = misPedidos;
    }
    
    
    
}
