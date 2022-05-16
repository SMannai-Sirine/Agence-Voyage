/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.sevices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pi.entities.Hotel;
import pi.entities.Reservation;
import pi.utils.MyConnection;

/**
 *
 * @author 21658
 */
public class reservationCRUD {
    
    
    Connection cnx2;
    public reservationCRUD(){
        cnx2 =MyConnection.getInstance().getCnx();
    }
 public void ajouterHotel2(Reservation H){
        try {
            String requete2 = "INSERT INTO reservation (idhotel,nomreservation,chambreres,date)"
                    + "VALUES (?,?,?,?)" ;
            PreparedStatement rst = cnx2.prepareStatement(requete2);
     rst.setInt(1, H.getIdhotel());
     rst.setString(2, H.getNomreservation());
     rst.setInt(3, H.getChambreres());
     rst.setDate(4, H.getDate());
    
     rst.executeUpdate();
     System.out.println("votre Reservation est ajoutee");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
         
    }

    
    
}
