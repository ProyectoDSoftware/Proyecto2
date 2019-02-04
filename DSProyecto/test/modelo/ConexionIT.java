/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.util.ArrayList;
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
public class ConexionIT {
    
    public ConexionIT() {
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
     * Test of getConnection method, of class Conexion.
     */
    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        Conexion instance = new Conexion();
        Connection expResult = null;
        Connection result = instance.getConnection();
        assertNotSame(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of cerrarConexion method, of class Conexion.
     */
    @Test
    public void testCerrarConexion() throws Exception {
        System.out.println("cerrarConexion");
        Conexion instance = new Conexion();
        instance.cerrarConexion();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of selectArticuloMasBuscado method, of class Conexion.
     */
    @Test
    public void testSelectArticuloMasBuscado() {
        System.out.println("selectArticuloMasBuscado");
        Connection conexion = null;
        String tipo = "ArticulosMasBuscados";
        Conexion instance = new Conexion();
        ArrayList<Articulo> result = instance.selectArticuloMasBuscado(conexion, tipo);
        result.forEach((articulo) -> {
            assertNotNull(articulo);
        });
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of selectUsuario method, of class Conexion.
     */
    @Test
    public void testSelectUsuario() {
        System.out.println("selectUsuario");
        String username = "hmaticu";
        Conexion instance = new Conexion();
        Usuario result = instance.selectUsuario(instance.getConnection(), username);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


    /**
     * Test of getBuscarUsuarios method, of class Conexion.
     */
    @Test
    public void testGetBuscarUsuarios() {
        System.out.println("getBuscarUsuarios");
        String nom = "";
        Conexion instance = new Conexion();
        ArrayList<Usuario> result = instance.getBuscarUsuarios(instance.getConnection(), nom);
        result.forEach((usuario) -> {
            assertNotNull(usuario);
        }); // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getBuscarArticulos method, of class Conexion.
     */
    @Test
    public void testGetBuscarArticulos() {
        System.out.println("getBuscarArticulos");
        String nom = "";
        Conexion instance = new Conexion();
        ArrayList<Articulo> result = instance.getBuscarArticulos(instance.getConnection(), nom);
        result.forEach((articulo) -> {
            assertNotNull(articulo);
        });
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
