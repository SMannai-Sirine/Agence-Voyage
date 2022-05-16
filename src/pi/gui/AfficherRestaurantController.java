/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;
import pi.entities.Hotel;
import pi.entities.Restaurant;
import pi.sevices.HotelCRUD;
import pi.sevices.restaurantCRUD;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author msallem
 */
public class AfficherRestaurantController implements Initializable {

    @FXML
    private TextField inputRech;
    @FXML
    private Button supp;
    @FXML
    private Button supp1;
    @FXML
    private Button Ajouter;
    @FXML
    private TableView<Restaurant> tableview;
    @FXML
    private TableColumn<?, ?> nom_rest;
    @FXML
    private TableColumn<?, ?> adresse_rest;
    @FXML
    private TableColumn<?, ?> numtel_rest;
    @FXML
    private TableColumn<?, ?> ville_rest;
    @FXML
    private TableColumn<?, ?> nbtable_rest;
    @FXML
    private TableColumn<?, ?> type_rest;
public ObservableList<Restaurant> list;
 public static Restaurant connectedrestau;
restaurantCRUD cs = new restaurantCRUD();
    @FXML
    private Hyperlink hot;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            restaurantCRUD pss = new restaurantCRUD();
        ArrayList<Restaurant> c = new ArrayList<>();
        try {
            c = (ArrayList<Restaurant>) pss.afficherRestaurantss2();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherRestaurantController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ObservableList<Restaurant> obs2 = FXCollections.observableArrayList(c);
         tableview.setItems(obs2);
        
       // id_rest.setCellValueFactory(new PropertyValueFactory<>("id_rest"));
        nom_rest.setCellValueFactory(new PropertyValueFactory<>("nom_rest"));
        adresse_rest.setCellValueFactory(new PropertyValueFactory<>("adresse_rest"));
        numtel_rest.setCellValueFactory(new PropertyValueFactory<>("numtel_rest"));
        ville_rest.setCellValueFactory(new PropertyValueFactory<>("ville_rest"));
        nbtable_rest.setCellValueFactory(new PropertyValueFactory<>("nbtable_rest"));
        type_rest.setCellValueFactory(new PropertyValueFactory<>("type_rest"));
         
//        nom_rest.setCellValueFactory(new PropertyValueFactory<>("nom"));
//        adresse_rest.setCellValueFactory(new PropertyValueFactory<>("adresse"));
//        numtel_rest.setCellValueFactory(new PropertyValueFactory<>("num_tel"));
//        ville_rest.setCellValueFactory(new PropertyValueFactory<>("ville"));
//        nbtable_rest.setCellValueFactory(new PropertyValueFactory<>("nb_table"));
//        type_rest.setCellValueFactory(new PropertyValueFactory<>("type"));
        
        
            try {
            list = FXCollections.observableArrayList(
                    pss.afficherRestaurantss2()
            );        
        
        
   FilteredList<Restaurant> filteredData = new FilteredList<>(list, e -> true);
            inputRech.setOnKeyReleased(e -> {
                inputRech.textProperty().addListener((ObservableValue, oldValue, newValue) -> {
                    filteredData.setPredicate((Predicate<? super Restaurant>) Restaurants -> {
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        String lower = newValue.toLowerCase();
                        if (Restaurants.getNom_rest().toLowerCase().contains(lower)) {
                            return true;
                        }

                        return false;
                    });
                });
                SortedList<Restaurant> sortedData = new SortedList<>(filteredData);
                sortedData.comparatorProperty().bind(tableview.comparatorProperty());
                tableview.setItems(sortedData);
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }    

    
     public void resetTableData() throws SQLDataException, SQLException {

        List<Restaurant> listevents = new ArrayList<>();
        listevents = cs.afficherRestaurantss2();
        ObservableList<Restaurant> data = FXCollections.observableArrayList(listevents);
        tableview.setItems(data);
    }    
    
    @FXML
    private void supp(ActionEvent event) throws SQLException {
           if (event.getSource() == supp) {
            Restaurant e = new Restaurant();
            e.setId_rest(tableview.getSelectionModel().getSelectedItem().getId_rest());  
            restaurantCRUD cs = new restaurantCRUD();
            cs.supprimerRestaurant(e);
            resetTableData();  
        
               TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle("Vous avez Supprimé un RESTAURANT");
            tray.setMessage("");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(3000));
        
    }  
        
        
    }

    @FXML
    private void Modif(ActionEvent event) throws IOException {
          restaurantCRUD ps = new restaurantCRUD();

        Restaurant c = new Restaurant(tableview.getSelectionModel().getSelectedItem().getId_rest(),
                tableview.getSelectionModel().getSelectedItem().getNom_rest(),
                tableview.getSelectionModel().getSelectedItem().getNumtel_rest(),
                 tableview.getSelectionModel().getSelectedItem().getAdresse_rest(),
                tableview.getSelectionModel().getSelectedItem().getVille_rest(),
               tableview.getSelectionModel().getSelectedItem().getNbtable_rest(),
                tableview.getSelectionModel().getSelectedItem().getType_rest()  );
                   
              
        AfficherRestaurantController.connectedrestau = c;
        
             Parent page1 = FXMLLoader.load(getClass().getResource("ModifierRestaurant.fxml"));
        Scene scene = new Scene(page1, 1144, 741);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
         
        
        
        
        
    }

    @FXML
    private void Ajouter(ActionEvent event) throws IOException {
       Parent page1 = FXMLLoader.load(getClass().getResource("AjouterRestaurant.fxml"));
        Scene scene = new Scene(page1, 805, 716);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Ajouter un Restaurant");
        stage.setScene(scene);
        stage.show();
           
        
        
    }

    @FXML
    private void hot(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("AfficherHotel.fxml"));
        Scene scene = new Scene(page1, 1236, 785);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Gestion des Hotels");
        stage.setScene(scene);
        stage.show();  
        
        
        
    }
    
}
