/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Pedido {
    protected List<Articulo>articulos;
    protected double costo;
    protected String estado;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
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
    
    
}