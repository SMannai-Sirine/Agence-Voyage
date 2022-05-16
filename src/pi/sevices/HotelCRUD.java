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
    public void ajouterHotel(){
        try {
            String requete="INSERT INTO hotel (nom_hotel,nbetoile,nbchambre,nbrestaurant,nbpiscine,adresse_rest,villehotel) "
                    + " VALUES (\"regencey\",5, 320, 4,4,\"gammart 1245\",\"gammart\") ";
            Statement st = cnx2.createStatement();
            st.executeUpdate(requete);
            System.out.println("Hotel ajoutéé avec succes");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        
    }
    public void ajouterHotel2(Hotel H){
        try {
            String requete2 = "INSERT INTO hotel (nom_hotel,nbetoile,nbchambre,nbrestaurant,nbpiscine,adresse_rest,villehotel,image)"
                    + "VALUES (?,?,?,?,?,?,?,?)" ;
            PreparedStatement rst = cnx2.prepareStatement(requete2);
     rst.setString(1, H.getNom_hotel());
     rst.setInt(2, H.getNbetoile());
     rst.setInt(3, H.getNbchambre());
     rst.setInt(4, H.getNbrestaurant());
     rst.setInt(5, H.getNbpiscine());
     rst.setString(6, H.getAdresse_rest());
     rst.setString(7, H.getVillehotel());
      rst.setString(8, H.getImage());
     rst.executeUpdate();
     System.out.println("votre hotel est ajoutee");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
         
    }
    
       public List<Hotel> afficherHotelsByVille(){
                    List<Hotel> myList = new ArrayList<>();

        try {
            String requete3 = "select * from hotel order by villehotel asc ";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()){
                Hotel h = new Hotel();
                h.setIdhotel(rs.getInt(1));
                h.setNom_hotel(rs.getString("nom_hotel"));
                h.setNbetoile(rs.getInt("nbetoile"));
                h.setNbchambre(rs.getInt("nbchambre"));
                h.setNbrestaurant(rs.getInt("nbrestaurant"));
                h.setNbpiscine(rs.getInt("nbpiscine"));
                h.setAdresse_rest(rs.getString("adresse_rest"));
                h.setVillehotel(rs.getString("villehotel"));
                h.setImage(rs.getString(9));
                myList.add(h);


                
                
            }
          
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
        
    }
    
    
    
       public List<Hotel> afficherHotelsByEtoile(){
                    List<Hotel> myList = new ArrayList<>();

        try {
            String requete3 = "select * from hotel order by nbetoile desc ";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()){
                Hotel h = new Hotel();
                h.setIdhotel(rs.getInt(1));
                h.setNom_hotel(rs.getString("nom_hotel"));
                h.setNbetoile(rs.getInt("nbetoile"));
                h.setNbchambre(rs.getInt("nbchambre"));
                h.setNbrestaurant(rs.getInt("nbrestaurant"));
                h.setNbpiscine(rs.getInt("nbpiscine"));
                h.setAdresse_rest(rs.getString("adresse_rest"));
                h.setVillehotel(rs.getString("villehotel"));
                h.setImage(rs.getString(9));
                myList.add(h);


                
                
            }
          
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
        
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
                h.setNbrestaurant(rs.getInt("nbrestaurant"));
                h.setNbpiscine(rs.getInt("nbpiscine"));
                h.setAdresse_rest(rs.getString("adresse_rest"));
                h.setVillehotel(rs.getString("villehotel"));
                h.setImage(rs.getString(9));
                myList.add(h);


                
                
            }
          
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
        
    }
    public void supprimerHotel(Hotel h)
    {
        try {
            String req =" delete from hotel where idhotel=   " +h.getIdhotel()  ;
            Statement st=cnx2.createStatement();
            st.executeUpdate(req);
            System.out.println("hotel supprime");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void modifierHotel(Hotel h)
    {
        try {
            String requete2 = "update hotel set nom_hotel=?,nbetoile=?,nbchambre=?,nbrestaurant=?,nbpiscine=?,adresse_rest=?,villehotel=?,image=? where idhotel=?";
                    
            
            PreparedStatement rst = cnx2.prepareStatement(requete2);
            rst.setInt(9,h.getIdhotel());
            rst.setString(1, h.getNom_hotel());
            rst.setLong(2, h.getNbetoile());
            rst.setInt(3, h.getNbchambre());
            rst.setInt(4, h.getNbrestaurant());
            rst.setInt(5, h.getNbpiscine());
            rst.setString(6, h.getAdresse_rest());
            rst.setString(7, h.getVillehotel());
            rst.setString(8, h.getImage());
            rst.executeUpdate();
            System.out.println("votre hotel est modifiéé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }


    
}

    
    

