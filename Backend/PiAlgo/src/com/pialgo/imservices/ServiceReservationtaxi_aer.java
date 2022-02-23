/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IReservationtaxi_aer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import model.Reservationtaxi_aer;
import util.maConnex;

/**
 *
 * @author DELL
 */
public class ServiceReservationtaxi_aer implements IReservationtaxi_aer {
    Connection cnx  = maConnex.getInstance().getCnx();
    
 

    @Override
    public void  ajouterReservationtaxi_aer (Reservationtaxi_aer rta) {

   String Req = "INSERT INTO `Reservationtaxi_aer`(`dateReservationtaxi_aer`, `idUtilisateur` , `idtaxi`) VALUES ('?,?,?')";
   try {
          Statement st = cnx.createStatement();
          st.executeUpdate (Req);
   }
   catch (SQLException ex) {
          ex.printStackTrace ();
   }
}
  
    @Override
    public void deleteReservationtaxi_aer (int idReservationtaxi_aer) {
            
          String Req = "DELETE FROM `Reservationtaxi_aer` WHERE (`idReservationtaxi_aer`= "+idReservationtaxi_aer+")";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate (Req);
            System.out.println("Reservation de taxi aer supprime avec succes");
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
}
    
    @Override
     public void modifierReservationtaxi_aer (Reservationtaxi_aer rta, int idReservationtaxi_aer) {
       
                try {
                    String Req = "UPDATE Reservationtaxi_aer SET dateReservationtaxi_aer=?, idUtilisateur=?, idtaxi=?  WHERE('idReservationtaxi_aer'= "+idReservationtaxi_aer+")";
                    
                    PreparedStatement ps = cnx.prepareStatement(Req);
                    ps.setString(1, rta.getDateReservationtaxi_aer());
                    ps.setInt(2, rta.getIdUtilisateur());
                    ps.setInt(3, rta.getIdtaxi());
                    {
                        System.out.println(" Reservation taxi aer modifiee avec succes");
                        
                    }        } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
}
