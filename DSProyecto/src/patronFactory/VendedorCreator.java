/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronFactory;

import modelo.Usuario;
import modelo.Vendedor;

/**
 *
 * @author alvaro-pc
 */
public class VendedorCreator extends Creator {

    @Override
    Usuario crearUser() {
        return new Vendedor();
    }
    
}
