/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Itaxi_aer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.taxi_aer;
import util.maConnexion;

/**
 *
 * @author DELL
 */
public class Servicetaxi_aer implements Itaxi_aer {
    
   
    //var
            Connection cnx = maConnexion.getInstance().getCnx();
    
    
        @Override
    public void ajoutertaxi_aer(taxi_aer t) {
        String Req = "INSERT INTO `taxi_aer`(`taxi_matr`, `heure_arr`, `pays_des`,`prix` ) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(Req);
            ps.setString(1, t.getTaxi_matr());
            ps.setString(2, t.getHeure_arr());
            ps.setString(3, t.getPays_des());
            ps.setFloat(4, t.getPrix());
            ps.executeUpdate();
            System.out.println(" taxi_aer ajoutee avec succes");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    

        @Override
    public void ajoutertaxi_aer2(taxi_aer t) {
        String Req = "INSERT INTO `taxi_aer`(`taxi_matr`, `heure_arr`, `pays_des`,`prix` ) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(Req);
            ps.setString(1, t.getTaxi_matr());
            ps.setString(2, t.getHeure_arr());
            ps.setString(3, t.getPays_des());
            ps.setFloat(4, t.getPrix());
            ps.executeUpdate();
            System.out.println("2: taxi_aer ajoutee avec succes");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
                    
        @Override
    public List<taxi_aer> affichertaxi_aer() {
         List<taxi_aer> taxis = new ArrayList<> () ;
                    
         String query = "SELECT * FROM taxi_aer" ;
                 
          try {
                Statement st= cnx.createStatement ();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) { 
                     taxi_aer.add(new taxi_aer(rs.getInt("idtaxi"), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5)));
                 }
                    
                    return taxis ;
                } catch (SQLException ex) {
                }
                return taxis ;
    }
                    
            @Override
        public void deletetaxi_aer (int idtaxi) {
            
          String Req = "DELETE FROM `taxi_aer` WHERE (`idtaxi`= "+idtaxi+")";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate (Req);
            System.out.println(" taxi_aer supprime avec succes ");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        } 

                             @Override
     public void modifiertaxi_aer (taxi_aer t, int idtaxi) {
       
                try {
                    String Req = "UPDATE taxi_aer SET taxi_matr=?, heure_arr=?, pays_des=? prix=?  WHERE('idtaxi'= "+idtaxi+")";
                    
                    PreparedStatement ps = cnx.prepareStatement(Req);
                    ps.setString(1, t.getTaxi_matr());
                    ps.setString(2, t.getHeure_arr());
                    ps.setString(3, t.getPays_des());
                    ps.setFloat(4, t.getPrix());
                    {
                        System.out.println(" loc_voiture modifiee avec succes");
                        
                    }        } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }

    @Override
    public void affichertaxi_aer(taxi_aer t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    }
    

