/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Admin;

import interfaces.Ivol;
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
import model.Vol;
import services.PDF;
import services.ServiceVol;

/**
 * FXML Controller class
 *
 * @author Sémia
 */
public class GestionVolController implements Initializable {
    
    Ivol sV = new ServiceVol();
    PDF pdf = new PDF();
    
    

    @FXML
    private TextField refAvionTF;
    @FXML
    private DatePicker dateDepartDP;
    @FXML
    private TextField compagnieAerienneTF;
    @FXML
    private TextField aeroDepartTF;
    @FXML
    private TextField aeroArriveTF;
    @FXML
    private TextField dureeTF;
    @FXML
    private TextField nbSiegesTF;
    @FXML
    private TextField prixTF;
    @FXML
    private ListView<Vol> listViewVol;

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
        //refAvionTF.textProperty().addListener((obs,oldText,newText)->{
      //System.out.println("Text changée");
    //});
    
    }    

    @FXML
    private void ajouterAction(ActionEvent event) {
        Date myDate = Date.valueOf(dateDepartDP.getValue().toString());
        sV.ajouterVol2(new Vol(refAvionTF.getText(),compagnieAerienneTF.getText(),aeroDepartTF.getText(),aeroArriveTF.getText(), myDate,Float.parseFloat(dureeTF.getText()),Integer.parseInt(nbSiegesTF.getText()),Float.parseFloat(prixTF.getText())));
        //listViewVol.getItems().add(new Vol(refAvionTF.getText(),compagnieAerienneTF.getText(),aeroDepartTF.getText(),aeroArriveTF.getText(), myDate,Float.parseFloat(dureeTF.getText()),Integer.parseInt(nbSiegesTF.getText()),Float.parseFloat(prixTF.getText())));
        updateListView();
    }

    @FXML
    private void modifierAction(ActionEvent event) {
        Vol selectedVol= listViewVol.getSelectionModel().getSelectedItem();
        Date myDate = Date.valueOf(dateDepartDP.getValue().toString());
        int id = selectedVol.getIdVol();
        
        sV.modifierVol(id,refAvionTF.getText(),compagnieAerienneTF.getText(),aeroDepartTF.getText(),aeroArriveTF.getText(),myDate ,Float.parseFloat(dureeTF.getText()),Integer.parseInt(nbSiegesTF.getText()),Float.parseFloat(prixTF.getText()));
    updateListView();
    }
    

    @FXML
    private void supprimerAction(ActionEvent event) {
        Vol selectedVol= listViewVol.getSelectionModel().getSelectedItem();
        int id = selectedVol.getIdVol();
        sV.supprimerVol(id);
        updateListView();
    }

    @FXML
    private void retourButton(ActionEvent event) throws Exception{
        
        Parent etab = FXMLLoader.load(getClass().getResource("AdminAccueil.fxml"));      
        Scene scene = new Scene(etab);
        Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
        windows.setScene(scene);
        windows.show();
    }

    @FXML
    private void listViewSelection(MouseEvent event) {
        
        Vol selectedVol= listViewVol.getSelectionModel().getSelectedItem();
        
        refAvionTF.setText(selectedVol.getRefAvion());
        compagnieAerienneTF.setText(selectedVol.getCompagnieAerienne());
        dateDepartDP.setValue(selectedVol.getDateDepart().toLocalDate());
        aeroDepartTF.setText(selectedVol.getAeroDepart());
        aeroArriveTF.setText(selectedVol.getAeroArrive());
        dureeTF.setText(String.valueOf(selectedVol.getDuree()));
        nbSiegesTF.setText(String.valueOf(selectedVol.getNbSieges()));
        prixTF.setText(String.valueOf(selectedVol.getPrix()));
    }

    @FXML
    private void rechercherAction(ActionEvent event) {
        //Date myDate = Date.valueOf(dateDepartDP.getValue().toString());
        String d;
         if(dateDepartDP.getValue()!=null)  
            d=dateDepartDP.getValue().toString();
         else
             d="";
        
        ObservableList<Vol> list = FXCollections.observableArrayList(sV.rechercheVol(refAvionTF.getText(),compagnieAerienneTF.getText(),aeroDepartTF.getText(),aeroArriveTF.getText(), d,dureeTF.getText(),nbSiegesTF.getText(),prixTF.getText()));
          //ObservableList<Vol> list = FXCollections.observableArrayList(sV.rechercheVol(refAvionTF.getText(),compagnieAerienneTF.getText(),aeroDepartTF.getText(),aeroArriveTF.getText(), myDate,Float.parseFloat(dureeTF.getText()),Integer.parseInt(nbSiegesTF.getText()),Float.parseFloat(prixTF.getText())));
  
      
      
        listViewVol.setItems(list);
        listViewVol.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listViewVol.getSelectionModel().selectIndices(1, 3);      
    }

    @FXML
    private void afficherAction(ActionEvent event) {
        updateListView();
    }

    @FXML
    private void pdfAction(ActionEvent event) {
       pdf.AfficherPdf();
    }
    
    
   
    
}
