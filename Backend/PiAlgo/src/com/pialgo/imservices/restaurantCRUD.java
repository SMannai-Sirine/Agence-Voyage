/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.sevices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi.entities.Restaurant;
import pi.utils.MyConnection;

/**
 *
 * @author 21658
 */
public class restaurantCRUD {
    
    Connection cnx2;
    public restaurantCRUD(){
        cnx2 =MyConnection.getInstance().getCnx();
    }
    public void ajouterRestaurant(){
        try {
            String requete="INSERT INTO restaurant (nom,num_tel,adresse,ville,nb_table,type) "
                    + " VALUES ('Pesto',98256012,'20 Rue Morjen Marsa 2135','Tunis',8,'Pizzeria') ";
            Statement st = cnx2.createStatement();
            st.executeUpdate(requete);
            System.out.println("restaurant ajoutéé avec succes");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        
    }
    public void ajouterRestaurant2(Restaurant R){
        try {
            String requete2 = "INSERT INTO restaurant (nom,num_tel,adresse,ville,nb_table,type)"
                    + "VALUES (?,?,?,?,?,?)" ;
            PreparedStatement rst = cnx2.prepareStatement(requete2);
     rst.setString(1, R.getNom());
     rst.setLong(2, R.getNum_tel());
     rst.setString(3, R.getAdresse());
     rst.setString(4, R.getVille());
     rst.setInt(5, R.getNb_table());
     rst.setString(6, R.getType());
     rst.executeUpdate();
     System.out.println("votre restaurant est ajoutee");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
         
    }
    public List<Restaurant> afficherRestaurants(){
                    List<Restaurant> myList = new ArrayList<>();

        try {
            String requete3 = "select * from restaurant";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()){
                Restaurant r = new Restaurant();
                r.setId(rs.getInt(1));
                r.setNom(rs.getString("nom"));
                r.setNum_tel(rs.getLong("num_tel"));
                r.setAdresse(rs.getString("adresse"));
                r.setVille(rs.getString("ville"));
                r.setNb_table(rs.getInt("nb_table"));
                r.setType(rs.getString("nb_table"));
                myList.add(r);


                
                
            }
          
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
        
    }
    public void supprimerRestaurant(Restaurant r)
    {
        try {
            String req ="delete from restaurant where nom " + r.getNom() ;
            Statement st=cnx2.createStatement();
            st.executeUpdate(req);
            System.out.println("restaurant supprime");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void modifierRestaurant(Restaurant r)
    {
        try {
            String requete2 = "update restaurant set nom=?,num_tel=?,adresse=?,ville=?,nb_table=?,type=? where id=?";
                    
            
            PreparedStatement rst = cnx2.prepareStatement(requete2);
            rst.setInt(7,r.getId() );
            rst.setString(1, r.getNom());
            rst.setLong(2, r.getNum_tel());
            rst.setString(3, r.getAdresse());
            rst.setString(4, r.getVille());
            rst.setInt(5, r.getNb_table());
            rst.setString(6, r.getType());
            rst.executeUpdate();
            System.out.println("votre restaurant est modifiéé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
