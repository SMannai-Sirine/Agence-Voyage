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
public class ModalVoitureController implements Initializable {

    @FXML
    private Label lbDateRes;
    @FXML
    private Label lbDuree;
    @FXML
    private Label lbPays;
    @FXML
    private Label lbVoiture;
    @FXML
    private Label lbPrix;
    @FXML
    private Label lbRemise;
    @FXML
    private Label lbTauxRemise;
    @FXML
    private Label lbEtat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbDateRes.setText(MesResVoitureController.loc.getDate_res().toString());   
        lbDuree.setText(""+MesResVoitureController.loc.getDuree_res())     ;
        lbPays.setText(MesResVoitureController.loc.getPay())      ;
        lbVoiture.setText(MesResVoitureController.loc.getNom())       ;
        lbPrix.setText(""+MesResVoitureController.loc.getPrix())      ;
        lbRemise.setText(MesResVoitureController.loc.getRemise().toString())        ;
        lbTauxRemise.setText(MesResVoitureController.loc.getTaux_remise()+"")        ;
        lbEtat.setText(MesResVoitureController.loc.getEtat())          ;
        // TODO
    }    
    
}
