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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import pi.entities.Hotel;
import pi.sevices.HotelCRUD;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author msallem
 */
public class ModifierHotelController implements Initializable {

    @FXML
    private Label welcome;
    @FXML
    private TextField nom_hotel;
    @FXML
    private Button A;
    @FXML
    private Hyperlink prec;
    @FXML
    private TextField nbchambre;
    @FXML
    private TextField nbrestaurant;
    @FXML
    private TextField nbpiscine;
    @FXML
    private TextField adresse_rest;
    @FXML
    private TextField villehotel;
    @FXML
    private ComboBox<String> nbetoile;
    @FXML
    private Label labelid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         nbetoile.getItems().add("1");
        nbetoile.getItems().add("2");
        nbetoile.getItems().add("3");
        nbetoile.getItems().add("4");
        nbetoile.getItems().add("5");
        
        
             nom_hotel.setText(AfficherHotelController.connectedHotel.getNom_hotel());
         

        labelid.setText(Integer.toString(AfficherHotelController.connectedHotel.getIdhotel()));
        
         adresse_rest.setText(AfficherHotelController.connectedHotel.getAdresse_rest());
                  villehotel.setText(AfficherHotelController.connectedHotel.getVillehotel());

        nbchambre.setText(Integer.toString((int) AfficherHotelController.connectedHotel.getNbchambre()));
     
             nbrestaurant.setText(Integer.toString((int) AfficherHotelController.connectedHotel.getNbrestaurant()));
        nbpiscine.setText(Integer.toString((int) AfficherHotelController.connectedHotel.getNbpiscine()));
        nbetoile.setValue(Integer.toString((int) AfficherHotelController.connectedHotel.getNbetoile()));

        
        
        
    }    

    @FXML
    private void insert(ActionEvent event) throws IOException {
          HotelCRUD productService = new HotelCRUD();

      if (this.nom_hotel.getText().equals("")
                || adresse_rest.getText().equals("")
                || villehotel.getText().equals("")) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Please fill all fields ");
            a.setHeaderText(null);
            a.showAndWait();} 
            
      Hotel h1= new Hotel(Integer.parseInt(labelid.getText()),nom_hotel.getText(),Integer.parseInt(nbetoile.getValue()),
              Integer.parseInt(nbchambre.getText()),Integer.parseInt(nbrestaurant.getText()),
              Integer.parseInt(nbpiscine.getText()),
              adresse_rest.getText(),villehotel.getText())      ;
              
         productService.modifierHotel(h1);
           
                  Parent page1 = FXMLLoader.load(getClass().getResource("AfficherHotel.fxml"));
        Scene scene = new Scene(page1, 1236, 785);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Liste des Hotels");
        stage.setScene(scene);
        stage.show();
        
           TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle("Vous avez Ajouté un nouveau Hotel");
            tray.setMessage("");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(3000));
        
        
        
    }

    @FXML
    private void prec(ActionEvent event) {
    }
    
}
