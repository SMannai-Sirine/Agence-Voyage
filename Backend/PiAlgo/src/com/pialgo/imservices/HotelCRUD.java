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
import pi.entities.Hotel;
import pi.utils.MyConnection;

/**
 *
 * @author 21658
 */
public class HotelCRUD {
    
    Connection cnx2;
    public HotelCRUD(){
        cnx2 =MyConnection.getInstance().getCnx();
    }
    public void ajouterRestaurant(){
        try {
            String requete="INSERT INTO hotel (nom_hotel,nbetoile,nbchambre,nbrestaurant,nbpiscine,adresse_rest,villehotel) "
                    + " VALUES ('Pesto',98256012,'20 Rue Morjen Marsa 2135','Tunis',8,'Pizzeria') ";
            Statement st = cnx2.createStatement();
            st.executeUpdate(requete);
            System.out.println("restaurant ajoutéé avec succes");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        
    }
    public void ajouterHotel2(Hotel H){
        try {
            String requete2 = "INSERT INTO restaurant (nom_hotel,nbetoile,nbchambre,nbrestaurant,nbpiscine,adresse_rest,villehotel)"
                    + "VALUES (?,?,?,?,?,?,?)" ;
            PreparedStatement rst = cnx2.prepareStatement(requete2);
     rst.setString(1, H.getNom_hotel());
     rst.setInt(2, H.getNbetoile());
     rst.setInt(3, H.getNbchambre());
     rst.setInt(4, H.getNbrestaurant());
     rst.setInt(5, H.getNbpiscine());
     rst.setString(6, H.getAdresse_rest());
     rst.setString(7, H.getVillehotel());
     rst.executeUpdate();
     System.out.println("votre hotel est ajoutee");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
         
    }
    public List<Hotel> afficherHotels(){
                    List<Hotel> myList = new ArrayList<>();

        try {
            String requete3 = "select * from hotel";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()){
                Hotel h = new Hotel();
                h.setIdhotel(rs.getInt(1));
                h.setNom_hotel(rs.getString("nom_hotel"));
                h.setNbetoile(rs.getInt("nbetoile"));
                h.setNbchambre(rs.getInt("nbchambre"));
                h.setNbrestaurant(rs.getString("nbrestaurant"));
                h.setNbpiscine(rs.getInt("nbpiscine"));
                h.setAdresse_rest(rs.getString("nb_table"));
                h.setVillehotel(rs.getString("nb_table"));
                myList.add(h);


                
                
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

    
    
}
