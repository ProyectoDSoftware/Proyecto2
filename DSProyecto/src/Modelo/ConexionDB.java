/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import dsproyecto.MetodosChangeWindow;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;


/**
 *
 * @author Henry Maticurena
 * 
 */
public class ConexionDB {
    private Connection conexion;
     private final String driver ="com.mysql.jdbc.Driver";
    private final String usuario ="hmaticur";
    private final String password ="ZXKFDLRFPL0";
    private final String url ="jdbc:mysql://127.0.0.1:3306/poliventas";
    public ConexionDB(){
         conexion=null;
        try {
            Class.forName(driver);
            conexion=DriverManager.getConnection(url,usuario,password);
            if(conexion !=null){
                System.out.println("Conexion exitosa");
            }
        } catch (ClassNotFoundException|SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            MetodosChangeWindow.alarm("Fallo la conexion a la base de datos");
        }
    }
     public Connection getConnection(){
        return this.getConexion();
    }
     public void cerrarConexion() throws SQLException{
        getConexion().close();
    }

    
    public ArrayList<Articulo> selectArticuloMasBuscado(Connection conexion,String tipo){
        ArrayList<Articulo>nuevo=new ArrayList<>();
        String sql="Select * from "+tipo+";";
        try (Statement stmt=conexion.createStatement() ;
            ResultSet rs=stmt.executeQuery(sql);){
            while (rs.next()) {
                Articulo art=new Articulo(rs.getString("nombre"), rs.getString("categoria"),rs.getDouble("rateProm"),rs.getDate("tiempoMaxima"), rs.getDouble("precio"));
                nuevo.add(art);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            MetodosChangeWindow.alarm("Ocurrio un problema con la conexion a la base de datos, reinicie aplicación");
        }
        return nuevo;
    }

    public Usuario selectUsuario(Connection conexion,String username){
        Usuario userPrueba=new Usuario(Constants.PRUEBA);  
        String sql="call SP_SeleccionarUsuario('"+username+"');";
        try ( Statement stmt=conexion.createStatement();
            ResultSet rs=stmt.executeQuery(sql);){
            while(rs.next()){
                Usuario user=new Usuario(rs.getString("nombrerol"), rs.getString("usuario"),rs.getString("passwd"),rs.getString("nombre"),rs.getString("apellido"), rs.getString("telefono"),rs.getString("email"), rs.getBoolean("whatsapp"), rs.getString("direccion"), rs.getString("cedula"), rs.getInt("disponible"));
                return user;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            MetodosChangeWindow.alarm("Ocurrio un problema");
        } 
        return userPrueba;
    }
    
        public void insertDataBaseUser(Connection conexion,String valores){
        String sql="call SP_IngresarEmpleado('"+valores+"');";
        try (PreparedStatement stmt=conexion.prepareStatement(sql);){
            int ingreso=stmt.executeUpdate();
            if(ingreso>0){
                MetodosChangeWindow.alarm("Se ha ingresado correctamente los datos");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            MetodosChangeWindow.alarm("Ocurrio un problema");
        }
    }
    public void actualizarDataBaseUsuario(Connection conection,Usuario empleado){
        String sql="call SP_ActualizarCliente('"+empleado.toString()+"');";
        
        try (PreparedStatement stmt=conection.prepareStatement(sql);){
            int actualizar=stmt.executeUpdate(sql);
            if(actualizar>0){
                MetodosChangeWindow.alarm("Los datos han sido actualizados");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            MetodosChangeWindow.alarm("Ocurrio un problema");
        }
        
    }

    /**
     * @return the conexion
     */
    public Connection getConexion() {
        return conexion;
    }

    /**
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }
}