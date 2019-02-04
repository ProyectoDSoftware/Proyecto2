/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import modelo.Articulo;
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
    private final TableView<Articulo> tablaArticulo;
    
    private TableColumn<Articulo,String> nombre;
    private TableColumn<Articulo,String> categoria;
    private TableColumn<Articulo,Integer> calificacion;
    private TableColumn<Articulo,Double> precio;

    private ObservableList<Articulo> datos;
    public TablaArticulo(TableView<Articulo>tabla){
        tablaArticulo=tabla;
        tablaArticulo.setEditable(true);
        setColumnas();
    }
    private void setColumnas(){
        tablaArticulo.getColumns().addAll(crearTablaNombre(),crearTablaCategoria(),crearTablaCalificacion(),crearTablaPrecio());
    }
    public void setInicializar(ArrayList<Articulo> articulos){
        datos=FXCollections.observableArrayList(articulos);
        tablaArticulo.setItems(datos);
    }
    public TableView<Articulo> getTable(){
        return tablaArticulo;
    }
     public TableColumn crearTablaNombre() {
        nombre=new TableColumn("Nombre");
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        nombre.setCellFactory(TextFieldTableCell.forTableColumn());
        return nombre;
    }
    public TableColumn crearTablaCategoria() {
        categoria=new TableColumn("Categoría");
        categoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        return categoria;
    }
    
     public TableColumn crearTablaCalificacion() {
        calificacion=new TableColumn("Calificación");
        calificacion.setCellValueFactory(new PropertyValueFactory<>("calificacion"));
        return calificacion;
    }
      public TableColumn crearTablaPrecio() {
        precio=new TableColumn("Precio");
        precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        return precio;
    }
       
}
