/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pi.gui;

import pi.entities.Hotel;
import pi.sevices.HotelCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;




/**
 * FXML Controller class
 *
 * @author pc
 */
public class ItemController implements Initializable {

    private Label priceLable;
    @FXML
    private ImageView img;
    private Hotel livreur;
    private MyListener myListener;
    @FXML
    private AnchorPane parent;
    private Label zone;
    @FXML
    private Label prenom;
    HotelCRUD livS = new HotelCRUD();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
        //
        System.out.println(livreur);
    }    

    @FXML
    private void click(MouseEvent event) {
    }
    public void setData(Hotel livreur, MyListener myListener) {
        
         String path = "/pi/img/"+livreur.getImage();
        Image image = new Image(getClass().getResourceAsStream(path));
        this.myListener = myListener;
       
        prenom.setText(livreur.getNom_hotel());
        img.setImage(image);
        this.livreur = livreur;
       
        //Image image = new Image(getClass().getResourceAsStream(plat.getImg()));
        //img.setImage(image);
        
    }   

    @FXML
    private void details(MouseEvent event) {
        myListener.onClickListener(livreur);
    }

    
}
