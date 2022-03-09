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
import services.AlertBox;
import services.ServicePays;

/**
 * FXML Controller class
 *
 * @author iHoussem
 */
public class GestionPaysController implements Initializable {

    @FXML
    private TableView<Pays> tvPays;
    @FXML
    private TableColumn<Pays, Integer> colId;
    @FXML
    private TableColumn<Pays, String> ColNom;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      fnShow();  // TODO
    }    

    @FXML
    private void fnSelected(MouseEvent event) {
         Pays esp= tvPays.getSelectionModel().getSelectedItem();
        lbId.setText(String.valueOf(esp.getId()));
        tfNom.setText(esp.getNom());
    }

    @FXML
    private void fnAjouter(ActionEvent event) {
        if(tfNom.getText().equals("")){
            AlertBox.display("Erreur", "Ajouter un nom de pays !!");
        }else{
        ServicePays ser=new ServicePays();
        Pays p=new Pays();
        p.setNom(tfNom.getText());
        ser.ajout(p);
        fnShow();
        tfNom.setText("");
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
            AlertBox.display("Erreur", "selectionné une pays pour la modifier !!");
        }else{
        ServicePays ser=new ServicePays();
        Pays p=new Pays();
        p.setId(Integer.parseInt(lbId.getText()));
        p.setNom(tfNom.getText());
        ser.modifier(p);
        fnShow();
        tfNom.setText("");
        }
        }else if (result.get()==ButtonType.CANCEL) {
                
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
            AlertBox.display("Erreur", "selectionné une pays pour la supprimer !!");
        }else{
        ServicePays ser=new ServicePays();
        ser.supprime(Integer.parseInt(lbId.getText()));
        fnShow();
        tfNom.setText("");
        }}else if (result.get()==ButtonType.CANCEL) {
                
            window.close();
            
        }
    }
    
    public void fnShow(){
         ServicePays sr= new ServicePays() {};
        List espaceList = sr.affiche();
        ObservableList list =FXCollections.observableArrayList(espaceList);
        
         colId.setCellValueFactory(new PropertyValueFactory<>("id")); 
     ColNom.setCellValueFactory(new PropertyValueFactory<>("nom"));   
        
        tvPays.setItems(list);
         FilteredList<Pays> filteredData = new FilteredList<>(list, b -> true);
		
		tfSearch.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(p -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
                                        
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (p.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Pays> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tvPays.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tvPays.setItems(sortedData);
        tvPays.setRowFactory(tv -> new TableRow<Pays>() {
    @Override
    protected void updateItem(Pays item, boolean empty) {
        
 
        
    }
});
    }

    @FXML
    private void fnRetour(ActionEvent event) throws IOException {
        Parent etab = FXMLLoader.load(getClass().getResource("AdminAcceuil.fxml"));      
        Scene scene = new Scene(etab);
        Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
        windows.setScene(scene);
        windows.show();
    }
    
}
