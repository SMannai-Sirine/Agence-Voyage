/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IreservationCroisiere;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.ReservationCroisiere;
import util.maConnexion;

/**
 *
 * @author Sémia
 */
public class ServiceReservationCroisiere implements IreservationCroisiere{
    
       //var
    Connection cnx = maConnexion.getInstance().getCnx();

    @Override
    public void ajouterReservationCroisiere(ReservationCroisiere rC){
       
        String request = "INSERT INTO `reservationCroisiere`(`dateReservationCroisiere`, `idU`, `idCroisiere`) VALUES ('"+rC.getDateReservationCroisiere()+"','"+rC.getIdUtilisateur()+"','"+rC.getIdCroisiere()+"')";
        String req1= "UPDATE `croisiere` SET `nbCabines` = (`nbCabines`-1) WHERE (`idCroisiere` = "+rC.getIdCroisiere()+")";
        
            try {
                Statement st = cnx.createStatement();
                st.executeUpdate(request);
                st.executeUpdate(req1);
                System.out.println("RéservationCroisiere effectuée avec succès"); 
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("La réservationCroisiere n'a pas été ajoutée");
            }       
    }
    
    
    
       @Override
    public void modifierReservationCroisiere (int idReservationCroisiere,int newIdCroisiere){
        
    String req1= "UPDATE `croisiere` SET `nbCabines`= (`nbCabines`+1) WHERE (`idCroisiere` =(SELECT `idCroisiere` FROM `reservationCroisiere` WHERE(`idReservationCroisiere`="+idReservationCroisiere+")))"; //pour rendre un siege dans le vol d'origine    
    String req2 = "UPDATE `reservationCroisiere` SET `idCroisiere`='"+newIdCroisiere+"' WHERE(`idReservationCroisiere`= "+idReservationCroisiere+")";
    String req3= "UPDATE `croisiere` SET `nbCabines` = (`nbCabines`-1) WHERE (`idCroisiere` ="+newIdCroisiere+")";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req1);
            st.executeUpdate(req2);
            st.executeUpdate(req3);
            System.out.println("RéservationCroisiere modifiée avec succès");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("La réservationCroisiere n'a pas été modifiée");
        }
    }
    
    
    @Override
    public void supprimerReservationCroisiere (int idReservationCroisiere){
        
    String requ = "DELETE FROM `reservationCroisiere` WHERE (`idReservationCroisiere`= "+idReservationCroisiere+")";
    String req1= "UPDATE `croisiere` SET `nbCabines` = (`nbCabines` +1) WHERE (`idCroisiere` = (SELECT `idCroisiere` FROM `reservationCroisiere` WHERE (`idReservationCroisiere`= "+idReservationCroisiere+")))";
       
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(requ);
            st.executeUpdate(req1);
            System.out.println("RéservationCroisiere supprimée avec succès");
           
            }catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("La réservationCroisiere n'a pas été supprimée");
            }        
    }
    
    
    @Override
    public List<ReservationCroisiere> afficherReservationCroisiere(){
        
        List<ReservationCroisiere> reservationCroisieres = new ArrayList<>();
        
        String query = "SELECT * FROM reservationCroisiere";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                reservationCroisieres.add(new ReservationCroisiere(rs.getString(1), rs.getInt("idU"), rs.getInt("idCroisiere")));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return reservationCroisieres;
    
    }
    
}
