/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronEstrategy;

import modelo.Comprador;
import modelo.Pedido;
import modelo.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class PagoTarjetaIT {
    
    public PagoTarjetaIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of pagar method, of class PagoTarjeta.
     */
    @Test
    public void testPagar() {
        System.out.println("pagar");
        Pedido pedido = new Pedido();
        pedido.setCosto(200);
        PagoTarjeta instance = new PagoTarjeta();
        instance.setCantidad(290);
        instance.pagar(pedido);
        assertEquals(90, instance.getCantidad(),90);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
