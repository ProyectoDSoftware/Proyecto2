/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproyecto;

import Modelo.Conexion;
import Modelo.Usuario;
import Modelo.Constants;
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
            if(this.validarText()){
                try {
                    verificar(metodo);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaSesionController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                MetodosChangeWindow.alarm("Intente de nuevo");
            }
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
    
    private boolean validarText() {
        return !(tx1.getText().equals("") || tx2.getText().equals(""));
    }
    
    private void verificar(MetodosChangeWindow metodo) throws IOException{
        Usuario users=conexion.selectUsuario(conexion.getConnection(),tx1.getText());
        if(users.getUsuario().equalsIgnoreCase(Constants.PRUEBA)){
            MetodosChangeWindow.alarm("el usuario no esta registrado");
        }
        else if(users.getRol().equalsIgnoreCase(Constants.EMPLE) && users.getContraseña().equalsIgnoreCase(tx2.getText()) && users.getDisponible()==Constants.ESTADO){
            metodo.ChangeWindow("VentanaComprador", WindowLogin,"Customer");
        }else if(users.getRol().equalsIgnoreCase(Constants.ADMIN) &&  users.getContraseña().equalsIgnoreCase(tx2.getText()) && users.getDisponible()==Constants.ESTADO){
            metodo.ChangeWindow("VentanaVendedor", WindowLogin,"Seller");
        }else{
            metodo.alarm("el usuario o la contraseña estan incorrectas");
        }
    }
}
