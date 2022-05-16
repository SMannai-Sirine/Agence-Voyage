/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.gui;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import pi.entities.Restaurant;
import pi.sevices.restaurantCRUD;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author msallemS
 */
public class AjouterRestaurantController implements Initializable {

    @FXML
    private Label welcome;
    @FXML
    private TextField nom_rest;
    @FXML
    private Button A;
    @FXML
    private Hyperlink prec;
    @FXML
    private TextField numtel_rest;
    @FXML
    private TextField adresse_rest;
    @FXML
    private TextField ville_rest;
    @FXML
    private TextField nbtable_rest;
    @FXML
    private TextField type_rest;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void insert(ActionEvent event) throws IOException, MessagingException {
         restaurantCRUD cs = new restaurantCRUD();
          if (this.nom_rest.getText().equals("")
                || adresse_rest.getText().equals("")
                || ville_rest.getText().equals("")) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Please fill all fields ");
            a.setHeaderText(null);
            a.showAndWait();} 
         
         
         
         
         Restaurant r1 = new Restaurant(this.nom_rest.getText(),Integer.parseInt(this.numtel_rest.getText()),
       adresse_rest.getText(),this.ville_rest.getText(), Integer.parseInt(this.nbtable_rest.getText())
        ,type_rest.getText());
        cs.ajouterRestaurant2(r1);
                  Parent page1 = FXMLLoader.load(getClass().getResource("AfficherRestaurant.fxml"));
        Scene scene = new Scene(page1, 1236, 785);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Liste des Hotels");
        stage.setScene(scene);
        stage.show();
        
           TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle("Vous avez Ajouté un nouveau Restaurant");
            tray.setMessage("");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(3000));
            
            
           try {
                                   sendMail("mohamedmalek.m'sallem@esprit.tn");
                               
                                   
                                
                                } catch (MessagingException ex) {
                                }  
            
            
          
    }

    @FXML
    private void prec(ActionEvent event) throws IOException {
              Parent page1 = FXMLLoader.load(getClass().getResource("AfficherRestaurant.fxml"));
        Scene scene = new Scene(page1, 1236, 785);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Liste des Restaurant");
        stage.setScene(scene);
        stage.show();
        
        
        
        
    }
    public static void sendMail(String recipient) throws MessagingException {
        System.out.println("Preparing to send email");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        String myAccountEmail = "pialgo11@gmail.com";
        String password = "pialgo5683@";
        Session session = Session.getInstance(properties, new Authenticator() {
             @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(myAccountEmail, password);
            }
        });
            
        Message message = prepareMessage(session, myAccountEmail, recipient);

        Transport.send(message);
        System.out.println("Message sent successfully");
    }  
   
    
    private static Message prepareMessage(Session session, String myAccountEmail, String recipient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Vous Avez Ajouté un nouveau Restaurant");
            message.setText("Vous Avez Ajouté un nouveau Restaurant");
            return message;
        } catch (MessagingException ex) {
          
        }
        return null;
    }  
    
    
    
    
}
