/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Client;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Reservation;
import model.Taxi_aero;
import services.ServicePays;
import services.ServiceReservation;
import services.ServiceTaxi;
import services.ServiceTaxi_aero;

/**
 * FXML Controller class
 *
 * @author iHoussem
 */
public class ResTaxiController implements Initializable {

    @FXML
    private ComboBox<String> ComboPays;
    @FXML
    private ComboBox<String> ComboTaxi;
    @FXML
    private TextField tfHeure;
    @FXML
    private Button btnRetour;
    @FXML
    private Button btnReserver;

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
    private void fnRetour(ActionEvent event) throws IOException {
        Parent etab = FXMLLoader.load(getClass().getResource("AcceuilClient.fxml"));      
        Scene scene = new Scene(etab);
        Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
        windows.setScene(scene);
        windows.show();
    }

    @FXML
    private void fnReserver(ActionEvent event) throws IOException {
        ServiceTaxi_aero ser=new ServiceTaxi_aero();
        Taxi_aero tax=new Taxi_aero();
        tax.setHeure(tfHeure.getText());
        ServicePays serp=new ServicePays();
        tax.setId_pays(serp.getIdPays(ComboPays.getValue()));
        ServiceTaxi serT=new ServiceTaxi();
        tax.setId_taxi(serT.getTaxiByMatricule(ComboTaxi.getValue()).getId());
        ser.ajout(tax);
        Reservation res=new Reservation();
        res.setEtat("En Cours");
        res.setType(Boolean.TRUE);
        res.setId_res(ser.getLastId());
        ServiceReservation serR=new ServiceReservation();
        serR.ajout(res);
        Parent etab = FXMLLoader.load(getClass().getResource("AcceuilClient.fxml"));      
        Scene scene = new Scene(etab);
        Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
        windows.setScene(scene);
        windows.show();
        
        
    }

    @FXML
    private void fnSelected(ActionEvent event) {
        ServiceTaxi serT=new ServiceTaxi();
        ServicePays serP=new ServicePays();
        List<String> listTaxi=FXCollections.observableArrayList();
        for(int i=0;i<serT.getTaxiByPays(serP.getIdPays(ComboPays.getValue())).size();i++){
        listTaxi.add(serT.getTaxiByPays(serP.getIdPays(ComboPays.getValue())).get(i).getMatricule());
        }
        System.out.println("dsf");
        ObservableList<String> taxi=FXCollections.observableArrayList(listTaxi);
        ComboTaxi.setItems(taxi);
    }

    

    

    
    
}
