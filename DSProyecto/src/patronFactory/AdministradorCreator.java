/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronFactory;

import modelo.Administrador;
import modelo.Usuario;

/**
 *
 * @author alvaro-pc
 */
public class AdministradorCreator extends Creator {

    @Override
    Usuario crearUser() {
        return new Administrador();
    }
    
}
