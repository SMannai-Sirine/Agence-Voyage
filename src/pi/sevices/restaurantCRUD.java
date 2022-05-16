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
    
//         rst.getInt("id_rest")
//                    , rst.getString("nom_rest")
//                    , rst.getInt("numtel_rest")
//                    , rst.getString("adresse_rest")
//                    , rst.getString("ville_rest")
//                    , rst.getInt("nbtable_rest")
//                    , rst.getString("type_rest")
//    
//    
    
    public void ajouterRestaurant2(Restaurant R){
        try {
            String requete2 = "INSERT INTO restaurant (nom_rest,numtel_rest,adresse_rest,ville_rest,nbtable_rest,type_rest)"
                    + "VALUES (?,?,?,?,?,?)" ;
            PreparedStatement rst = cnx2.prepareStatement(requete2);
     rst.setString(1, R.getNom_rest());
     rst.setLong(2, R.getNumtel_rest());
     rst.setString(3, R.getAdresse_rest());
     rst.setString(4, R.getVille_rest());
     rst.setInt(5, R.getNbtable_rest());
     rst.setString(6, R.getType_rest());
     rst.executeUpdate();
     System.out.println("votre restaurant est ajoutee");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
         
    }
//    
//     id_rest.setCellValueFactory(new PropertyValueFactory<>("id_rest"));
//        nom_rest.setCellValueFactory(new PropertyValueFactory<>("nom_rest"));
//        adresse_rest.setCellValueFactory(new PropertyValueFactory<>("adresse_rest"));
//        numtel_rest.setCellValueFactory(new PropertyValueFactory<>("numtel_rest"));
//        ville_rest.setCellValueFactory(new PropertyValueFactory<>("ville_rest"));
//        nbtable_rest.setCellValueFactory(new PropertyValueFactory<>("nbtable_rest"));
//        type_rest.setCellValueFactory(new PropertyValueFactory<>("type_rest"));
//    
        public List<Restaurant> afficherRestaurantss2() throws SQLException {

        List<Restaurant> evenements = new ArrayList<>();
        String req = "select * from restaurant ";
        Statement stm = cnx2.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Restaurant e = new Restaurant(
                     rst.getInt("id_rest")
                    , rst.getString("nom_rest")
                    , rst.getInt("numtel_rest")
                    , rst.getString("adresse_rest")
                    , rst.getString("ville_rest")
                    , rst.getInt("nbtable_rest")
                    , rst.getString("type_rest")
                    
                   );
            evenements.add(e);
        }
        return evenements;
    }
     
    public List<Restaurant> afficherRestaurants(){
                    List<Restaurant> myList = new ArrayList<>();

        try {
            String requete3 = "select * from restaurant";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()){
                Restaurant r = new Restaurant();
                r.setId_rest(rs.getInt(1));
                r.setNom_rest(rs.getString("nom_rest"));
                r.setNumtel_rest(rs.getLong("numtel_rest"));
                r.setAdresse_rest(rs.getString("adresse_rest"));
                r.setVille_rest(rs.getString("ville_rest"));
                r.setNbtable_rest(rs.getInt("nbtable_rest"));
                r.setType_rest(rs.getString("type_rest"));
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
            String req ="delete from restaurant where id_rest= " + r.getId_rest();
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
            String requete2 = "update restaurant set nom_rest=?,numtel_rest=?,adresse_rest=?,ville_rest=?,nbtable_rest=?,type_rest=? where id_rest=?";
                    
            
            PreparedStatement rst = cnx2.prepareStatement(requete2);
            rst.setInt(7,r.getId_rest());
            rst.setString(1, r.getNom_rest());
            rst.setLong(2, r.getNumtel_rest());
            rst.setString(3, r.getAdresse_rest());
            rst.setString(4, r.getAdresse_rest());
            rst.setInt(5, r.getNbtable_rest());
            rst.setString(6, r.getType_rest());
            rst.executeUpdate();
            System.out.println("votre restaurant est modifiéé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
