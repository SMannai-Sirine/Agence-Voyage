/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Iloc_voiture;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.loc_voiture;
import util.maConnexion;

/**
 *
 * @author DELL
 */
public class Serviceloc_voiture implements Iloc_voiture {
    //var
Connection cnx  = maConnexion.getInstance().getCnx();
    
    @Override
    public void ajouterloc_voiture(loc_voiture v) {
        String Req = "INSERT INTO `loc_voiture`(`date_res`, `dure_res`, `pays_des`, `type_dem` , `prix` ) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(Req);
            ps.setString(1, v.getDate_res());
            ps.setString(2, v.getDure_res());
            ps.setString(3, v.getPays_des());
            ps.setString(4, v.getType_dem());
            ps.setFloat(5, v.getPrix());
            ps.executeUpdate();
            System.out.println(" loc_voiture ajoutee avec succes");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }



@Override
    public void ajouterloc_voiture2(loc_voiture v) {
        String Req = "INSERT INTO loc_voiture`(`date_res`, `dure_res`, `pays_des`, `type_dem` , `prix` ) VALUES (?,?,?,?,?)";
        if (v.getDure_res()> 15) 
        {
            int prix_remise;
            prix_remise = (int) (v.getPrix() - (v.getPrix() *20 /100));
            v.setPrix(prix_remise);
        }
        
        try {
            PreparedStatement ps = cnx.prepareStatement(Req);
            ps.setString(1, v.getDate_res());
            ps.setString(2, v.getDure_res());
            ps.setString(3, v.getPays_des());
            ps.setString(4, v.getType_dem());
            ps.setFloat(5, v.getPrix());
            ps.execute();
            System.out.println("2: loc_voiture ajoutee avec succes");
        } catch (SQLException ex) {
            System.out.println("voiture non ajoute");
        }
    }
    @Override
    public List<loc_voiture> afficherloc_voiture() {
        List<loc_voiture> voitures = new ArrayList<>();
        
        String query = "SELECT * FROM `local_voiture` ";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                loc_voiture.add(new loc_voiture (rs.getInt("idvoiture"), rs.getString(2), rs.getString(3) ,rs.getString(4), rs.getString(5) , rs.getFloat(6)));
            }
            
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
        return voitures;
    }


@Override
        public void deleteloc_voiture (int idvoiture) {
            
          String Req = "DELETE FROM `loc_voiture` WHERE (`idvoiture`= "+idvoiture+")";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate (Req);
            System.out.println("loc_voiture supprime avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        }      
    
     
            
         @Override
     public void modifierloc_voiture (loc_voiture v, int idvoiture) {
       
                try {
                    String Req = "UPDATE loc_voiture SET date_res=?, dure_res=?, pays_des=? , type_dem=? prix=?  WHERE('idvoiture'= "+idvoiture+")";
                    
                    PreparedStatement ps = cnx.prepareStatement(Req);
                    ps.setString(1, v.getDate_res());
                    ps.setString(2, v.getDure_res());
                    ps.setString(3, v.getPays_des());
                    ps.setString(4, v.getType_dem());
                    ps.setFloat(5, v.getPrix());
                    {
                        System.out.println(" loc_voiture modifiee avec succes");
                        
                    }        } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }

    @Override
    public void afficherloc_voiture(loc_voiture v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     }



    



    