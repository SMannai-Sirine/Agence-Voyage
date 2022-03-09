/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Client;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Loc_voiture;
import model.Pays;
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
public class MesResVoitureController implements Initializable {

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
    private DatePicker PkDate;
    @FXML
    private TextField tfDurree;
    @FXML
    private ComboBox<String> ComboPays;
    @FXML
    private ComboBox<String> ComboVoiture;
    @FXML
    private Label lbPrix;
    @FXML
    private Label lbRemise;
    @FXML
    private Label lbTaux;
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
    private TableColumn<Loc_voiture, String> colEtat;
    @FXML
    private Label lbPrixFinale;
    @FXML
    private Label lbEtat;
    @FXML
    private ListView<String> listView;
    public static Loc_voiture loc;

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
        fnShow();
        // TODO
    }    

    @FXML
    private void fnSelectedTable(MouseEvent event) {
        Loc_voiture esp= tvResVoi.getSelectionModel().getSelectedItem();
        PkDate.setValue(esp.getDate_res().toLocalDate());
        tfDurree.setText(String.valueOf(esp.getDuree_res()));
        ComboPays.setValue(esp.getPay());
        lbId.setText(String.valueOf(esp.getId()));
        ActionEvent e=new ActionEvent();
        fnSelectedPays(e);
        ComboVoiture.setValue(esp.getNom());
        lbPrix.setText(""+esp.getPrix());
        lbRemise.setText(String.valueOf(esp.getRemise()));
        lbTaux.setText(String.valueOf(esp.getTaux_remise()));
        lbPrixFinale.setText(String.valueOf(esp.getPrix()-((esp.getPrix()/100)*esp.getTaux_remise())));
        lbEtat.setText(esp.getEtat());
        
        
    }

    @FXML
    private void fnSelectedPays(ActionEvent event) {
         ServiceVoiture serT=new ServiceVoiture();
        ServicePays serP=new ServicePays();
        List<String> listVoiture=FXCollections.observableArrayList();
        for(int i=0;i<serT.getVoitureByPays(serP.getIdPays(ComboPays.getValue())).size();i++){
        listVoiture.add(serT.getVoitureByPays(serP.getIdPays(ComboPays.getValue())).get(i).getModel());
        }
        System.out.println("dsf");
        ObservableList<String> voiture=FXCollections.observableArrayList(listVoiture);
        ComboVoiture.setItems(voiture);
    }

    @FXML
    private void fnAjouter(ActionEvent event) throws IOException {
        Parent etab = FXMLLoader.load(getClass().getResource("ResVoiture.fxml"));      
        Scene scene = new Scene(etab);
        Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
        windows.setScene(scene);
        windows.show();
    }

    @FXML
    private void fnModifier(ActionEvent event) {
        ServiceLoc_Voiture ser=new ServiceLoc_Voiture();
        
        Loc_voiture Voi=new Loc_voiture();
        Voi.setDuree_res(Integer.parseInt(tfDurree.getText()));
        Voi.setDate_res(Date.valueOf(PkDate.getValue()));
        Voi.setId(Integer.parseInt(lbId.getText()));
        if(Integer.parseInt(tfDurree.getText())>=5){
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
        
        ser.modifier(Voi);
        Reservation res=new Reservation();
        res.setEtat("En Cours");
        res.setType(Boolean.FALSE);
        res.setId_res(Integer.parseInt(lbId.getText()));
        res.setId(Integer.parseInt(lbId.getText()));
        if (true) {
            
        }
        ServiceReservation serR=new ServiceReservation();
        serR.modifierR(res);
        fnShow();
        PkDate.setValue(null);
        tfDurree.setText("");
        ComboPays.setValue(null);
        lbId.setText("");
        ComboVoiture.setValue(null);
        lbPrix.setText("");
        lbRemise.setText("");
        lbTaux.setText("");
        lbPrixFinale.setText("");
        lbEtat.setText("");
       
        
        
    }

    @FXML
    private void fnAnnuler(ActionEvent event) {
        ServiceReservation serR=new ServiceReservation();
        Reservation res=new Reservation();
        res.setEtat("Annulé");
        res.setType(Boolean.FALSE);
        res.setId_res(Integer.parseInt(lbId.getText()));
        res.setId(Integer.parseInt(lbId.getText()));
        if (true) {
            
        }
        serR.modifierR(res);
        fnShow();
        PkDate.setValue(null);
        tfDurree.setText("");
        ComboPays.setValue(null);
        lbId.setText("");
        ComboVoiture.setValue(null);
        lbPrix.setText("");
        lbRemise.setText("");
        lbTaux.setText("");
        lbPrixFinale.setText("");
        lbEtat.setText("");
        
    }
    public void getVoitureModal(ActionEvent event,Loc_voiture locV) throws IOException{
        loc=locV;
        Parent etab = FXMLLoader.load(getClass().getResource("ModalVoiture.fxml"));      
        Scene scene = new Scene(etab);
        Stage windows = new Stage();
        windows.setScene(scene);
        windows.show();
    }
    public void fnShow(){
        ServiceLoc_Voiture sr= new ServiceLoc_Voiture();
        List<Loc_voiture> espaceList = sr.affiche();
        
        ObservableList list =FXCollections.observableArrayList(espaceList);
        ObservableList<String> listDate =FXCollections.observableArrayList();
       
        System.out.println(listDate.toString()+"*************");
        for (int i=0; i<espaceList.size() ;i++ ){
          listDate.addAll(espaceList.get(i).getDate_res().toString());
        }
        System.out.println(listDate.toString());
        listView.setItems(listDate);
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        ServiceLoc_Voiture sra= new ServiceLoc_Voiture();
        Loc_voiture esp= sra.getLocByDate(listView.getSelectionModel().selectedItemProperty().get());
                System.out.println(esp.toString());
        PkDate.setValue(esp.getDate_res().toLocalDate());
        tfDurree.setText(String.valueOf(esp.getDuree_res()));
        ComboPays.setValue(esp.getPay());
        lbId.setText(String.valueOf(esp.getId()));
        ActionEvent e=new ActionEvent();
        fnSelectedPays(e);
        ComboVoiture.setValue(esp.getNom());
        lbPrix.setText(""+esp.getPrix());
        lbRemise.setText(String.valueOf(esp.getRemise()));
        lbTaux.setText(String.valueOf(esp.getTaux_remise()));
        lbPrixFinale.setText(String.valueOf(esp.getPrix()-((esp.getPrix()/100)*esp.getTaux_remise())));
        lbEtat.setText(esp.getEtat());
                ActionEvent event = new ActionEvent();       
                        try {
                    getVoitureModal(event,esp);
                } catch (IOException ex) {
                    Logger.getLogger(MesResVoitureController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
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
    private void fnRetour(ActionEvent event) throws IOException {
        Parent etab = FXMLLoader.load(getClass().getResource("MesRes.fxml"));      
        Scene scene = new Scene(etab);
        Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
        windows.setScene(scene);
        windows.show();
    }
    
}
