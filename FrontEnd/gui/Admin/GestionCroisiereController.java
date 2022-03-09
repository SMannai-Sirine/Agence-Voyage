/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Admin;

import interfaces.Icroisiere;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Croisiere;
import services.ServiceCroisiere;

/**
 * FXML Controller class
 *
 * @author Sémia
 */




public class GestionCroisiereController implements Initializable {
    
    Icroisiere sC = new ServiceCroisiere();

    @FXML
    private ListView<Croisiere> listViewCroisiere;
    @FXML
    private TextField refBateauTF;
    @FXML
    private DatePicker dateDepartDP;
    @FXML
    private TextField compagnieNavigationTF;
    @FXML
    private TextField portArriveTF;
    @FXML
    private TextField portDepartTF;
    @FXML
    private TextField nbCabinesTF;
    @FXML
    private TextField prixTF;
    @FXML
    private DatePicker dateArriveDP;

    /**
     * Initializes the controller class.
     */
    
     public void updateListView(){
         
        ObservableList<Croisiere> list1 = FXCollections.observableArrayList(sC.afficherCroisiere());
        listViewCroisiere.setItems(list1);
    }
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
    private void listViewCroisiereSelection(MouseEvent event) {
        Croisiere selectedCroisiere= listViewCroisiere.getSelectionModel().getSelectedItem();
        
        refBateauTF.setText(selectedCroisiere.getRefBateau());
        compagnieNavigationTF.setText(selectedCroisiere.getCompagnieNavigation());
        dateDepartDP.setValue(selectedCroisiere.getDateDepart().toLocalDate());
        dateArriveDP.setValue(selectedCroisiere.getDateArrivee().toLocalDate());
        portDepartTF.setText(selectedCroisiere.getPortDepart());
        portArriveTF.setText(selectedCroisiere.getPortArrive());
        nbCabinesTF.setText(String.valueOf(selectedCroisiere.getNbCabines()));
        prixTF.setText(String.valueOf(selectedCroisiere.getPrixCroisiere()));
    }

    @FXML
    private void supprimerAction(ActionEvent event) {
        Croisiere selectedCroisiere= listViewCroisiere.getSelectionModel().getSelectedItem();
        int id = selectedCroisiere.getIdCroisiere();
        sC.supprimerCroisiere(id);
        updateListView();
    }

    @FXML
    private void ajouterAction(ActionEvent event) {
        Date myDate1 = Date.valueOf(dateDepartDP.getValue().toString());
        Date myDate2 = Date.valueOf(dateArriveDP.getValue().toString());
        sC.ajouterCroisiere2(new Croisiere(refBateauTF.getText(),compagnieNavigationTF.getText(),portDepartTF.getText(),portArriveTF.getText(), myDate1,myDate2,Integer.parseInt(nbCabinesTF.getText()),Float.parseFloat(prixTF.getText())));
        //listViewVol.getItems().add(new Vol(refAvionTF.getText(),compagnieAerienneTF.getText(),aeroDepartTF.getText(),aeroArriveTF.getText(), myDate,Float.parseFloat(dureeTF.getText()),Integer.parseInt(nbSiegesTF.getText()),Float.parseFloat(prixTF.getText())));
        updateListView();
    }

    @FXML
    private void modifierAction(ActionEvent event) {
       Croisiere selectedCroisiere= listViewCroisiere.getSelectionModel().getSelectedItem();
        Date myDate1 = Date.valueOf(dateDepartDP.getValue().toString());
        Date myDate2 = Date.valueOf(dateArriveDP.getValue().toString());
        int id = selectedCroisiere.getIdCroisiere();
        
        sC.modifierCroisiere(id,refBateauTF.getText(),compagnieNavigationTF.getText(),portDepartTF.getText(),portArriveTF.getText(),myDate1 ,myDate2,Integer.parseInt(nbCabinesTF.getText()),Float.parseFloat(prixTF.getText()));
    updateListView();
    }

    @FXML
    private void rechercherAction(ActionEvent event) {
        String d1,d2;
         if(dateDepartDP.getValue()!=null)  
            d1=dateDepartDP.getValue().toString();
         else
             d1="";
         
         if(dateArriveDP.getValue()!=null)  
            d2=dateArriveDP.getValue().toString();
         else
             d2="";
        
        ObservableList<Croisiere> list = FXCollections.observableArrayList(sC.rechercheCroisiere(refBateauTF.getText(),compagnieNavigationTF.getText(),portDepartTF.getText(),portArriveTF.getText(), d1,d2,nbCabinesTF.getText(),prixTF.getText()));
          //ObservableList<Vol> list = FXCollections.observableArrayList(sV.rechercheVol(refAvionTF.getText(),compagnieAerienneTF.getText(),aeroDepartTF.getText(),aeroArriveTF.getText(), myDate,Float.parseFloat(dureeTF.getText()),Integer.parseInt(nbSiegesTF.getText()),Float.parseFloat(prixTF.getText())));
  
      
      
        listViewCroisiere.setItems(list);
        listViewCroisiere.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listViewCroisiere.getSelectionModel().selectIndices(1, 3); 
    }

    @FXML
    private void AfficherAction(ActionEvent event) {
        updateListView();
    }
    
}
