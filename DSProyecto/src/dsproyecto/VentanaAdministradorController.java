/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproyecto;

import Modelo.Articulo;
import Modelo.Conexion;
import Modelo.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tablas.TablaArticulo;
import tablas.TableUsuario;

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

    @FXML
    private AnchorPane AdminGeneral;
    @FXML
    private Button deleteUser;
    @FXML
    private Button modifUser;
    @FXML
    private Button btnsearch;
    @FXML
    private TableView<Usuario> tableUser;
    @FXML
    private Button deleteprod;
    @FXML
    private Button modifproduct;
    @FXML
    private TableView<Articulo> tableproduct;
    
    private Conexion conexion;
    @FXML
    private TextField txfnombre;
    @FXML
    private Button btnArticle;
    @FXML
    private TextField txfarticle;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conexion=new Conexion();
        MetodosChangeWindow metodo = new MetodosChangeWindow();
        TableUsuario table=new TableUsuario(tableUser);
        TablaArticulo tableart=new TablaArticulo(tableproduct);
        usuarios.setOnAction((ActionEvent event) -> {
            admiUser.setVisible(true);
            admiProd.setVisible(false);
        });
        
        btnsearch.setOnAction((ActionEvent event)->{
            ArrayList<Usuario> art=conexion.getBuscarUsuarios(conexion.getConnection(), txfnombre.getText());
            table.setInicializar(art);
        });
        articulos.setOnAction((ActionEvent event) -> {
            admiProd.setVisible(true);
            admiUser.setVisible(false);
        });
        btnArticle.setOnAction((ActionEvent event)->{
            ArrayList<Articulo> art=conexion.getBuscarArticulos(conexion.getConnection(), txfarticle.getText());
            tableart.setInicializar(art);
        });
        newUser.setOnAction((ActionEvent event) -> {
            try{
                metodo.getVent("VentanaRegistro", "Register");
            }catch(IOException e){
                MetodosChangeWindow.alarm("No se puede abrir la ventana");
            }
        });
        newProduc.setOnAction((ActionEvent event) ->{
            try{
                metodo.getVent("VentanaArticulo", "Register Article");
            }catch(IOException e){
                MetodosChangeWindow.alarm("No se puede abrir la ventana");
            }
        });
        
        exit.setOnAction((ActionEvent e) ->{
            DSProyecto.getStage(AdminGeneral,"").close();
        });
    }
   private void InicializarTableUser(TableView<Usuario>tabla,ArrayList<Usuario>art){
        TableUsuario table=new TableUsuario(tabla);
        table.setInicializar(art);
    }
}
