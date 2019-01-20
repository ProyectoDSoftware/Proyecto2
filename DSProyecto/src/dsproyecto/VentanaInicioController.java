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

    private Parent ventlog,ventreg;
    private Stage stagelog,stagereg;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        log.setOnAction((ActionEvent event) -> {
            try {
                getVentLogin();
            } catch (IOException ex) {
                System.out.println("Error en applicacion intente de nuevo u otra acción");
            }
        });
        
        reg.setOnAction((ActionEvent event) -> {
            try {
                getVentRegistro();
            } catch (IOException ex) {
                System.out.println("Error en applicacion intente de nuevo u otra acción");
            }
        });
    }    
    
    public void getVentLogin() throws IOException {
        stagelog = new Stage();
        ventlog = FXMLLoader.load(getClass().getResource("VentanaSesion.fxml"));
        stagelog.setScene(new Scene(ventlog));
        stagelog.show();
    }
    
    public void getVentRegistro() throws IOException {
        stagereg = new Stage();
        ventreg = FXMLLoader.load(getClass().getResource("VentanaRegistro.fxml"));
        stagereg.setScene(new Scene(ventreg));
        stagereg.show();
    }
}
