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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class VentanaInicioController implements Initializable {

    @FXML
    private Button log;
    @FXML
    private Button reg;

    @FXML
    private AnchorPane PaneInit;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MetodosChangeWindow metodo = new MetodosChangeWindow();
        log.setOnAction((ActionEvent event) -> {
            try {
                metodo.getVent("VentanaSesion", "Login");
            } catch (IOException ex) {
                System.out.println("Error en applicacion intente de nuevo u otra acción");
            }
        });
        
        reg.setOnAction((ActionEvent event) -> {
            try {
                metodo.getVent("VentanaRegistro", "Register");
            } catch (IOException ex) {
                System.out.println("Error en applicacion intente de nuevo u otra acción");
            }
        });
    }    
 
}
