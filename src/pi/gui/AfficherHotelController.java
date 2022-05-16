/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.gui;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
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
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;
import pi.entities.Hotel;
import pi.sevices.HotelCRUD;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author fares
 */
public class AfficherHotelController implements Initializable {

    @FXML
    private TextField inputRech;
    @FXML
    private Button supp;
    @FXML
    private Button supp1;
    @FXML
    private Button Ajouter;
    @FXML
    private TableView<Hotel> tableview;
    @FXML
    private TableColumn<?, ?> nom_hotel;
    @FXML
    private TableColumn<?, ?> nbetoile;
    @FXML
    private TableColumn<?, ?> nbchambre;
    @FXML
    private TableColumn<?, ?> nbrestaurant;
    @FXML
    private TableColumn<?, ?> nbpiscine;
    @FXML
    private TableColumn<?, ?> adresse_rest;
    @FXML
    private TableColumn<?, ?> villehotel;
public ObservableList<Hotel> list;
 public static Hotel connectedHotel;
HotelCRUD cs = new HotelCRUD();
    @FXML
    private Hyperlink restau;
    @FXML
    private Button AFFEtoile;
    @FXML
    private Button AFF21;
    @FXML
    private Button pdf2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         HotelCRUD pss = new HotelCRUD();
        ArrayList<Hotel> c = new ArrayList<>();
        c = (ArrayList<Hotel>) pss.afficherHotels();
        
