/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Client;

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
public class AcceuilClientController implements Initializable {

    @FXML
    private Button bntResvVoiture;
    @FXML
    private Button fnResvTaxi;
    @FXML
    private Button btnMesRes;
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
    private void fnResvVoiture(ActionEvent event) throws IOException {
        Parent etab = FXMLLoader.load(getClass().getResource("ResVoiture.fxml"));      
        Scene scene = new Scene(etab);
        Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
        windows.setScene(scene);
        windows.show();
        
    }

    @FXML
    private void fnMesRes(ActionEvent event) throws IOException {
        Parent etab = FXMLLoader.load(getClass().getResource("MesRes.fxml"));      
        Scene scene = new Scene(etab);
        Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
        windows.setScene(scene);
        windows.show();
    }

    @FXML
    private void fnRetour(ActionEvent event) {
        
    }

    @FXML
    private void fnResTaxi(ActionEvent event) throws IOException {
        Parent etab = FXMLLoader.load(getClass().getResource("ResTaxi.fxml"));      
        Scene scene = new Scene(etab);
        Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
        windows.setScene(scene);
        windows.show();
    }
    
}
