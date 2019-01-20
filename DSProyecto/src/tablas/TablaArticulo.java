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
public class TablaArticulo {
    private TableView<Articulo> tablaArticulo;
    
    private TableColumn<Articulo,String> nombre;
    private TableColumn<Articulo,String> categoria;
    private TableColumn<Articulo,Integer> calificacion;
    private TableColumn<Articulo,Double> precio;

    private ObservableList<Articulo> datos;
    public TablaArticulo(){
        tablaArticulo=new TableView();
        tablaArticulo.setEditable(true);
        setColumnas();
    }
    private void setColumnas(){
        nombre=new TableColumn("Nombre");
        nombre.setMinWidth(100);
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        nombre.setCellFactory(TextFieldTableCell.forTableColumn());
        categoria=new TableColumn("Categoría");
        categoria.setMinWidth(100);
        categoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        calificacion=new TableColumn("Calificación");
        calificacion.setMinWidth(100);
        calificacion.setCellValueFactory(new PropertyValueFactory<>("calificacion"));
        precio=new TableColumn("Precio");
        precio.setMinWidth(100);
        precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        tablaArticulo.getColumns().addAll(nombre,categoria,calificacion,precio);
    }
    public void setInicializar(ArrayList<Articulo> articulos){
        datos=FXCollections.observableArrayList(articulos);
        tablaArticulo.setItems(datos);
    }
    public TableView<Articulo> getTable(){
        return tablaArticulo;
    }
}
