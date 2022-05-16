/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pi.gui;


import pi.entities.Hotel;
import javax.mail.PasswordAuthentication;
import pi.entities.Reservation;
import pi.gui.ItemController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import pi.sevices.HotelCRUD;
import javafx.scene.image.Image;

import static com.sun.media.jfxmediaimpl.MediaUtils.error;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import pi.sevices.reservationCRUD;
import java.io.File;
import java.sql.Date;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.DatePicker;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * FXML Controller class
 *
 * @author pc
 */
public class FrontController implements Initializable {

    @FXML
    private VBox chosenplat;
    @FXML
    private Label prenom;

    private Label zone;

    @FXML
    private Button but;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;

    private List<Hotel> listArt = new ArrayList<>();
    private MyListener myListener;
    Hotel liv = new Hotel();
    @FXML
    private ImageView img;
    private TextField tfMethod;
    private TextField tfIdClient;
    private TextField tfIdProd;
    private TextField tfAdresse;
    @FXML
    private Label error;
    reservationCRUD sl = new reservationCRUD();
    @FXML
    private Label cin;
    Random rn = new Random();
    int randomNumber = rn.nextInt(3) + 1;
    @FXML
    private ImageView cap;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfchambres;
    @FXML
    private DatePicker date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showScreen();
       
    }

    private void setChosenPlat(Hotel livreur) {

        String path = "/pi/img/" + livreur.getImage();
        Image image = new Image(getClass().getResourceAsStream(path));
        System.out.println("test");

        System.out.println("test1");
        prenom.setText(livreur.getNom_hotel());
       
        img.setImage(image);
        cin.setText("" + livreur.getIdhotel());
        System.out.println("test2");

        chosenplat.setStyle("-fx-background-radius: 30;");
    }

    public void showScreen() {
        HotelCRUD sl = new HotelCRUD();
        listArt.addAll(sl.afficherHotels());

        if (listArt.size() > 0) {
            setChosenPlat(listArt.get(0));

            myListener = new MyListener() {
                @Override
                public void onClickListener(Hotel nomp) {
                    setChosenPlat(nomp);
                    liv.setIdhotel(nomp.getIdhotel());
                    liv.setNom_hotel(nomp.getNom_hotel());
                    liv.setNbetoile(nomp.getNbetoile());
                    liv.setNbchambre(nomp.getNbchambre());
                    liv.setImage(nomp.getImage());
                    liv.setNbrestaurant(nomp.getNbrestaurant());
                    liv.setNbpiscine(nomp.getNbpiscine());
                    liv.setAdresse_rest(nomp.getAdresse_rest());
                    liv.setVillehotel(nomp.getVillehotel());
                  

                }

            };
        }

        int column = 0;
        int row = 1;
        grid.getChildren().clear();
        try {
            for (int i = 0; i < listArt.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/pi/gui/LivreurItem.fxml"));
                AnchorPane abc = fxmlLoader.load();
                ItemController platController = fxmlLoader.getController();
                platController.setData(listArt.get(i), myListener);

                if (column == 1) {
                    column = 0;
                    row++;
                }

                grid.add(abc, column++, row); //(child,column,row)
                //set grid width

                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(abc, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void ajouterLivraison(ActionEvent event)  {

        if (tfnom.getText().isEmpty() || tfchambres.getText().isEmpty() ) {
            error.setText("Verifier les entrées s'il vous plait");
        } else {// FIXME: change the id user from 1 to the current logged in user.

            sl.ajouterHotel2(new Reservation((Integer.parseInt(cin.getText())), tfnom.getText(), Integer.parseInt(tfchambres.getText()), java.sql.Date.valueOf(date.getValue())));

               
           
                    
                    
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    sendEmail();
                    alert.setTitle("Livraison added");
                    alert.setContentText("Livraison added succesfuuly!");
                 
            }
          
        
        }
    

    public void sendEmail() {
        String to = "mednabil.kallel@esprit.tn";
        String from = "hamatalbi9921@gmail.com";
        String host = "smtp.gmail.com";
        final String username = "hamatalbi9921@gmail.com";
        final String password = "123456789hama";

        //setup mail server
        Properties props = System.getProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            //create mail
            MimeMessage m = new MimeMessage(session);
            m.setFrom(new InternetAddress(from));
            m.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
            m.setSubject("TheAces");
            m.setText("Une Livraison a été ajouté:\n methode de paiment : " + tfMethod.getText() + "\nid du produit : " + tfIdProd.getText() + "\n id client : " + tfIdClient.getText() + "\nadresse du client : " + tfAdresse.getText() + "\nCin livreur : " + cin.getText() + "\nZone : " + zone.getText());

            Transport.send(m);

            System.out.println("Message sent!");

        } catch (MessagingException e) {
            e.printStackTrace();
//        } catch (SQLException ex) {
//            Logger.getLogger(RestPasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
