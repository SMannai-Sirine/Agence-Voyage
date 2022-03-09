/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Client;

import interfaces.IreservationVol;
import interfaces.Ivol;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.ReservationVol;
import model.Vol;
import services.ServiceReservationVol;
import services.ServiceVol;

/**
 * FXML Controller class
 *
 * @author Sémia
 */
public class RechercherReserverVolController implements Initializable {
    
     Ivol sV = new ServiceVol();
     IreservationVol srV = new ServiceReservationVol();

    @FXML
    private ListView<Vol> listViewVol;
    @FXML
    private TextField compagnieAerienneTF;
    @FXML
    private TextField aeroDepartTF;
    @FXML
    private TextField aeroArriveTF;
    @FXML
    private DatePicker dateDepartDP;

    /**
     * Initializes the controller class.
     */
    
     public void updateListView(){
       /* Vol v1=new Vol(sV.afficherVol().get(0).getIdVol(),sV.afficherVol().get(0).getRefAvion(), sV.afficherVol().get(0).getCompagnieAerienne(),sV.afficherVol().get(0).getAeroDepart(),sV.afficherVol().get(0).getAeroArrive(),sV.afficherVol().get(0).getDateDepart(),sV.afficherVol().get(0).getDuree(), sV.afficherVol().get(0).getNbSieges(),sV.afficherVol().get(0).getPrix());
        Vol v2=new Vol(sV.afficherVol().get(1).getIdVol(),sV.afficherVol().get(1).getRefAvion(), sV.afficherVol().get(1).getCompagnieAerienne(),sV.afficherVol().get(1).getAeroDepart(),sV.afficherVol().get(1).getAeroArrive(),sV.afficherVol().get(1).getDateDepart(),sV.afficherVol().get(1).getDuree(), sV.afficherVol().get(1).getNbSieges(),sV.afficherVol().get(1).getPrix());
*/
       ObservableList<Vol> list = FXCollections.observableArrayList(sV.afficherVol());
     //  ObservableList<Vol> list = FXCollections.observableArrayList(v1,v2);
     //ObservableList<Vol> list = FXCollections.observableArrayList();
  
       
//       list.addAll(v1,v2);
      
        listViewVol.setItems(list);
        listViewVol.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listViewVol.getSelectionModel().selectIndices(1, 3);
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateListView();
        // TODO
    }    

    @FXML
    private void retourButton(ActionEvent event) throws Exception{
        
        Parent etab = FXMLLoader.load(getClass().getResource("ClientAccueil.fxml"));      
        Scene scene = new Scene(etab);
        Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
        windows.setScene(scene);
        windows.show();
    }

    @FXML
    private void rechercheVolAction(ActionEvent event) {
        String d;
         if(dateDepartDP.getValue()!=null)  
            d=dateDepartDP.getValue().toString();
         else
             d="";
        
        ObservableList<Vol> list = FXCollections.observableArrayList(sV.rechercheVolTrie(compagnieAerienneTF.getText(),aeroDepartTF.getText(),aeroArriveTF.getText(),d));
          //ObservableList<Vol> list = FXCollections.observableArrayList(sV.rechercheVol(refAvionTF.getText(),compagnieAerienneTF.getText(),aeroDepartTF.getText(),aeroArriveTF.getText(), myDate,Float.parseFloat(dureeTF.getText()),Integer.parseInt(nbSiegesTF.getText()),Float.parseFloat(prixTF.getText())));
  
      
      
        listViewVol.setItems(list);
        listViewVol.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listViewVol.getSelectionModel().selectIndices(1, 3); 
    }

    @FXML
    private void reserverVolAction(ActionEvent event) {
        Vol selectedVol= listViewVol.getSelectionModel().getSelectedItem();
        int id = selectedVol.getIdVol();
        srV.ajouterReservationVol(new ReservationVol(1,id));
        
    }
    
}
