/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproyecto;

import dsproyecto.DSProyecto;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Usuario
 */
public class MetodosChangeWindow {
    public void ChangeWindow(String nameWindow, Pane PaneWindow,String title) throws IOException {
        Parent parent;
        parent = FXMLLoader.load(getClass().getResource(nameWindow+".fxml"));
        DSProyecto.getStage(PaneWindow,title).setScene(new Scene(parent));
    }
    
    public void getVent(String NameWindow, String TitleWindow) throws IOException {
        Stage stagelog = new Stage();
        Parent windowlog = FXMLLoader.load(getClass().getResource(NameWindow + ".fxml"));
        stagelog.setScene(new Scene(windowlog));
        stagelog.setTitle(TitleWindow);
        stagelog.show();
    }
    
    public static void alarm(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Mensaje de Informacion");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
