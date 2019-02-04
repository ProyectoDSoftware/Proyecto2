/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import Modelo.Usuario;

/**
 *
 * @author Alex Macas
 */
public class TableUsuario {
    private TableView<Usuario> tablaUsuario;
    
    private TableColumn<Usuario,String> rol;
    private TableColumn<Usuario,String> nombre;
    private TableColumn<Usuario,String> apellido;
    private TableColumn<Usuario,String> telefono;
    private TableColumn<Usuario,String> email;
    private TableColumn<Usuario,String> direccion;
    private TableColumn<Usuario,String> cedula;

    private ObservableList<Usuario> datos;
    public TableUsuario(TableView<Usuario>tabla){
        tablaUsuario=tabla;
        tablaUsuario.setEditable(true);
        setColumnas();
    }
    private void setColumnas(){
        nombre=new TableColumn("Nombre");
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        nombre.setCellFactory(TextFieldTableCell.forTableColumn());
        apellido=new TableColumn("Apellido");
        apellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        telefono=new TableColumn("Teléfono");
        telefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        rol=new TableColumn("Rol");
        rol.setCellValueFactory(new PropertyValueFactory<>("rol"));
        email=new TableColumn("Email");
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        direccion=new TableColumn("Dirección");
        direccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        cedula=new TableColumn("Cédula");
        cedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        tablaUsuario.getColumns().addAll(nombre,apellido,cedula,telefono,direccion,email,rol);
    }
    public void setInicializar(ArrayList<Usuario> empleado){
        datos=FXCollections.observableArrayList(empleado);
        tablaUsuario.setItems(datos);
    }
    public TableView<Usuario> getTable(){
        return tablaUsuario;
    }
   
    
    
}
