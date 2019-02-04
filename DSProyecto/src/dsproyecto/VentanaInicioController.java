/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproyecto;

import Modelo.Articulo;
import Modelo.ConexionDB;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tablas.TablaMasBuscados;

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
    
    private ConexionDB conexion;
    @FXML
    private TableView<Articulo> tableMasBuscados;
    @FXML
    private TableView<Articulo> tableNuevoArticulo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conexion=new ConexionDB();
        MetodosChangeWindow metodo = new MetodosChangeWindow();
        ArrayList<Articulo> art=conexion.selectArticuloMasBuscado(conexion.getConnection(),"ArticulosMasBuscados");
        InicializarTabla(tableMasBuscados, art);
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
 
    private void InicializarTabla(TableView<Articulo>tabla,ArrayList<Articulo>art){
        TablaMasBuscados table=new TablaMasBuscados(tabla);
        table.setInicializar(art);
    }
}