        ObservableList<Hotel> obs2 = FXCollections.observableArrayList(c);
        tableview.setItems(obs2);
        
        
 //idhotel.setCellValueFactory(new PropertyValueFactory<>("idhotel"));
        nom_hotel.setCellValueFactory(new PropertyValueFactory<>("nom_hotel"));
        nbetoile.setCellValueFactory(new PropertyValueFactory<>("nbetoile"));
        nbchambre.setCellValueFactory(new PropertyValueFactory<>("nbchambre"));
        nbrestaurant.setCellValueFactory(new PropertyValueFactory<>("nbrestaurant"));
        nbpiscine.setCellValueFactory(new PropertyValueFactory<>("nbpiscine"));
        adresse_rest.setCellValueFactory(new PropertyValueFactory<>("adresse_rest"));
        villehotel.setCellValueFactory(new PropertyValueFactory<>("villehotel"));
        
        
            try {
            list = FXCollections.observableArrayList(
                    pss.afficherHotels()
            );        
        
        
   FilteredList<Hotel> filteredData = new FilteredList<>(list, e -> true);
            inputRech.setOnKeyReleased(e -> {
                inputRech.textProperty().addListener((ObservableValue, oldValue, newValue) -> {
                    filteredData.setPredicate((Predicate<? super Hotel>) Hotels -> {
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        String lower = newValue.toLowerCase();
                        if (Hotels.getNom_hotel().toLowerCase().contains(lower)) {
                            return true;
                        }

                        return false;
                    });
                });
                SortedList<Hotel> sortedData = new SortedList<>(filteredData);
                sortedData.comparatorProperty().bind(tableview.comparatorProperty());
                tableview.setItems(sortedData);
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }    

    
        public void resetTableData() throws SQLDataException, SQLException {

        List<Hotel> listevents = new ArrayList<>();
        listevents = cs.afficherHotels();
        ObservableList<Hotel> data = FXCollections.observableArrayList(listevents);
        tableview.setItems(data);
    }    
    
    
    @FXML
    private void supp(ActionEvent event) throws SQLException {
        
        if (event.getSource() == supp) {
            Hotel e = new Hotel();
            e.setIdhotel(tableview.getSelectionModel().getSelectedItem().getIdhotel());  
            HotelCRUD cs = new HotelCRUD();
            cs.supprimerHotel(e);
            resetTableData();  
        
               TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle("Vous avez Supprimé un evenement");
            tray.setMessage("");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(3000));
        
    }  
        
        
    }

    @FXML
    private void Modif(ActionEvent event) throws IOException {
            HotelCRUD ps = new HotelCRUD();
    
        Hotel c = new Hotel(tableview.getSelectionModel().getSelectedItem().getIdhotel(),
                tableview.getSelectionModel().getSelectedItem().getNom_hotel(),
                tableview.getSelectionModel().getSelectedItem().getNbetoile(),
                 tableview.getSelectionModel().getSelectedItem().getNbchambre(),
                tableview.getSelectionModel().getSelectedItem().getNbrestaurant(),
               tableview.getSelectionModel().getSelectedItem().getNbpiscine(),
                tableview.getSelectionModel().getSelectedItem().getAdresse_rest(),
                    tableview.getSelectionModel().getSelectedItem().getVillehotel()
                );
        AfficherHotelController.connectedHotel = c;
        
             Parent page1 = FXMLLoader.load(getClass().getResource("ModifierHotel.fxml"));
        Scene scene = new Scene(page1, 1144, 741);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
        
        
    }

    @FXML
    private void Ajouter(ActionEvent event) throws IOException {
           Parent page1 = FXMLLoader.load(getClass().getResource("AjouterHotel.fxml"));
        Scene scene = new Scene(page1, 805, 716);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Ajouter un Hotel");
        stage.setScene(scene);
        stage.show();
        
        
        
    }

    @FXML
    private void restau(ActionEvent event) throws IOException {
             Parent page1 = FXMLLoader.load(getClass().getResource("AfficherRestaurant.fxml"));
        Scene scene = new Scene(page1, 1236, 785);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Ajouter un Hotel");
        stage.setScene(scene);
        stage.show();
    }
    
      public void AfficheParEtoileTrié() throws SQLDataException, SQLException {

        List<Hotel> listevents = new ArrayList<>();
        listevents = cs.afficherHotelsByEtoile();
        ObservableList<Hotel> data = FXCollections.observableArrayList(listevents);
        tableview.setItems(data);
    }    

  public void AfficheParVilleTrié() throws SQLDataException, SQLException {

        List<Hotel> listevents = new ArrayList<>();
        listevents = cs.afficherHotelsByVille();
        ObservableList<Hotel> data = FXCollections.observableArrayList(listevents);
        tableview.setItems(data);
    }   
    
    

    @FXML
    private void AFFEtoile(ActionEvent event) throws SQLException {
        AfficheParEtoileTrié();
        
    }

    @FXML
    private void AFF21(ActionEvent event) throws SQLException {
        AfficheParVilleTrié();
        
    }
 private void printPDF() throws FileNotFoundException, DocumentException, IOException {
        ;
        Document d = new Document();
        PdfWriter.getInstance(d, new FileOutputStream("C:\\Users\\21658\\Desktop\\ListHotels.pdf"));
        d.open();
        d.add(new Paragraph("Liste des Hotels"));
       
        PdfPTable pTable = new PdfPTable(1);
       
     //   pTable.addCell("NomEvent");
     
        
        tableview.getItems().forEach((t) -> {
            pTable.addCell(String.valueOf(t.getNom_hotel()));
            //pTable.addCell(t.getNomEvent());
          //  pTable.addCell(t.getDescriptionEvent());
            
            try {
                d.add(pTable);
            } catch (DocumentException ex) {
                System.out.println(ex);
            }
        });
        
        
        d.close();
        Desktop.getDesktop().open(new File("C:\\Users\\21658\\Desktop\\ListHotels.pdf"));

    } 
    @FXML
    private void pdf2(ActionEvent event) throws DocumentException, IOException {
              if (event.getSource() == pdf2) {
            
             printPDF();
            
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.SLIDE;
            tray.setAnimationType(type);
            tray.setTitle("PDF");
            tray.setMessage("PDF");
            tray.setNotificationType(NotificationType.INFORMATION);//
            tray.showAndDismiss(Duration.millis(3000));
        }
        
        
        
    }
    
}
