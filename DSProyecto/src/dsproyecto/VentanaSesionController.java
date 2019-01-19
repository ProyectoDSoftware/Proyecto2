/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproyecto;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class VentanaSesionController implements Initializable {

    @FXML
    private TextField tx1;
    @FXML
    private TextField tx2;
    @FXML
    private Button sesion;
    @FXML
    private Button regis;
    
    private Parent ventComp, ventVend, ventAdmi, ventReg;
    
    private Stage stageComp, stageVend, stageAdmi, stageReg;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        sesion.setOnAction((ActionEvent event) -> {
            if(tx1.getText().equals("comprador") && tx2.getText().equals("compra")){
                try{
                    getVentComp();
                }catch(IOException e){
                    System.out.println("No se puede abrir la ventana");
                }
            }
            else if(tx1.getText().equals("vendedor") && tx2.getText().equals("vende")){
                try{
                    getVentVend();
                }catch(IOException e){
                    System.out.println("No se puede abrir la ventana");
                }
            }
            else if(tx1.getText().equals("administra") && tx2.getText().equals("admi")){
                try{
                    getVentAdmi();
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
                getRegistro();
            }catch(IOException e){
                System.out.println("No se puede abrir la ventana");
            }
        });
    }    
    
    public void getVentComp() throws IOException{
        stageComp = new Stage();
        stageComp.setTitle("Ventana Comprador");
        ventComp = FXMLLoader.load(getClass().getResource("VentanaComprador.fxml"));
        stageComp.setScene(new Scene(ventComp));
        stageComp.show();
    }
    
    public void getVentVend() throws IOException{
        stageVend = new Stage();
        stageVend.setTitle("Ventana Vendedor");
        ventVend = FXMLLoader.load(getClass().getResource("VentanaVendedor.fxml"));
        stageVend.setScene(new Scene(ventVend));
        stageVend.show();
    }
    
    public void getVentAdmi() throws IOException{
        stageAdmi = new Stage();
        stageAdmi.setTitle("Ventana Administrador");
        ventAdmi = FXMLLoader.load(getClass().getResource("VentanaAdministrador.fxml"));
        stageAdmi.setScene(new Scene(ventAdmi));
        stageAdmi.show();
    }
    
    public void getRegistro() throws IOException{
        stageReg = new Stage();
        stageReg.setTitle("Registro");
        ventReg = FXMLLoader.load(getClass().getResource("VentanaRegistro.fxml"));
        stageReg.setScene(new Scene(ventReg));
        stageReg.show();
    }
    
    public void getClosedComprador(){
        stageComp.hide();
    }
    
    public void getClosedVendedor(){
        stageVend.hide();
    }
    
    public void getClosedAdministra(){
        stageAdmi.hide();
    }
}
