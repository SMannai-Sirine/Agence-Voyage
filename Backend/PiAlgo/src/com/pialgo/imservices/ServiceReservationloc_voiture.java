/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IReservationloc_voiture;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import model.Reservationloc_voiture;
import util.maConnex;

/**
 *
 * @author DELL
 */

public class ServiceReservationloc_voiture implements IReservationloc_voiture {
    Connection cnx  = maConnex.getInstance().getCnx();
    
 

    @Override
    public void  ajouterReservationloc_voiture (Reservationloc_voiture rlv) {

   String Req = "INSERT INTO `Reservationloc_voiture`(`dateReservationloc_voiture`, `idUtilisateur` , `idvoiture`) VALUES ('?,?,?')";
   try {
          Statement st = cnx.createStatement();
          st.executeUpdate (Req);
   }
   catch (SQLException ex) {
          ex.printStackTrace ();
   }   
}
    
   
    @Override
    public void deleteReservationloc_voiture (int idReservationloc_voiture) {
            
          String Req = "DELETE FROM `Reservationloc_voiture` WHERE (`idReservationloc_voiture`= "+idReservationloc_voiture+")";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate (Req);
            System.out.println("Reservation de loc voiture supprime avec succes");
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
}
    
     public void modifierReservationloc_voiture (Reservationloc_voiture rlv, int idReservationloc_voiture) {
       
                try {
                    String Req = "UPDATE Reservationloc_voiture SET dateReservationloc_voiture=?, idUtilisateur=?, idvoiture=?  WHERE('idReservationloc_voiture'= "+idReservationloc_voiture+")";
                    
                    PreparedStatement ps = cnx.prepareStatement(Req);
                    ps.setString(1, rlv.getDateReservationloc_voiture());
                    ps.setInt(2, rlv.getIdUtilisateur());
                    ps.setInt(3, rlv.getIdvoiture());
                    {
                        System.out.println(" Reservation loc_voiture modifiee avec succes");
                        
                    }        } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
    
    
    
    
    
    
    
    
    
    
    
    }

  


 
