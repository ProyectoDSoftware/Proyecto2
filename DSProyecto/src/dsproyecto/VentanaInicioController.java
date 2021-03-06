/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproyecto;

import modelo.Articulo;
import modelo.Conexion;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
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
    
    private Conexion conexion;
    @FXML
    private TableView<Articulo> tableMasBuscados;
    @FXML
    private TableView<Articulo> tableNuevoArticulo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conexion=new Conexion();
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
