/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
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
public class AjouterHotelController implements Initializable {

    @FXML
    private Label welcome;
    @FXML
    private TextField nom_hotel;
    @FXML
    private Button A;
    @FXML
    private Hyperlink prec;
    @FXML
    private TextField nbchambre;
    @FXML
    private TextField nbrestaurant;
    @FXML
    private TextField nbpiscine;
    @FXML
    private TextField adresse_rest;
    @FXML
    private TextField villehotel;
    @FXML
    private ComboBox<String> nbetoile;
    File file;
    @FXML
    private Button ajouter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nbetoile.getItems().add("1");
        nbetoile.getItems().add("2");
        nbetoile.getItems().add("3");
        nbetoile.getItems().add("4");
        nbetoile.getItems().add("5");
        
        
        // TODO
    }    

    @FXML
    private void insert(ActionEvent event) throws IOException {
 //   String adresse_rest, String villehotel) {
           HotelCRUD productService = new HotelCRUD();

      if (this.nom_hotel.getText().equals("")
                || adresse_rest.getText().equals("")
                || villehotel.getText().equals("")) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Please fill all fields ");
            a.setHeaderText(null);
            a.showAndWait();} 
             FileInputStream fl = new FileInputStream(file);

            byte[] data = new byte[(int) file.length()];
            String fileName = file.getName();
            String path = fileName;
            fl.read(data);
            fl.close();
      Hotel h1= new Hotel(nom_hotel.getText(),Integer.parseInt(nbetoile.getValue()),
              Integer.parseInt(nbchambre.getText()),Integer.parseInt(nbrestaurant.getText()),
              Integer.parseInt(nbpiscine.getText()),
              adresse_rest.getText(),villehotel.getText(),path)      ;
              
         productService.ajouterHotel2(h1);
           
                  Parent page1 = FXMLLoader.load(getClass().getResource("AfficherHotel.fxml"));
        Scene scene = new Scene(page1, 1236, 785);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Liste des Hotels");
        stage.setScene(scene);
        stage.show();
        
           TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle("Vous avez Ajouté un nouveau Hotel");
            tray.setMessage("");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(3000));
            
             
        
        
    }

    @FXML
    private void prec(ActionEvent event) throws IOException {
              Parent page1 = FXMLLoader.load(getClass().getResource("AfficherHotel.fxml"));
        Scene scene = new Scene(page1, 1236, 785);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Liste des Hotels");
        stage.setScene(scene);
        stage.show();
        
        
        
    }

    @FXML
    private File ajouter_image(ActionEvent event) {
        Path to1 = null;
        String m = null;
        String path = "C:\\Users\\21658\\Desktop\\connexionJDBC\\src\\pi\\img";
        JFileChooser chooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & PNG Images", "jpg", "jpeg", "PNG");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            m = chooser.getSelectedFile().getAbsolutePath();

            file = chooser.getSelectedFile();
            String fileName = file.getName();

            if (chooser.getSelectedFile() != null) {

                try {
                    Path from = Paths.get(chooser.getSelectedFile().toURI());
                    to1 = Paths.get(path + "\\" + fileName);
                    //           to2 = Paths.get("src\\"+path+"\\"+file.getName()+".png");

                    CopyOption[] options = new CopyOption[]{
                        StandardCopyOption.REPLACE_EXISTING,
                        StandardCopyOption.COPY_ATTRIBUTES
                    };
                    Files.copy(from, to1, options);
                    System.out.println("added");
                    System.out.println(file);

                } catch (IOException ex) {
                    System.out.println();
                }
            }

        }
         System.out.println(file.getPath());
        return file;
    }
    
}
