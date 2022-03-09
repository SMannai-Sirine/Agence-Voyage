/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Reservation;
import util.maConnexion;

/**
 *
 * @author Dell
 */
public class ServiceReservation implements IService<Reservation>{
    Connection cnx;

    public ServiceReservation() {
        cnx = maConnexion.getInstance().getCnx();
    }
    

    @Override
    public void ajout(Reservation t) {
        try {
        String req = "insert into reservation (id_res,type,etat) "
                + "values"+"("+t.getId_res()+","+ t.getType()+",'"+ t.getEtat()+"')";
        Statement st=cnx.createStatement();
        st.executeUpdate(req);
    } catch (SQLException ex) {
        Logger.getLogger(ServiceReservation.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void modifier(Reservation t) {
        try {
        String req ="update reservation set etat= ? where id= ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1,t.getEtat());
        ps.setInt(2,t.getId());
        
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(ServiceReservation.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void supprime(int id) {
         try {
        String req ="delete from reservation where id=?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1,id);
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(ServiceReservation.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public List<Reservation> affiche() {
       List<Reservation> list =new ArrayList<>();
        try{
            String req ="select * from reservation";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
        Reservation r =new Reservation();
        r.setId(rs.getInt("id"));
        r.setEtat(rs.getString("etat"));
        r.setId_res(rs.getInt("id_res"));
        r.setType(rs.getBoolean("type"));
        
        
          list.add(r); 
          System.out.println("h");
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceReservation.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
    }
    
    public Reservation getReservationById(int id,int type) {
       Reservation r =new Reservation();
        try{
            String req ="select * from reservation where type="+type+" AND id_res="+id+"";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
        
        r.setId(rs.getInt("id"));
        r.setEtat(rs.getString("etat"));
        r.setId_res(rs.getInt("id_res"));
        r.setType(rs.getBoolean("type"));
        
        
           
          System.out.println("h");
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceReservation.class.getName()).log(Level.SEVERE, null, ex);
    }
    return r;
    }
    
    public void modifierR(Reservation t) {
        try {
        String req ="update reservation set etat= ? where id_res= ? AND type=?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1,t.getEtat());
        ps.setInt(2,t.getId_res());
        ps.setBoolean(3, t.getType());
        
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(ServiceReservation.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public Reservation getReservationByIdAdmin(int id,int type) {
       Reservation r =new Reservation();
        try{
            String req ="select * from reservation where type="+type+" AND id_res="+id+" AND (etat='Confirmée' OR etat='En Cours' OR etat='Rejetée')";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
        
        r.setId(rs.getInt("id"));
        r.setEtat(rs.getString("etat"));
        r.setId_res(rs.getInt("id_res"));
        r.setType(rs.getBoolean("type"));
        
        
           
          System.out.println("h");
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceReservation.class.getName()).log(Level.SEVERE, null, ex);
    }
    return r;
    }
    
}
