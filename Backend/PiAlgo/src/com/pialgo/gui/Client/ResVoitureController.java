/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Client;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
 * @author iHoussem
 */
public class ResVoitureController implements Initializable {

    @FXML
    private ComboBox<String> ComboPays;
    @FXML
    private ComboBox<String> ComboVoiture;
    @FXML
    private DatePicker tfDate;
    @FXML
    private TextField tfPeriod;
    @FXML
    private Button fnReserver;
    @FXML
    private Button btnRetour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServicePays serP=new ServicePays();
        List<String> listPay=FXCollections.observableArrayList();
        for(int i=0;i<serP.affiche().size();i++){
        listPay.add(serP.affiche().get(i).getNom());
        }
        ObservableList<String> pays=FXCollections.observableArrayList(listPay);
                
        ComboPays.setItems(pays);
        // TODO
    }    

    @FXML
    private void fnSelected(ActionEvent event) {
         ServiceVoiture serT=new ServiceVoiture();
        ServicePays serP=new ServicePays();
        List<String> listTaxi=FXCollections.observableArrayList();
        for(int i=0;i<serT.getVoitureByPays(serP.getIdPays(ComboPays.getValue())).size();i++){
        listTaxi.add(serT.getVoitureByPays(serP.getIdPays(ComboPays.getValue())).get(i).getModel());
        }
        System.out.println("dsf");
        ObservableList<String> taxi=FXCollections.observableArrayList(listTaxi);
        ComboVoiture.setItems(taxi);
        
    }

    @FXML
    private void fnReserver(ActionEvent event) throws IOException {
         ServiceLoc_Voiture ser=new ServiceLoc_Voiture();
        Loc_voiture Voi=new Loc_voiture();
        Voi.setDuree_res(Integer.parseInt(tfPeriod.getText()));
        Voi.setDate_res(Date.valueOf(tfDate.getValue()));
        if(Integer.parseInt(tfPeriod.getText())>=5){
            Voi.setRemise(Boolean.TRUE);
            Voi.setTaux_remise(10);
        }else{
            Voi.setRemise(Boolean.FALSE);
            Voi.setTaux_remise(0);
        }
        ServicePays serp=new ServicePays();
        Voi.setId_pays(serp.getIdPays(ComboPays.getValue()));
        ServiceVoiture serT=new ServiceVoiture();
        Voi.setId_voiture(serT.getVoitureByModel(ComboVoiture.getValue(),serp.getIdPays(ComboPays.getValue())).getId());
        ser.ajout(Voi);
        Reservation res=new Reservation();
        res.setEtat("En Cours");
        res.setType(Boolean.FALSE);
        res.setId_res(ser.getLastId());
        if (true) {
            
        }
        ServiceReservation serR=new ServiceReservation();
        serR.ajout(res);
        Parent etab = FXMLLoader.load(getClass().getResource("AcceuilClient.fxml"));      
        Scene scene = new Scene(etab);
        Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
        windows.setScene(scene);
        windows.show();
    }

    @FXML
    private void fnRetour(ActionEvent event) throws IOException {
        Parent etab = FXMLLoader.load(getClass().getResource("AcceuilClient.fxml"));      
        Scene scene = new Scene(etab);
        Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
        windows.setScene(scene);
        windows.show();
    }
    
}
