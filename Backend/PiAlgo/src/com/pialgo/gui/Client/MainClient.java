/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Client;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Sémia
 */
public class MainClient extends Application {
    
    @Override
   public void start(Stage stage) throws Exception {
       
        Parent root = FXMLLoader.load(getClass().getResource("ClientAccueil.fxml"));
        Scene scene = new Scene(root);
        //stage.setTitle("Ajouter un vol");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
