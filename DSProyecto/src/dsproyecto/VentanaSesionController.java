/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproyecto;

import Modelo.Conexion;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class VentanaSesionController implements Initializable {
    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField tx1;
    @FXML
    private TextField tx2;
    @FXML
    private Button sesion;
    @FXML
    private Button regis;
    
    @FXML
    private AnchorPane WindowLogin;

    private Conexion conexion;
    @FXML
    private Button exit;
    @Override
    public void initialize(URL url, ResourceBundle rb){
        conexion=new Conexion();
        MetodosChangeWindow metodo = new MetodosChangeWindow();
        
        sesion.setOnAction((ActionEvent event) -> {
            if(tx1.getText().equals("comprador") && tx2.getText().equals("compra")){
                try{
                    metodo.ChangeWindow("VentanaComprador", WindowLogin,"Customer");
                    
                }catch(IOException e){
                    System.out.println("No se puede abrir la ventana");
                }
            }
            else if(tx1.getText().equals("vendedor") && tx2.getText().equals("vende")){
                try{
                    metodo.ChangeWindow("VentanaVendedor", WindowLogin,"Seller");
                }catch(IOException e){
                    System.out.println("No se puede abrir la ventana");
                }
            }
            else if(tx1.getText().equals("administra") && tx2.getText().equals("admi")){
                try{
                    metodo.ChangeWindow("VentanaAdministrador", WindowLogin,"Administrator");
                }catch(IOException e){
                    System.out.println("No se puede abrir la ventana");
                }
            }
            else{
                System.out.println("Usuario/Contraseña incorrecta");
            }
        });
        
        regis.setOnAction((ActionEvent event) -> {
            try{
                metodo.getVent("VentanaRegistro", "Register");
            }catch(IOException e){
                System.out.println("No se puede abrir la ventana");
            }
        });
        exit.setOnAction((ActionEvent e) -> {
            try {
                conexion.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(VentanaSesionController.class.getName()).log(Level.SEVERE, null, ex);
            }
            DSProyecto.getStage(WindowLogin, "").close();
        });
            
    }    
    
}
