/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Admin;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Loc_voiture;
import model.Reservation;
import model.Taxi_aero;
import services.ServiceLoc_Voiture;
import services.ServicePays;
import services.ServiceReservation;
import services.ServiceTaxi;
import services.ServiceTaxi_aero;
import services.ServiceVoiture;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class GestionReservationTaxiController implements Initializable {

    @FXML
    private ComboBox<String> ComboEtat;
    @FXML
    private TableView<Taxi_aero> tvResVoi;
    @FXML
    private TableColumn<Taxi_aero, String> colDate;
    @FXML
    private TableColumn<Taxi_aero, String> colPays;
    @FXML
    private TableColumn<Taxi_aero, String> colVoiture;
    @FXML
    private TableColumn<Taxi_aero, Integer> colPrix;
    @FXML
    private TableColumn<Taxi_aero, String> colEtat;
    @FXML
    private Button bntRetour;
    @FXML
    private Button btnUpdate;
    @FXML
    private Label lbId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> ListEtat=FXCollections.observableArrayList("En Cours","Rejetéé","Confirmée");
        ComboEtat.setItems(ListEtat);
        fnShow(); // TODO
    }    

    @FXML
    private void fnSelectedTable(MouseEvent event) {
         Taxi_aero esp= tvResVoi.getSelectionModel().getSelectedItem();
        ComboEtat.setValue(esp.getEtat());
        lbId.setText(String.valueOf(esp.getId()));
    }

    @FXML
    private void fnRetour(ActionEvent event) {
        
    }

    @FXML
    private void fnUpdate(ActionEvent event) {
         Taxi_aero esp= tvResVoi.getSelectionModel().getSelectedItem();
        ServiceTaxi_aero ser=new ServiceTaxi_aero();
        
        Taxi_aero Voi=new Taxi_aero();
        Voi.setHeure(esp.getHeure());
        Voi.setId(esp.getId());
        ServicePays serp=new ServicePays();
        Voi.setId_pays(serp.getIdPays(esp.getNom()));
        ServiceTaxi  serT=new ServiceTaxi();
        Voi.setId_taxi(serT.getTaxiByMatricule(esp.getMatricule()).getId());
        
      
        Reservation res=new Reservation();
        res.setEtat(ComboEtat.getValue());
        res.setType(Boolean.TRUE);
        res.setId_res(Integer.parseInt(lbId.getText()));
        res.setId(Integer.parseInt(lbId.getText()));
        if (true) {
            
        }
        ServiceReservation serR=new ServiceReservation();
        serR.modifierR(res);
        fnShow();
        
        if(ComboEtat.getValue().equals("Confirmée")){
        Twilio.init("AC03a799d867b2e952a5ecd811cc762014","cd29ebcefff77380b41f022fd5c7f127");
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+21692716019"),
                new com.twilio.type.PhoneNumber("+15137562858"),
                "Salut, M/Mme Votre Resevation a etait accepter ")
            .create();}
        else{
    Twilio.init("AC03a799d867b2e952a5ecd811cc762014","cd29ebcefff77380b41f022fd5c7f127");
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+21692716019"),
                new com.twilio.type.PhoneNumber("+15137562858"),
                "Salut, M/Mme Votre Resevation a etait rejeter ")
            .create();
}
        ComboEtat.setValue(null);
    }

    private void fnShow() {
       ServiceTaxi_aero sr= new ServiceTaxi_aero() {};
        List espaceList = sr.afficheAdmin();
        ObservableList list =FXCollections.observableArrayList(espaceList);
        
         colDate.setCellValueFactory(new PropertyValueFactory<>("heure")); 
     colPays.setCellValueFactory(new PropertyValueFactory<>("nom")); 
     colPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
     colVoiture.setCellValueFactory(new PropertyValueFactory<>("matricule"));
     colEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        
        tvResVoi.setItems(list);
    }
    
}
