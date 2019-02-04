/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Articulo {
    protected String nombre;
    protected String categoria;
    protected double calificacion;
    protected Date tiempomaximo; 
    protected double precio;

    public Articulo(String nombre, String categoria, double calificacion, Date tiempomaximo, double precio) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.calificacion = calificacion;
        this.tiempomaximo = tiempomaximo;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public Date getTiempomaximo() {
        return tiempomaximo;
    }

    public void setTiempomaximo(Date tiempomaximo) {
        this.tiempomaximo = tiempomaximo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return  nombre + "," + categoria + "," + calificacion + "," + tiempomaximo + "," + precio;
    }
    
    
}
