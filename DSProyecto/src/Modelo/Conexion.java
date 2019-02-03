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

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;


/**
 *
 * @author Henry Maticurena
 * 
 */
public class Conexion {
    private Connection conexion;
    private final String driver ="com.mysql.jdbc.Driver";
    private final String usuario ="hmaticur";
    private final String password ="ZXKFDLRFPL0";
    private final String url ="jdbc:mysql://127.0.0.1:3306/poliventas";
    public Conexion(){
         conexion=null;
         boolean EstaConectado=conexion!=null;
        try {
            Class.forName(driver);
            conexion=DriverManager.getConnection(url,usuario,password);
            if(EstaConectado){
                System.out.println("Conexion exitosa");
            }
        } catch (ClassNotFoundException|SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            MetodosChangeWindow.alarm("Fallo la conexion a la base de datos");
        }
    }
     public Connection getConnection(){
        return this.conexion;
    }
     public void cerrarConexion() throws SQLException{
        conexion.close();
    }

    
    public String selectArticuloMasBuscado(Connection conexion){
        String sql="Select * from ArticulosMasBuscados";
        try (Statement stmt=conexion.createStatement() ;
            ResultSet rs=stmt.executeQuery(sql);){
            while (rs.next()) {
                return rs.getString("nombre");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            MetodosChangeWindow.alarm("Ocurrio un problema con la conexion a la base de datos, reinicie aplicación");
        }
        return "No se pudo obtener el articulo mas buscado";
    }
    public Usuario selectUsuario(Connection conexion,String username){
        Usuario userPrueba=new Usuario(Constants.PRUEBA);  
        String sql="call SP_SeleccionarUsuario('"+username+"');";
        try ( Statement stmt=conexion.createStatement();
            ResultSet rs=stmt.executeQuery(sql);){
            while(rs.next()){
                int id=rs.getInt("Iduser");
                String name=rs.getString("Username");
                String pass=rs.getString("Passwords");
                String rol=rs.getString("Rol");
                int estado=rs.getInt("Estado");
                Usuario user=new Usuario(rol, usuario, name, name, usuario, rol, rol, true, rol, rol, estado, estado);
                return user;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            MetodosChangeWindow.alarm("Ocurrio un problema");
        } 
        return userPrueba;
    }
    
    public void actualizarDataBaseUsuario(Connection conection,Usuario empleado){
        String sql="call SP_ActualizarCliente('"+empleado.toString()+"');";
        
        try (PreparedStatement stmt=conection.prepareStatement(sql);){
            int actualizar=stmt.executeUpdate(sql);
            boolean EstaActualizado= actualizar>0;
            if(EstaActualizado){
                MetodosChangeWindow.alarm("Los datos han sido actualizados");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            MetodosChangeWindow.alarm("Ocurrio un problema");
        }
        
    }
    
    
    /*
    Crear un nuevo usuario en la bd (mysql.user) Correr el sgte codigo en la base de datos  
“GRANT ALL ON . to user@'%'IDENTIFIED BY '';

Abrir el puerto 3306 en la maquina donde esta instalada la base de datos 
  Control Panel -> 
  Windows Firewall -> 
  Advance Settings -> 
  Inbound Rules -> 
  New Rule -> 
  Port ->
  Next -> 
  TCP & set port as 3306 ->
  Next -> 
  Next ->
  Next ->
  Fill Name and Description ->
  Finish ->

    */
}