/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronFactory;

import java.util.ArrayList;
import modelo.Comprador;
import modelo.Pedido;
import modelo.Usuario;

/**
 *
 * @author alvaro-pc
 */
public class CompradorCreator extends Creator {
    
    private ArrayList<Pedido>misPedidos;

    @Override
    Usuario crearUser() {
        return new Comprador(misPedidos, "");   
    }
    
}
