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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class VentanaVendedorController implements Initializable {

    @FXML
    private MenuItem opcSimple;
    @FXML
    private MenuItem opcPedido;
    @FXML
    private MenuItem moreSearch;
    @FXML
    private MenuItem opcVenta;
    @FXML
    private MenuItem opcArticulos;
    @FXML
    private MenuItem exit;
    @FXML
    private BorderPane search;
    @FXML
    private BorderPane pedidos;
    @FXML
    private BorderPane articulos;
    @FXML
    private BorderPane ventas;
    @FXML
    private AnchorPane productos;
    @FXML
    private Button btnArticulo;

    private Stage stageArticulo;
    private Parent ventArticulo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        opcSimple.setOnAction((ActionEvent event) -> {
            search.setVisible(true);
            pedidos.setVisible(false);
            articulos.setVisible(false);
            ventas.setVisible(false);
            productos.setVisible(false);
        });
        
        opcPedido.setOnAction((ActionEvent event) -> {
            search.setVisible(false);
            pedidos.setVisible(true);
            articulos.setVisible(false);
            ventas.setVisible(false);
            productos.setVisible(false);
        });
        
        moreSearch.setOnAction((ActionEvent event) -> {
            search.setVisible(false);
            pedidos.setVisible(false);
            articulos.setVisible(true);
            ventas.setVisible(false);
            productos.setVisible(false); 
        });
        
        opcVenta.setOnAction((ActionEvent event) -> {
            search.setVisible(false);
            pedidos.setVisible(false);
            articulos.setVisible(false);
            ventas.setVisible(true);
            productos.setVisible(false); 
        });
        
        opcArticulos.setOnAction((ActionEvent event) -> {
            search.setVisible(false);
            pedidos.setVisible(false);
            articulos.setVisible(false);
            ventas.setVisible(false);
            productos.setVisible(true); 
        });
        
        btnArticulo.setOnAction((ActionEvent event) -> {
            try {
                getRegistroArticulo();
            } catch (IOException ex) {
                System.out.println("No se puede abrir la ventana");
            }
        });
    }

public void getRegistroArticulo() throws IOException{
        stageArticulo = new Stage();
        stageArticulo.setTitle("Nuevo Artículo");
        ventArticulo = FXMLLoader.load(getClass().getResource("VentanaArticulo.fxml"));
        stageArticulo.setScene(new Scene(ventArticulo));
        stageArticulo.show();
    }    
    
}