/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Admin;

import interfaces.IreservationVol;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.ReservationVol;
import services.ServiceReservationVol;

/**
 * FXML Controller class
 *
 * @author Sémia
 */
public class GestionReservationVolController implements Initializable {
    
    IreservationVol srV = new ServiceReservationVol();

    @FXML
    private ListView<ReservationVol> listViewReservationVol;

    /**
     * Initializes the controller class.
     */
    
      public void updateListView(){
       /* Vol v1=new Vol(sV.afficherVol().get(0).getIdVol(),sV.afficherVol().get(0).getRefAvion(), sV.afficherVol().get(0).getCompagnieAerienne(),sV.afficherVol().get(0).getAeroDepart(),sV.afficherVol().get(0).getAeroArrive(),sV.afficherVol().get(0).getDateDepart(),sV.afficherVol().get(0).getDuree(), sV.afficherVol().get(0).getNbSieges(),sV.afficherVol().get(0).getPrix());
        Vol v2=new Vol(sV.afficherVol().get(1).getIdVol(),sV.afficherVol().get(1).getRefAvion(), sV.afficherVol().get(1).getCompagnieAerienne(),sV.afficherVol().get(1).getAeroDepart(),sV.afficherVol().get(1).getAeroArrive(),sV.afficherVol().get(1).getDateDepart(),sV.afficherVol().get(1).getDuree(), sV.afficherVol().get(1).getNbSieges(),sV.afficherVol().get(1).getPrix());
*/
       ObservableList<ReservationVol> list = FXCollections.observableArrayList(srV.afficherReservationVol());
     //  ObservableList<Vol> list = FXCollections.observableArrayList(v1,v2);
     //ObservableList<Vol> list = FXCollections.observableArrayList();
  
       
//       list.addAll(v1,v2);
      
        listViewReservationVol.setItems(list);
        listViewReservationVol.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listViewReservationVol.getSelectionModel().selectIndices(1, 3);
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        updateListView();
    }    

    @FXML
    private void retourButton(ActionEvent event)throws Exception {
        
        Parent etab = FXMLLoader.load(getClass().getResource("AdminAccueil.fxml"));      
        Scene scene = new Scene(etab);
        Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
        windows.setScene(scene);
        windows.show();
    }

    

    @FXML
    private void listViewReservationVolSelection(MouseEvent event) {
    }

    @FXML
    private void supprimerReservationAction(ActionEvent event) {
        ReservationVol selectedReservationVol= listViewReservationVol.getSelectionModel().getSelectedItem();
        int id = selectedReservationVol.getIdReservationVol();
        srV.supprimerReservationVol(id);
        updateListView();
    }
    
}
