/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;


/**
 *
 * @author Alex Macas
 * admacas2592
 */
public class Conexion {
    private Connection conexion;
     private final String driver ="com.mysql.jdbc.Driver";
    private final String usuario ="henrym";
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

    private void alarm(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Mensaje de Informacion");
        alert.setContentText(message);
        alert.showAndWait();
    }
}