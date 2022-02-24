/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pialgo.imservices;

import com.pialgo.Iservices.Iservices;
import com.pialgo.bd.Connection_Bd;
import com.pialgo.entities.Evenement;
import com.pialgo.entities.ticket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sirine
 */
public class ImTicket implements Iservices<ticket> {
     Connection cnx = Connection_Bd.getInstance().getCnx();

    @Override
    public void ajouter(ticket t) {
             try {
            String req = "INSERT INTO ticket (prix_tick,date_tick,event) VALUES (?,?,?)";
                            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setDouble(1, t.getPrix_tick());
            pst.setString(2, t.getDate_tick());
            pst.setInt(3,t.getEvent());
            pst.executeUpdate();
            System.out.println("ticket ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void Edit(ticket t) {
            try{
            String req = "UPDATE ticket SET prix_tick=?,date_tick=?,event=? WHERE idticket=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(4, t.getIdticket());
            pst.setDouble(1, t.getPrix_tick());
              pst.setString(2, t.getDate_tick());
              pst.setInt(3, t.getEvent());
            pst.executeUpdate();
            System.out.println("ticket modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<ticket> Show() {
         List<ticket> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM ticket";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()) {
                list.add(new ticket(rs.getInt("idticket"),rs.getDouble("prix_tick"),rs.getString("date_tick"),rs.getInt("event")));
        } }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }

    @Override
    public void supprimer(ticket t) {
          try {
            String req = "DELETE FROM ticket where idticket=" + t.getIdticket();
             Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("ticket supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
