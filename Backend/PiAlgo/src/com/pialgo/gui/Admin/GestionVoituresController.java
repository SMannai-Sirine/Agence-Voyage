/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Admin;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Pays;
import model.Taxi;
import model.Voiture;
import services.AlertBox;
import services.ServicePays;
import services.ServiceTaxi;
import services.ServiceVoiture;

/**
 * FXML Controller class
 *
 * @author iHoussem
 */
public class GestionVoituresController implements Initializable {

    @FXML
    private TableView<Voiture> tvVoiture;
    @FXML
    private TableColumn<Voiture, Integer> colId;
    @FXML
    private TableColumn<Voiture, String> ColMatricule;
    @FXML
    private TableColumn<Voiture, String> ColType;
    @FXML
    private TableColumn<Voiture, Integer> ColPrix;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnSupp;
    @FXML
    private Label lbId;
    @FXML
    private TextField tfSearch;
    @FXML
    private Button btnRetour;
    @FXML
    private TextField tfPrix;
    @FXML
    private ComboBox<String> ComboType;
    @FXML
    private ComboBox<String> ComboModel;
    @FXML
    private ComboBox<String> ComboPays;
    @FXML
    private TableColumn<Voiture, String> ColPays;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> ListType=FXCollections.observableArrayList("Quotidien","Sport","Business");
        ObservableList<String>  listModel =FXCollections.observableArrayList("Symbol","Kia Rio","Peugot 206","Hyuandai i10","Hyuandai i20","Golf 6","Golf 7","RangeRover Velar","Audi A6","Audi Q7","Passat CC");
        ComboModel.setItems(listModel);
        ComboType.setItems(ListType);
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
    private void fnSelected(MouseEvent event) {
        Voiture esp= tvVoiture.getSelectionModel().getSelectedItem();
        lbId.setText(String.valueOf(esp.getId()));
        ComboModel.setValue(esp.getModel());
        ComboType.setValue(esp.getType());
        tfPrix.setText(String.valueOf(esp.getPrix()));
        ComboPays.setValue(esp.getNom());
    }

    @FXML
    private void fnAjouter(ActionEvent event) {
        if(ComboModel.getValue()==null){
            AlertBox.display("Erreur", "Selectionner un Model de Voiture !!");
        }else if(ComboType.getValue()==null){
            AlertBox.display("Erreur", "Selectionner un Type de Voiture !!");
        }else{
            try{
        ServiceVoiture ser=new ServiceVoiture();
        Voiture p=new Voiture();
        p.setModel(ComboModel.getValue());
        p.setType(ComboType.getValue());
        p.setPrix(Float.parseFloat(tfPrix.getText()));
        ServicePays serp=new ServicePays();
        p.setId_pays(serp.getIdPays(ComboPays.getValue()));
        ser.ajout(p);
        fnShow();
        ComboPays.setValue(null);
        ComboModel.setValue(null);
        ComboType.setValue(null);
        tfPrix.setText("");}catch(NumberFormatException e){
             AlertBox.display("Erreur", "Entrer un valide prix Ecample: 12.5 ");
        }
        }
        
    }

    @FXML
    private void fnModifier(ActionEvent event) {
        Stage window=new Stage();
            Alert.AlertType type=Alert.AlertType.CONFIRMATION;
            Alert alert=new Alert(type,"");
            
            alert.initModality(Modality.APPLICATION_MODAL);
            
            alert.getDialogPane().setContentText("Voulez-vous continuer ?");

            
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get()==ButtonType.OK) {
        if(lbId.getText().equals("")){
            AlertBox.display("Erreur", "selectionné une Voiture pour la modifier !!");
        }else{
            try{
        ServiceVoiture ser=new ServiceVoiture();
        Voiture p=new Voiture();
        p.setId(Integer.parseInt(lbId.getText()));
        p.setModel(ComboModel.getValue());
        p.setType(ComboType.getValue());
        p.setPrix(Float.parseFloat(tfPrix.getText()));
        
        ServicePays serp=new ServicePays();
        p.setId_pays(serp.getIdPays(ComboPays.getValue()));
        ser.modifier(p);
        fnShow();
        ComboModel.setValue(null);
        ComboType.setValue(null);
        ComboPays.setValue(null);
        tfPrix.setText("");}catch(NumberFormatException e){
             AlertBox.display("Erreur", "Entrer un valide prix Ecample: 12.5 ");
        }

        }}else if (result.get()==ButtonType.CANCEL) {
                
            window.close();
            
        }
    }

    @FXML
    private void fnSupp(ActionEvent event) {
        Stage window=new Stage();
            Alert.AlertType type=Alert.AlertType.CONFIRMATION;
            Alert alert=new Alert(type,"");
            
            alert.initModality(Modality.APPLICATION_MODAL);
          
            alert.getDialogPane().setContentText("Voulez-vous continuer ?");

            
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get()==ButtonType.OK) {
        if(lbId.getText().equals("")){
            AlertBox.display("Erreur", "selectionné une voiture pour la supprimer !!");
        }else{
            ServiceVoiture ser=new ServiceVoiture();
        ser.supprime(Integer.parseInt(lbId.getText()));
        fnShow();
        ComboModel.setValue(null);
        ComboType.setValue(null);
        ComboPays.setValue(null);
        tfPrix.setText("");
        }}else if (result.get()==ButtonType.CANCEL) {
                
            window.close();
            
        }
    }

    @FXML
    private void fnRetour(ActionEvent event) throws IOException {
        Parent etab = FXMLLoader.load(getClass().getResource("AdminAcceuil.fxml"));      
        Scene scene = new Scene(etab);
        Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
        windows.setScene(scene);
        windows.show();
        
    }
    public void fnShow(){
         ServiceVoiture sr= new ServiceVoiture() {};
        List espaceList = sr.affiche();
        ObservableList list =FXCollections.observableArrayList(espaceList);
        
         colId.setCellValueFactory(new PropertyValueFactory<>("id")); 
     ColMatricule.setCellValueFactory(new PropertyValueFactory<>("model"));   
     ColType.setCellValueFactory(new PropertyValueFactory<>("type")); 
     ColPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
     ColPays.setCellValueFactory(new PropertyValueFactory<>("nom"));
        
        tvVoiture.setItems(list);
         FilteredList<Voiture> filteredData = new FilteredList<>(list, b -> true);
		
		tfSearch.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(p -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
                                        
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (p.getModel().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}else if (p.getType().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}
				     else  if (p.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}
				     else
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Voiture> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tvVoiture.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tvVoiture.setItems(sortedData);
        tvVoiture.setRowFactory(tv -> new TableRow<Voiture>() {
    @Override
    protected void updateItem(Voiture item, boolean empty) {
        
 
        
    }
});
    }
}
