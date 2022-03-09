/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Admin;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Loc_voiture;
import model.Reservation;
import services.ServiceLoc_Voiture;
import services.ServicePays;
import services.ServiceReservation;
import services.ServiceVoiture;

/**
 * FXML Controller class
 *
 * @author iHoussem
 */
public class GestionReservationVoitureController implements Initializable {

    @FXML
    private TableView<Loc_voiture> tvResVoi;
    @FXML
    private TableColumn<Loc_voiture, Date> colDate;
    @FXML
    private TableColumn<Loc_voiture, Integer> colDuree;
    @FXML
    private TableColumn<Loc_voiture, String> colPays;
    @FXML
    private TableColumn<Loc_voiture, String> colVoiture;
    @FXML
    private TableColumn<Loc_voiture, Float> colPrix;
    @FXML
    private TableColumn<Loc_voiture, Boolean> colRemise;
    @FXML
    private TableColumn<Loc_voiture, Integer> colTaux;
    @FXML
    private TableColumn<Loc_voiture, String> colEtat;
    @FXML
    private ComboBox<String> ComboEtat;
    @FXML
    private ComboBox<String> ComboRemise;
    @FXML
    private TextField tfTaux;
    @FXML
    private Label lbId;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button bntRetour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> ListEtat=FXCollections.observableArrayList("En Cours","Rejetéé","Confirmée");
        ObservableList<String> ListRemiset=FXCollections.observableArrayList("Oui","Non");
        ComboEtat.setItems(ListEtat);
        ComboRemise.setItems(ListRemiset);
        fnShow();
        // TODO
    }    

    @FXML
    private void fnSelectedTable(MouseEvent event) {
        Loc_voiture esp= tvResVoi.getSelectionModel().getSelectedItem();
        ComboEtat.setValue(esp.getEtat());
        if(esp.getRemise()){
        ComboRemise.setValue("Oui");
    }else{
            ComboRemise.setValue("Non");
            }
        tfTaux.setText(""+esp.getTaux_remise());
        lbId.setText(String.valueOf(esp.getId()));
        
        
    }
    
    public void fnShow(){
        ServiceLoc_Voiture sr= new ServiceLoc_Voiture() {};
        List espaceList = sr.afficheAdmin();
        ObservableList list =FXCollections.observableArrayList(espaceList);
        
         colDate.setCellValueFactory(new PropertyValueFactory<>("date_res")); 
     colDuree.setCellValueFactory(new PropertyValueFactory<>("duree_res"));   
     colPays.setCellValueFactory(new PropertyValueFactory<>("pay")); 
     colPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
     colRemise.setCellValueFactory(new PropertyValueFactory<>("remise"));
     colTaux.setCellValueFactory(new PropertyValueFactory<>("taux_remise"));
     colVoiture.setCellValueFactory(new PropertyValueFactory<>("nom"));
     colEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        
        tvResVoi.setItems(list);
        
    }

    @FXML
    private void fnSelectedRemise(ActionEvent event) {
        try{
            if (ComboRemise.getValue().equals("Non") || ComboRemise.getValue() == null) {
            tfTaux.setText("0");
            tfTaux.setDisable(true);
        }else if(ComboRemise.getValue().equals("Oui")){
            
            tfTaux.setDisable(false);
        }
        }catch(java.lang.NullPointerException e){
            tfTaux.setText("0");
            tfTaux.setDisable(true);
        }
        
        
    }

    @FXML
    private void fnUpdate(ActionEvent event) {
        Loc_voiture esp= tvResVoi.getSelectionModel().getSelectedItem();
        ServiceLoc_Voiture ser=new ServiceLoc_Voiture();
        
        Loc_voiture Voi=new Loc_voiture();
        Voi.setDuree_res(esp.getDuree_res());
        Voi.setDate_res(esp.getDate_res());
        Voi.setId(esp.getId());
       if(ComboRemise.getValue().equals("Oui")){
        Voi.setRemise(Boolean.TRUE);
    }else if(ComboRemise.getValue().equals("Non")){
            Voi.setRemise(Boolean.FALSE);
            }
        Voi.setTaux_remise(Integer.parseInt(tfTaux.getText()));
        ServicePays serp=new ServicePays();
        Voi.setId_pays(serp.getIdPays(esp.getPay()));
        ServiceVoiture serT=new ServiceVoiture();
        Voi.setId_voiture(serT.getVoitureByModel(esp.getNom(),serp.getIdPays(esp.getPay())).getId());
        
        ser.modifier(Voi);
        Reservation res=new Reservation();
        res.setEtat(ComboEtat.getValue());
        res.setType(Boolean.FALSE);
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
        ComboRemise.setValue(null);
        tfTaux.setText("");
         }
   

    @FXML
    private void fnRetour(ActionEvent event) throws IOException {
        Parent etab = FXMLLoader.load(getClass().getResource("GestionReservation.fxml"));      
        Scene scene = new Scene(etab);
        Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
        windows.setScene(scene);
        windows.show();
    }
    
}
