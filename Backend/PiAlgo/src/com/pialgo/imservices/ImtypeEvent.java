/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pialgo.imservices;

import com.pialgo.Iservices.Iservices;
import com.pialgo.bd.Connection_Bd;
import com.pialgo.entities.Evenement;
import com.pialgo.entities.typeEvent;
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
public class ImtypeEvent implements Iservices<typeEvent> {
     // instantiation de base de donne pour acceder aux outils de sql , 
        Connection cnx = Connection_Bd.getInstance().getCnx();

    @Override
    public void ajouter(typeEvent t) {
                    try {
            String req = "INSERT INTO typeevent (description) VALUES (?)";
                            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, t.getDescription());
            pst.executeUpdate();
            System.out.println("type Event ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void Edit(typeEvent t) {
              try{
            String req = "UPDATE typeevent SET description=? WHERE idtype=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(2, t.getIdtype());
            pst.setString(1, t.getDescription());
            pst.executeUpdate();
            System.out.println("Type evenement modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<typeEvent> Show() {
          List<typeEvent> list = new ArrayList<>(); 
        try {
            String req = "SELECT * FROM typeevent";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()) {
                list.add(new typeEvent(rs.getInt("idtype"),rs.getString("description")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
        
    }

    @Override
    public void supprimer(typeEvent t) {
         try {
            String req = "DELETE FROM typeevent where idtype=" + t.getIdtype();
             Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("type event supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }
    
}
