/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Admin;

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
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author iHoussem
 */
public class AdminAcceuilController implements Initializable {

    @FXML
    private Button btnPays;
    @FXML
    private Button btnReservation;
    @FXML
    private Button btnVoitures;
    @FXML
    private Button btnTaxi;
    @FXML
    private Button btnRetour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void fnPays(ActionEvent event) throws IOException {
        Parent etab = FXMLLoader.load(getClass().getResource("GestionPays.fxml"));      
        Scene scene = new Scene(etab);
        Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
        windows.setScene(scene);
        windows.show();
    }

    @FXML
    private void fnReservation(ActionEvent event) throws IOException {
        Parent etab = FXMLLoader.load(getClass().getResource("GestionReservation.fxml"));      
        Scene scene = new Scene(etab);
        Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
        windows.setScene(scene);
        windows.show();
    }

    @FXML
    private void fnVoitures(ActionEvent event) throws IOException {
        Parent etab = FXMLLoader.load(getClass().getResource("GestionVoitures.fxml"));      
        Scene scene = new Scene(etab);
        Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
        windows.setScene(scene);
        windows.show();
    }

    @FXML
    private void fnTaxi(ActionEvent event) throws IOException {
        Parent etab = FXMLLoader.load(getClass().getResource("GestionTaxi.fxml"));      
        Scene scene = new Scene(etab);
        Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
        windows.setScene(scene);
        windows.show();
    }

    @FXML
    private void fnRetour(ActionEvent event) throws IOException {
        Parent etab = FXMLLoader.load(getClass().getResource("Retour.fxml"));      
        Scene scene = new Scene(etab);
        Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
        windows.setScene(scene);
        windows.show();
    }
    
}
