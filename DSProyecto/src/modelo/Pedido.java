/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import java.util.List;
import patronObserver.NotificacionComprador;
import patronObserver.NotificacionVendedor;

/**
 *
 * @author Usuario
 */
public class Pedido {
    protected List<Articulo>articulos;
    protected double costo;
    protected boolean estado;
    protected Date fechadeEntrega;

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getFechadeEntrega() {
        return fechadeEntrega;
    }

    public void setFechadeEntrega(Date fechadeEntrega) {
        this.fechadeEntrega = fechadeEntrega;
    }

    @Override
    public String toString() {
        return "articulos=" + articulos + ", costo=" + costo + ", estado=" + estado + ", fechadeEntrega=" + fechadeEntrega;
    }
    
    public void notificarEstado(Pedido pedido){
        if(estado){
            NotificacionVendedor alarmaVendedor=new NotificacionVendedor();
            alarmaVendedor.notifyObservers();
            NotificacionComprador alarmaComprador=new NotificacionComprador();
            alarmaComprador.notifyObservers();
            ///ss
        }
        
    }    
}
