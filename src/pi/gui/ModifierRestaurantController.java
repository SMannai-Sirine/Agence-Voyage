/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import pi.entities.Restaurant;
import pi.sevices.restaurantCRUD;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author fares
 */
public class ModifierRestaurantController implements Initializable {

    @FXML
    private Label welcome;
    @FXML
    private TextField nom_rest;
    @FXML
    private Button A;
    @FXML
    private Hyperlink prec;
    @FXML
    private TextField numtel_rest;
    @FXML
    private TextField adresse_rest;
    @FXML
    private TextField ville_rest;
    @FXML
    private TextField nbtable_rest;
    @FXML
    private TextField type_rest;
    @FXML
    private Label labelid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                nom_rest.setText(AfficherRestaurantController.connectedrestau.getNom_rest());
         

        labelid.setText(Integer.toString(AfficherRestaurantController.connectedrestau.getId_rest()));
        
         adresse_rest.setText(AfficherRestaurantController.connectedrestau.getAdresse_rest());
                  ville_rest.setText(AfficherRestaurantController.connectedrestau.getVille_rest());
                  type_rest.setText(AfficherRestaurantController.connectedrestau.getType_rest());

     
             numtel_rest.setText(Integer.toString((int) AfficherRestaurantController.connectedrestau.getNumtel_rest()));
        nbtable_rest.setText(Integer.toString((int) AfficherRestaurantController.connectedrestau.getNbtable_rest()));

        
        
        
    }    

    @FXML
    private void insert(ActionEvent event) throws IOException {
         restaurantCRUD cs = new restaurantCRUD();
          if (this.nom_rest.getText().equals("")
                || adresse_rest.getText().equals("")
                || ville_rest.getText().equals("")) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Please fill all fields ");
            a.setHeaderText(null);
            a.showAndWait();} 
         
         
         
         
         Restaurant r1 = new Restaurant(Integer.parseInt(labelid.getText()),nom_rest.getText(),Integer.parseInt(this.numtel_rest.getText()),
       adresse_rest.getText(),this.ville_rest.getText(), Integer.parseInt(this.nbtable_rest.getText())
        ,type_rest.getText());
        cs.modifierRestaurant(r1);
                  Parent page1 = FXMLLoader.load(getClass().getResource("AfficherRestaurant.fxml"));
        Scene scene = new Scene(page1, 1236, 785);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Liste des Restaurants");
        stage.setScene(scene);
        stage.show();
        
           TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle("Restaurant Modifié avec succées");
            tray.setMessage("");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(3000));
        
        
        
    }

    @FXML
    private void prec(ActionEvent event) throws IOException {
            Parent page1 = FXMLLoader.load(getClass().getResource("AfficherRestaurant.fxml"));
        Scene scene = new Scene(page1, 1236, 785);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Liste des Restaurants");
        stage.setScene(scene);
        stage.show();
    }
    
}
