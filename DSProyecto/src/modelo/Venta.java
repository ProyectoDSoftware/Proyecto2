/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class Venta {
    protected List<Pedido>pedido;
    protected String Estado;
    protected String lugarDeEntrega;

    public List<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(List<Pedido> pedido) {
        this.pedido = pedido;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getLugarDeEntrega() {
        return lugarDeEntrega;
    }

    public void setLugarDeEntrega(String lugarDeEntrega) {
        this.lugarDeEntrega = lugarDeEntrega;
    }

    @Override
    public String toString() {
        return "pedido=" + pedido + ", Estado=" + Estado + ", lugarDeEntrega=" + lugarDeEntrega;
    }
    
    
}
