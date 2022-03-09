/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Client;

import static GUI.Client.MesResVoitureController.loc;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Loc_voiture;
import model.Reservation;
import model.Taxi;
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
public class MesResTaxiController implements Initializable {

    @FXML
    private TextField PkDate;
    @FXML
    private ComboBox<String> ComboPays;
    @FXML
    private ComboBox<String> ComboVoiture;
    @FXML
    private Label lbPrix;
    @FXML
    private Label lbEtat;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnAnnuler;
    @FXML
    private Button btnRetour;
    @FXML
    private Label lbId;
    @FXML
    private ListView<String> listView;
    public static Taxi_aero Taxx;

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
        fnShow(); // TODO
    }    

    @FXML
    private void fnSelectedPays(ActionEvent event) {
          ServiceTaxi serT=new ServiceTaxi();
        ServicePays serP=new ServicePays();
        List<String> listVoiture=FXCollections.observableArrayList();
        for(int i=0;i<serT.getTaxiByPays(serP.getIdPays(ComboPays.getValue())).size();i++){
        listVoiture.add(serT.getTaxiByPays(serP.getIdPays(ComboPays.getValue())).get(i).getMatricule());
        }
        System.out.println("dsf");
        ObservableList<String> voiture=FXCollections.observableArrayList(listVoiture);
        ComboVoiture.setItems(voiture);
    }

    @FXML
    private void fnAjouter(ActionEvent event) throws IOException {
        Parent etab = FXMLLoader.load(getClass().getResource("ResTaxi.fxml"));      
        Scene scene = new Scene(etab);
        Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
        windows.setScene(scene);
        windows.show();
    }

    @FXML
    private void fnModifier(ActionEvent event) {
        ServiceTaxi_aero ser=new ServiceTaxi_aero();
        
        Taxi_aero Voi=new Taxi_aero();
        Voi.setHeure(PkDate.getText());
        Voi.setId(Integer.parseInt(lbId.getText()));
        ServicePays serp=new ServicePays();
        Voi.setId_pays(serp.getIdPays(ComboPays.getValue()));
        ServiceTaxi serT=new ServiceTaxi();
        Voi.setId_taxi(serT.getTaxiByMatricule(ComboVoiture.getValue()).getId());
        
        ser.modifier(Voi);
        Reservation res=new Reservation();
        res.setEtat("En Cours");
        res.setType(Boolean.TRUE);
        res.setId_res(Integer.parseInt(lbId.getText()));
        res.setId(Integer.parseInt(lbId.getText()));
        if (true) {
            
        }
        ServiceReservation serR=new ServiceReservation();
        serR.modifierR(res);
        fnShow();
        PkDate.setText("");
        ComboPays.setValue(null);
        lbId.setText("");
        ComboVoiture.setValue(null);
        lbPrix.setText("");
        lbEtat.setText("");
       
    }

    @FXML
    private void fnAnnuler(ActionEvent event) {
        ServiceReservation serR=new ServiceReservation();
        Reservation res=new Reservation();
        res.setEtat("Annulé");
        res.setType(Boolean.TRUE);
        res.setId_res(Integer.parseInt(lbId.getText()));
        res.setId(Integer.parseInt(lbId.getText()));
        if (true) {
            
        }
        serR.modifierR(res);
        fnShow();
        PkDate.setText("");
        ComboPays.setValue(null);
        lbId.setText("");
        ComboVoiture.setValue(null);
        lbPrix.setText("");
        lbEtat.setText("");
    }

    @FXML
    private void fnRetour(ActionEvent event) throws IOException {
        
        Parent etab = FXMLLoader.load(getClass().getResource("MesRes.fxml"));      
        Scene scene = new Scene(etab);
        Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
        windows.setScene(scene);
        windows.show();
    }
private void getTaxiModal(ActionEvent event, Taxi_aero esp) throws IOException {
                Taxx=esp;
        Parent etab = FXMLLoader.load(getClass().getResource("ModalTaxi.fxml"));      
        Scene scene = new Scene(etab);
        Stage windows = new Stage();
        windows.setScene(scene);
        windows.show();
            }
    private void fnShow() {
        ServiceTaxi_aero sr= new ServiceTaxi_aero();
        List<Taxi_aero> espaceList = sr.affiche();
        
        ObservableList list =FXCollections.observableArrayList(espaceList);
        ObservableList<String> listDate =FXCollections.observableArrayList();
       
        System.out.println(listDate.toString()+"*************");
        for (int i=0; i<espaceList.size() ;i++ ){
          listDate.addAll(espaceList.get(i).getMatricule());
        }
        System.out.println(listDate.toString());
        listView.setItems(listDate);
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        ServiceTaxi_aero sra= new ServiceTaxi_aero();
        Taxi_aero esp= sra.getTaxiAeroByMat(listView.getSelectionModel().selectedItemProperty().get());
                System.out.println(esp.toString());
        PkDate.setText(esp.getHeure());
        ComboPays.setValue(esp.getNom());
        lbId.setText(String.valueOf(esp.getId()));
        ActionEvent e=new ActionEvent();
        fnSelectedPays(e);
        ComboVoiture.setValue(esp.getMatricule());
        lbPrix.setText(""+esp.getPrix());
        lbEtat.setText(esp.getEtat());
                ActionEvent event = new ActionEvent();       
                        try {
                    getTaxiModal(event,esp);
                } catch (IOException ex) {
                    Logger.getLogger(MesResVoitureController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            
        });
    }
    
}
