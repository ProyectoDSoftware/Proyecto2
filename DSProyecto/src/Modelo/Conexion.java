/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
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
        try {
            Class.forName(driver);
            conexion=DriverManager.getConnection(url,usuario,password);
            if(conexion !=null){
                System.out.println("Conexion exitosa");
            }
        } catch (ClassNotFoundException|SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            this.alarm("Fallo la conexion a la base de datos");
        }
    }
     public Connection getConnection(){
        return this.conexion;
    }
     public void cerrarConexion() throws SQLException{
        conexion.close();
    }

    private static void alarm(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Mensaje de Informacion");
        alert.setContentText(message);
        alert.showAndWait();
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
            alarm("Ocurrio un problema con la conexion a la base de datos, reinicie aplicación");
        }
        return "";
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
                Usuario user=new Usuario(rol, usuario, name, name, usuario, rol, rol, true, rol, rol);
                return user;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            this.alarm("Ocurrio un problema");
        } 
        return userPrueba;
    }
}