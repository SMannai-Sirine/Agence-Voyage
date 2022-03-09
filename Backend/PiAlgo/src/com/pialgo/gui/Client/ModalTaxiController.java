/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Client;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class ModalTaxiController implements Initializable {

    @FXML
    private Label lbDateRes;
    @FXML
    private Label lbPays;
    @FXML
    private Label lbVoiture;
    @FXML
    private Label lbPrix;
    @FXML
    private Label lbEtat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbDateRes.setText(MesResTaxiController.Taxx.getHeure());
        lbPays.setText(MesResTaxiController.Taxx.getNom());
        lbPrix.setText(MesResTaxiController.Taxx.getPrix()+"");
        lbVoiture.setText(MesResTaxiController.Taxx.getMatricule());
        lbEtat.setText(MesResTaxiController.Taxx.getEtat());
    }    
    
}
