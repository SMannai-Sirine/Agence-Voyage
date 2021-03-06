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

import model.Taxi;
import services.AlertBox;
import services.ServicePays;

import services.ServiceTaxi;

/**
 * FXML Controller class
 *
 * @author iHoussem
 */
public class GestionTaxiController implements Initializable {

    @FXML
    private TableView<Taxi> tvTaxi;
    @FXML
    private TableColumn<Taxi, Integer> colId;
    @FXML
    private TableColumn<Taxi, String> ColMatricule;
    @FXML
    private TableColumn<Taxi, Float> ColPrix;
    @FXML
    private TextField tfNom;
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
    private ComboBox<String> ComboPays;
    @FXML
    private TableColumn<Taxi, String> ColPays;

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
    private void fnSelected(MouseEvent event) {
         Taxi esp= tvTaxi.getSelectionModel().getSelectedItem();
        lbId.setText(String.valueOf(esp.getId()));
        tfNom.setText(esp.getMatricule());
        tfPrix.setText(String.valueOf(esp.getPrix()));
        ComboPays.setValue(esp.getNom());
        
    }

    @FXML
    private void fnAjouter(ActionEvent event) {
        if(tfNom.getText().equals("")){
            AlertBox.display("Erreur", "Ajouter un matricule de Taxi !!");
        }else if(ComboPays.getValue()==null){
            AlertBox.display("Erreur", "Ajouter un nom de pays !!");
        }else{
            try{
        ServiceTaxi ser=new ServiceTaxi();
        Taxi p=new Taxi();
        p.setMatricule(tfNom.getText());
        p.setPrix(Float.parseFloat(tfPrix.getText()));
        ServicePays serp=new ServicePays();
        p.setId_pays(serp.getIdPays(ComboPays.getValue()));
        ser.ajout(p);
        fnShow();
        tfNom.setText("");
        tfPrix.setText("");
            ComboPays.setValue(null);}catch(NumberFormatException e){
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
            AlertBox.display("Erreur", "selectionn?? une taxi pour la modifier !!");
        }else if(ComboPays.getValue()==null){
            AlertBox.display("Erreur", "Ajouter un nom de pays !!");
        }else{
            try{
        ServiceTaxi ser=new ServiceTaxi();
        Taxi p=new Taxi();
        p.setId(Integer.parseInt(lbId.getText()));
                System.out.println(p.getId());
        p.setMatricule(tfNom.getText());
        p.setPrix(Float.parseFloat(tfPrix.getText()));
        ServicePays serp=new ServicePays();
        p.setId_pays(serp.getIdPays(ComboPays.getValue()));
        ser.modifier(p);
        fnShow();
        tfNom.setText("");
        tfPrix.setText("");
            ComboPays.setValue(null);}catch(NumberFormatException e){
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
            AlertBox.display("Erreur", "selectionn?? une taxi pour la supprimer !!");
        }else{
            ServiceTaxi ser=new ServiceTaxi();
        ser.supprime(Integer.parseInt(lbId.getText()));
        fnShow();
        tfNom.setText("");
        tfPrix.setText("");
        ComboPays.setValue(null);
        }}else if (result.get()==ButtonType.CANCEL) {
                
            window.close();
            
        }
        
    }
    
    public void fnShow(){
         ServiceTaxi sr= new ServiceTaxi(){};
        List espaceList = sr.affiche();
        ObservableList list =FXCollections.observableArrayList(espaceList);
        
         colId.setCellValueFactory(new PropertyValueFactory<>("id")); 
     ColMatricule.setCellValueFactory(new PropertyValueFactory<>("matricule")); 
     ColPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
     ColPays.setCellValueFactory(new PropertyValueFactory<>("nom"));
        
        tvTaxi.setItems(list);
         FilteredList<Taxi> filteredData = new FilteredList<>(list, b -> true);
		
		tfSearch.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(p -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
                                        
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (p.getMatricule().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}
				     else if (p.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}
				     else 
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Taxi> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tvTaxi.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tvTaxi.setItems(sortedData);
        tvTaxi.setRowFactory(tv -> new TableRow<Taxi>() {
    @Override
    protected void updateItem(Taxi item, boolean empty) {
        
 
        
    }
});}
    
    @FXML
    private void fnRetour(ActionEvent event) throws IOException {
        Parent etab = FXMLLoader.load(getClass().getResource("AdminAcceuil.fxml"));      
        Scene scene = new Scene(etab);
        Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
        windows.setScene(scene);
        windows.show();
    }
    
}

    
