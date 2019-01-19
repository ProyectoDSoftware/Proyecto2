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
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class VentanaAdministradorController implements Initializable {

    @FXML
    private MenuItem usuarios;
    @FXML
    private MenuItem articulos;
    @FXML
    private MenuItem exit;
    @FXML
    private AnchorPane admiUser;
    @FXML
    private AnchorPane admiProd;
    @FXML
    private Button newUser;
    @FXML
    private Button newProduc;

    private Stage stageNewUser, stageNewProduc;
    private Parent ventNewUser, ventNewProduc;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usuarios.setOnAction((ActionEvent event) -> {
            admiUser.setVisible(true);
            admiProd.setVisible(false);
        });
        
        articulos.setOnAction((ActionEvent event) -> {
            admiProd.setVisible(true);
            admiUser.setVisible(false);
        });
        newUser.setOnAction((ActionEvent event) -> {
            try{
                getVentRegisUser();
            }catch(IOException e){
                System.out.println("No se puede abrir la ventana");
            }
        });
        newProduc.setOnAction((ActionEvent event) ->{
            try{
                getVentRegisProduc();
            }catch(IOException e){
                System.out.println("No se puede abrir la ventana");
            }
        });
    }

    public void getVentRegisUser() throws IOException{
        stageNewUser = new Stage();
        stageNewUser.setTitle("Registro de Usuario");
        ventNewUser = FXMLLoader.load(getClass().getResource("VentanaRegistro.fxml"));
        stageNewUser.setScene(new Scene(ventNewUser));
        stageNewUser.show();
    }
    
    public void getVentRegisProduc() throws IOException{
        stageNewProduc = new Stage();
        stageNewProduc.setTitle("Registro de Articulo");
        ventNewProduc = FXMLLoader.load(getClass().getResource("VentanaArticulo.fxml"));
        stageNewProduc.setScene(new Scene(ventNewProduc));
        stageNewProduc.show();
    }
}
