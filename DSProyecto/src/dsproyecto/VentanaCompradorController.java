/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproyecto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        });
        
        exit.setOnAction((ActionEvent e) ->{
            DSProyecto.getStage(PaneClient,"").close();
        });
    }    
    
}
