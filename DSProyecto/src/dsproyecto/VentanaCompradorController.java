/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproyecto;

import modelo.Articulo;
import modelo.Conexion;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import tablas.TablaArticulo;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class VentanaCompradorController implements Initializable {

    @FXML
    private MenuItem opcSimple;
    @FXML
    private MenuItem opcPedido;
    @FXML
    private MenuItem moreSearch;
    @FXML
    private MenuItem exit;
    @FXML
    private BorderPane search;
    @FXML
    private BorderPane pedidos;
    @FXML
    private BorderPane articulos;
    @FXML
    private AnchorPane PaneClient;

    private Conexion conexion;
    @FXML
    private TableView<Articulo> tablearticulo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conexion=new Conexion();
        opcSimple.setOnAction((ActionEvent event) -> {
            search.setVisible(true);
            pedidos.setVisible(false);
            articulos.setVisible(false);
        });
        
        opcPedido.setOnAction((ActionEvent event) -> {
            pedidos.setVisible(true);
            search.setVisible(false);
            articulos.setVisible(false);
        });
        
        moreSearch.setOnAction((ActionEvent event) -> {
            articulos.setVisible(true);
            search.setVisible(false);
            pedidos.setVisible(false);
            ArrayList<Articulo> art=conexion.selectArticuloMasBuscado(conexion.getConnection(),"ArticulosMasBuscados");
            InicializarTable(tablearticulo, art);
        });
        
        exit.setOnAction((ActionEvent e) ->{
            DSProyecto.getStage(PaneClient,"").close();
        });
    }    
    
    private void InicializarTable(TableView<Articulo>tabla,ArrayList<Articulo>art){
        TablaArticulo table=new TablaArticulo(tabla);
        table.setInicializar(art);
    }
}
