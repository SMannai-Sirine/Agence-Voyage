/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IreservationVol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.ReservationVol;
import util.maConnexion;

/**
 *
 * @author Sémia
 */
public class ServiceReservationVol implements IreservationVol{
    
    //var
    Connection cnx = maConnexion.getInstance().getCnx();

    @Override
    public void ajouterReservationVol(ReservationVol rV){
        
        String request = "INSERT INTO `reservationVol`( `idU`,`idVol`) VALUES ('"+rV.getIdUtilisateur()+"','"+rV.getIdVol()+"')";
        String req1= "UPDATE `Vol` SET `nbSieges` = (`nbSieges`-1) WHERE (`idVol` = "+rV.getIdVol()+")";
        
            try {
                Statement st = cnx.createStatement();
                st.executeUpdate(request);
                st.executeUpdate(req1);
                System.out.println("RéservationVol effectuée avec succès"); 
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("La réservationVol n'a pas été ajoutée");
            }       
    }
    
    @Override
    public void modifierReservationVol (int idReservationVol,int newIdVol){
        
    String req1= "UPDATE `vol` SET `nbSieges`= (`nbSieges`+1) WHERE (`idVol` =(SELECT `idVol` FROM `reservationVol` WHERE(`idReservationVol`="+idReservationVol+")))"; //pour rendre un siege dans le vol d'origine    
    String req2 = "UPDATE `reservationVol` SET `idVol`='"+newIdVol+"' WHERE(`idReservationVol`= "+idReservationVol+")";
    String req3= "UPDATE `vol` SET `nbSieges` = (`nbSieges`-1) WHERE (`idVol` ="+newIdVol+")";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req1);
            st.executeUpdate(req2);
            st.executeUpdate(req3);
            System.out.println("RéservationVol modifiée avec succès");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("La réservationVol n'a pas été modifiée");
        }
    }
    
    
    @Override
    public void supprimerReservationVol (int idReservationVol){
        
    String requ = "DELETE FROM `reservationVol` WHERE (`idReservationVol`= "+idReservationVol+")";
    String req1= "UPDATE `Vol` SET `nbSieges` = (`nbSieges` +1) WHERE (`idVol` = (SELECT `idVol` FROM `reservationVol` WHERE (`idReservationVol`= "+idReservationVol+")))";
       
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(requ);
            st.executeUpdate(req1);
            System.out.println("RéservationVol supprimée avec succès");
           
            }catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("La réservationVol n'a pas été supprimée");
            }        
    }
        
    
    
    @Override
    public List<ReservationVol> afficherReservationVol(){
        
        List<ReservationVol> reservationVols = new ArrayList<>();
        
        String query = "SELECT * FROM reservationVol";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                reservationVols.add(new ReservationVol(rs.getInt("idReservationVol"), rs.getInt("idU"),rs.getInt("idVol")));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return reservationVols;
    
    }
}
    

