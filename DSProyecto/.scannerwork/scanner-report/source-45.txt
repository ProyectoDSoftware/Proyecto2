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
public class TablaMasBuscados {
    private final TableView<Articulo> tablaArticulo;
    
    private TableColumn<Articulo,String> nombre;
    private TableColumn<Articulo,Double> precio;

    private ObservableList<Articulo> datos;
    public TablaMasBuscados(TableView<Articulo>tabla){
        this.tablaArticulo=tabla;
        tablaArticulo.setEditable(true);
        setColumnas();
    }

    private void setColumnas(){
        nombre=new TableColumn("Nombre");
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        nombre.setCellFactory(TextFieldTableCell.forTableColumn());
        precio=new TableColumn("Precio");
        precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        tablaArticulo.getColumns().addAll(nombre,precio);
    }
    public void setInicializar(ArrayList<Articulo> articulos){
        datos=FXCollections.observableArrayList(articulos);
        tablaArticulo.setItems(datos);
    }
    public TableView<Articulo> getTable(){
        return tablaArticulo;
    }
}
