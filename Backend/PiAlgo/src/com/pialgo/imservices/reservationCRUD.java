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
import pi.entities.Reservation;
import pi.utils.MyConnection;

/**
 *
 * @author 21658
 */
public class reservationCRUD {
    
    
    Connection cnx2;
    public reservationCRUD(){
        cnx2 =MyConnection.getInstance().getCnx();
    }
    public void ajouterReservation(){
        try {
            String requete="INSERT INTO reservation (date_reservation,id_hotel_restaurant,id_client,nom_Hotel_Restaurant) "
                    + " VALUES ('2022-04-28',98,6,'Ramazzoti') ";
            Statement st = cnx2.createStatement();
            st.executeUpdate(requete);
            System.out.println("reservation ajoutéé avec succes");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        
    }
    public void ajouterReservation2(Reservation R){
        try {
            String requete2 = "INSERT INTO reservation (date_reservation,id_hotel_restaurant,id_client,nom_Hotel_Restaurant)"
                    + "VALUES (?,?,?,?)" ;
            PreparedStatement rst = cnx2.prepareStatement(requete2);
     rst.setDate(1, R.getDate_reservaion());
     rst.setInt(2, R.getId_Hotel_Restaurant());
     rst.setInt(3, R.getId_client());
     rst.setString(4, R.getNom_Hotel_restaurant());
     rst.executeUpdate();
     System.out.println("votre reservation est ajoutee");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
         
    }
    public List<Reservation> afficherRestaurants(){
                    List<Reservation> myList1 = new ArrayList<>();

        try {
            String requete3 = "select * from reservation";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()){
                Reservation r = new Reservation();
                r.setId(rs.getInt(1));
                r.setDate_reservaion(rs.getDate("date_reservation"));
                r.setId_Hotel_Restaurant(rs.getInt("id_hotel_restaurant"));
                r.setId_client(rs.getInt("id_client"));
                r.setNom_Hotel_restaurant(rs.getString("nom_Hotel_Restaurant"));
               
               
                myList1.add(r);


                
                
            }
          
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList1;
        
    }
    public void supprimerReservation(Reservation r)
    {
        try {
            String req ="delete from reservation where id_client " + r.getId_client();
            Statement st=cnx2.createStatement();
            st.executeUpdate(req);
            System.out.println("reservation supprime");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void modifierReservation(Reservation r)
    {
        try {
            String requete2 = "update reservation set date_reservation=?,id_Hotel_restaurant=?,id_client=?,=?,nom_hotel_restaurant=?";
                    
            
            PreparedStatement rst = cnx2.prepareStatement(requete2);
            rst.setInt(7,r.getId() );
            rst.setDate(1, r.getDate_reservaion());
            rst.setInt(2, r.getId_Hotel_Restaurant());
            rst.setInt(3, r.getId_client());
            rst.setString(4, r.getNom_Hotel_restaurant());
            
            
            rst.executeUpdate();
            System.out.println("votre reservation est modifiéé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    
}
