/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pialgo.imservices;

import com.pialgo.Iservices.IserviceUtil;
import com.pialgo.Security.BCrypt;
import com.pialgo.bd.Connection_Bd;
import com.pialgo.entities.Utilisateur;
import com.pialgo.entities.role;
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
public class ImUtilisateur implements IserviceUtil<Utilisateur> {
     Connection cnx = Connection_Bd.getInstance().getCnx();

    public void registre(Utilisateur t) {
        //cryptage
       String hashed = BCrypt.hashpw(t.getMotpasse(), BCrypt.gensalt());
       
        try {
            String req = "INSERT INTO utilisateur (nom,prenom,adresse,email,motpasse,photo,role) VALUES('" + t.getNom()+"','"+t.getPrenom()+"',"
                    + "'"+t.getAdresse()+"','"+t.getEmail()+"',"
                    + "'"+hashed+"','"+t.getPhoto()+"','"+t.getRole()+"')";
            Statement st = cnx.createStatement();
            st.execute(req);
            System.out.println("Utilisateur ajoutée !");

        } catch (SQLException e) {
                        System.out.println(e.getMessage());

        }
    }

    @Override
    public void login(Utilisateur t) {
  
        try {
                      
            if( t.getEmail() !=null && t.getMotpasse() !=null ){
              
                 String req="SELECT * from utilisateur";
                 PreparedStatement pst = cnx.prepareStatement(req);
                  
                     ResultSet rs = pst.executeQuery();

                 
                 while(rs.next()) {
   
                     // comparaison et decryptage
                     if (rs.getString("email").equals(t.getEmail()) && BCrypt.checkpw(t.getMotpasse(), rs.getString("motpasse"))== true ) {
                          System.out.println(" Salut :"+rs.getString("nom")+" votre email est :"+rs.getString("email"));
                     }
                 }
            }
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    @Override
    public List<Utilisateur> affiche() {
        List<Utilisateur> list = new ArrayList<>();
        try {
            String req="SELECT * from utilisateur";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()) {
                list.add(new Utilisateur(rs.getInt("idU"),rs.getString("nom"),rs.getString("prenom"),rs.getString("adresse"),rs.getString("email"),rs.getString("motpasse"),rs.getString("photo"),role.valueOf(req)));
            }

        } catch (SQLException e) {
                        System.out.println(e.getMessage());

        }
        return list;
    }

    @Override
    public void Supprimer(Utilisateur t) {
        
        try {
             String req = "DELETE FROM utilisateur WHERE idU=?";
             PreparedStatement pst = cnx.prepareStatement(req);
             pst.setInt(1, t.getIdU());
             pst.executeUpdate();
             System.out.println("Utilisateur suprimée !");

        } catch (SQLException e) {
                        System.out.println(e.getMessage());

        }
    }

    @Override
    public void modifier(Utilisateur t) {
               String hashed = BCrypt.hashpw(t.getMotpasse(), BCrypt.gensalt());

        try {
             String reqs = "UPDATE utilisateur SET nom=?,prenom=?,adresse=?,email=?,motpasse=?, photo=?, role=? WHERE idU=?";
            PreparedStatement pst = cnx.prepareStatement(reqs);
            pst.setInt(8,t.getIdU());
            pst.setString(1,t.getNom());
            pst.setString(2,t.getPrenom());
            pst.setString(3,t.getAdresse());
            pst.setString(4,t.getEmail());
            pst.setString(5,hashed);
            pst.setString(6,t.getPhoto());
            pst.setString(7,t.getRole().name());

            pst.executeUpdate();
        } catch (SQLException ex) {
                        System.out.println(ex.getMessage());

            }
    }

    public void Edit(Utilisateur utilisateur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
