/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import Modelo.Articulo;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 *
 * @author Usuario
 */
public class TablaArticuloNuevo {
    private TableView<Articulo> tablaArticulo;
    
    private TableColumn<Articulo,String> nombre;
    private TableColumn<Articulo,String> categoria;

    private ObservableList<Articulo> datos;
    public TablaArticuloNuevo(){
        tablaArticulo=new TableView();
        tablaArticulo.setEditable(true);
        setColumnas();
    }
    private void setColumnas(){
        nombre=new TableColumn("Nombre");
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        nombre.setCellFactory(TextFieldTableCell.forTableColumn());
        categoria=new TableColumn("Categoría");
        categoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        tablaArticulo.getColumns().addAll(nombre,categoria);
    }
    public void setInicializar(ArrayList<Articulo> articulos){
        datos=FXCollections.observableArrayList(articulos);
        tablaArticulo.setItems(datos);
    }
    public TableView<Articulo> getTable(){
        return tablaArticulo;
    }
}
