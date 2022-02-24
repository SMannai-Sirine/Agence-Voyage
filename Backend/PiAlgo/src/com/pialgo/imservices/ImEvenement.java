/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pialgo.imservices;

import com.pialgo.Iservices.Iservices;
import com.pialgo.bd.Connection_Bd;
import com.pialgo.entities.Evenement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sirine
 */
public class ImEvenement implements Iservices<Evenement> {

    // instantiation de base de donne pour acceder aux outils de sql , 
        Connection cnx = Connection_Bd.getInstance().getCnx();

    @Override
    public void ajouter(Evenement t) {
                        try {
            String req = "INSERT INTO evenement (intitule, paysEvent,adresse,dateEvent,typeEvent,photo) VALUES (?,?,?,?,?,?)";
                            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, t.getIntitule());
            pst.setString(2, t.getPaysEvent());
            pst.setString(3, t.getAdresse());
            pst.setString(4, t.getDateEvent());
            pst.setString(5, t.getTypeEvent());
            pst.setString(6, t.getPhoto());

            pst.executeUpdate();
            System.out.println("Event ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


       }

    @Override
    public void Edit(Evenement t) {
                  try{
            String req = "UPDATE evenement SET intitule=?,paysEvent=?,adresse=?,dateEvent=?,typeEvent=?,photo=? WHERE idEvent=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(7, t.getIdEvent());
            pst.setString(1, t.getIntitule());
            pst.setString(2, t.getPaysEvent());
            pst.setString(3, t.getAdresse());
            pst.setString(4, t.getDateEvent());
            pst.setString(5, t.getDateEvent());
            pst.setString(6, t.getPhoto());
            pst.executeUpdate();
            System.out.println("Evenement modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public List<Evenement> Show() {
        List<Evenement> list = new ArrayList<>();
                List<typeEvent> list1 = new ArrayList<>();

        try {
            String req = "SELECT * FROM evenement ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()) {
                list.add(new Evenement(rs.getInt("idEvent"),rs.getString("intitule"),rs.getString("paysEvent"),rs.getString("adresse"),rs.getString("dateEvent"),rs.getString("typeEvent"),rs.getString("photo")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
        }

    @Override
    public void supprimer(Evenement t) {
         try {
            String req = "DELETE FROM evenement where idEvent=" + t.getIdEvent();
             Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("event supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void countUser(Evenement t) {
         try {
            String req = "SELECT count(*) as nombre FROM ticket where idEvent=" + t.getIdEvent();
             Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()) {
                System.out.println(rs.getInt("nombre"));
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
}
