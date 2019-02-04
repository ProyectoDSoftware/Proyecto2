/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproyecto;

import Modelo.Articulo;
import Modelo.ConexionDB;
import Modelo.Constants;
import Modelo.Usuario;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class VentanaRegistroController implements Initializable {

    @FXML
    private Button regist;
    @FXML
    private Button clear;
    @FXML
    private Button cancel;
    @FXML
    private AnchorPane paneRegister;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtCed;
    @FXML
    private TextField txtTelephone;
    @FXML
    private TextField txtDirection;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtUser;
    @FXML
    private ComboBox<String> tipWhassapt;
    @FXML
    private ComboBox<String> tipUser;
    @FXML
    private TextField txtPassword;

    private ConexionDB conexion;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        conexion=new ConexionDB();
        llenarComboBox();
        cancel.setOnAction((ActionEvent e)->{
            try {
                conexion.cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error");
            }
            DSProyecto.getStage(paneRegister,"").close();
        });
        clear.setOnAction((ActionEvent e)->{
            limpia();
        });
        regist.setOnAction((ActionEvent e)->{
            if(Verificar()){
                MetodosChangeWindow.alarm("Campo incompleto");
            }else{
                Usuario usuarionuevo=new Usuario(numrol(tipUser.getValue()), txtUser.getText(),txtPassword.getText(),txtName.getText(), txtLastName.getText(), txtTelephone.getText(),txtEmail.getText(), numerowhas(tipWhassapt.getValue()), txtDirection.getText(), txtCed.getText(), 1);
                conexion.insertDataBaseUser(conexion.getConnection(), usuarionuevo.toString());
                limpia();
                MetodosChangeWindow.alarm("Registro completo");
                
            }
        });
    }    
    private void llenarComboBox(){
        ObservableList<String> rol=FXCollections.observableArrayList(Constants.ADMIN,Constants.VENDE,Constants.COMPRA);
        tipUser.setItems(rol);
        tipUser.getSelectionModel().selectFirst();
        ObservableList<String> whassap=FXCollections.observableArrayList("Si","No");
        tipWhassapt.setItems(whassap);
        tipWhassapt.getSelectionModel().selectFirst();
    }
    private boolean Verificar(){
        final boolean Emptyname=txtName.getText().isEmpty();
        final boolean Emptylastna=txtLastName.getText().isEmpty();
        final boolean Emptycedu=txtCed.getText().isEmpty();
        final boolean Emptydirec=txtDirection.getText().isEmpty();
        final boolean Emptytelep=txtTelephone.getText().isEmpty();
        final boolean Emptyemai=txtEmail.getText().isEmpty();
        final boolean Emptyuser=txtUser.getText().isEmpty();
        final boolean Emptypass=txtPassword.getText().isEmpty();
        final boolean emptyvase=Emptycedu||Emptydirec||Emptyemai||Emptylastna||Emptyname||Emptypass||Emptytelep||Emptyuser;
        if(emptyvase){
           return true;
        }
        return false;
    }
    private boolean numerowhas(String valor){
        if(valor.equalsIgnoreCase("Si")){
            return true;
        }
        return false;
    }
    private String numrol(String rol){
        final boolean admi=rol.equalsIgnoreCase("administrador");
        final boolean vend=rol.equalsIgnoreCase("vendedor");
        if(admi){
            return "1";
        }else if(vend){
            return "2";
        }
        return "3";
    }
    
    private void limpia(){
        txtName.setText("");
        txtCed.setText("");
        txtDirection.setText("");
        txtEmail.setText("");
        txtLastName.setText("");
        txtPassword.setText("");
        txtUser.setText("");
        txtTelephone.setText("");
    }
}
