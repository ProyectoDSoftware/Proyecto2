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
public class Vendedor extends Usuario{
    private ArrayList<Venta>misVentas;
    private ArrayList<Pedido>misPedidos;
    private int calificacion;
    public Vendedor() {
        super(null);
    }

    public Vendedor(ArrayList<Venta> misVentas, ArrayList<Pedido> misPedidos, int calificacion, String username) {
        super(username);
        this.misVentas = misVentas;
        this.misPedidos = misPedidos;
        this.calificacion = calificacion;
    }

    
    public ArrayList<Venta> getMisVentas() {
        return misVentas;
    }

    public void setMisVentas(ArrayList<Venta> misVentas) {
        this.misVentas = misVentas;
    }

    public ArrayList<Pedido> getMisPedidos() {
        return misPedidos;
    }

    public void setMisPedidos(ArrayList<Pedido> misPedidos) {
        this.misPedidos = misPedidos;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    
 
    

    

    
}
