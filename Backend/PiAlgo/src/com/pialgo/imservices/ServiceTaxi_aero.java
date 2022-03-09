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
import model.Loc_voiture;
import model.Taxi;
import model.Taxi_aero;
import util.maConnexion;

/**
 *
 * @author Dell
 */
public class ServiceTaxi_aero implements IService<Taxi_aero>{
    Connection cnx;

    public ServiceTaxi_aero() {
        cnx = maConnexion.getInstance().getCnx();
    }
    

    @Override
    public void ajout(Taxi_aero t) {
        try {
        String req = "insert into taxi_aero (id_taxi,id_pays,heure) "
                + "values"+"("+t.getId_taxi()+","+ t.getId_pays()+",'"+ t.getHeure()+"')";
        Statement st=cnx.createStatement();
        st.executeUpdate(req);
    } catch (SQLException ex) {
        Logger.getLogger(ServiceTaxi_aero.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void modifier(Taxi_aero t) {
        try {
        String req ="update taxi_aero set id_taxi= ?,id_pays= ?,heure= ? where id= ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1,t.getId_taxi());
        ps.setInt(2,t.getId_pays());
        ps.setString(3, t.getHeure());
        ps.setInt(4,t.getId());
        
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(ServiceTaxi_aero.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void supprime(int id) {
         try {
        String req ="delete from taxi_aero where id=?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1,id);
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(ServiceTaxi_aero.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public List<Taxi_aero> affiche() {
        List<Taxi_aero> list =new ArrayList<>();
        try{
            String req ="select * from taxi_aero";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
        Taxi_aero r =new Taxi_aero();
        r.setId(rs.getInt("id"));
        r.setId_pays(rs.getInt("id_pays"));
        r.setId_taxi(rs.getInt("id_taxi"));
        r.setHeure(rs.getString("heure"));
        ServiceReservation serR=new ServiceReservation();
        r.setEtat(serR.getReservationById(r.getId(), 1).getEtat());
        ServicePays serp=new ServicePays();
        r.setNom(serp.getNomById(r.getId_pays()).getNom());
        r.setId_taxi(rs.getInt("id_taxi")); 
        r.setId_pays(rs.getInt("id_pays"));
        ServiceTaxi serV=new ServiceTaxi();
        r.setMatricule(serV.getTaxiById(r.getId_taxi()).getMatricule());
        r.setPrix(serV.getTaxiById(r.getId_taxi()).getPrix());
        
          list.add(r); 
          System.out.println("h");
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceTaxi_aero.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
    }
    
    public int getLastId(){
        int id=0;
        try{
            String req ="SELECT MAX(id) AS last_id FROM taxi_aero";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
        Taxi r =new Taxi();
        id=(rs.getInt("last_id"));
        
        
          
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceTaxi.class.getName()).log(Level.SEVERE, null, ex);
    }
    return id;
    }
    
    public Taxi_aero getTaxiAeroByMat(String mat) {
         Taxi_aero r =new Taxi_aero();
        try{
            String req ="select * from taxi_aero";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
       
       r.setId(rs.getInt("id"));
        r.setHeure(rs.getString("heure"));
        r.setId_pays(rs.getInt("id_pays"));
        r.setId_taxi(rs.getInt("id_taxi"));
        ServiceReservation serR=new ServiceReservation();
        r.setEtat(serR.getReservationById(r.getId(), 1).getEtat());
        ServicePays serp=new ServicePays();
        r.setNom(serp.getNomById(r.getId_pays()).getNom());
        r.setId_taxi(rs.getInt("id_taxi")); 
        r.setId_pays(rs.getInt("id_pays"));
        ServiceTaxi serV=new ServiceTaxi();
        r.setMatricule(serV.getTaxiById(r.getId_taxi()).getMatricule());
        r.setPrix(serV.getTaxiById(r.getId_taxi()).getPrix());
        
        
          
          System.out.println("h");
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceTaxi_aero.class.getName()).log(Level.SEVERE, null, ex);
    }
    return r;
    }

    public List<Taxi_aero> afficheAdmin() {
       List<Taxi_aero> list =new ArrayList<>();
        try{
            String req ="select * from taxi_aero ";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
        Taxi_aero r =new Taxi_aero();
        r.setId(rs.getInt("id"));
        r.setHeure(rs.getString("heure"));
        r.setId_pays(rs.getInt("id_pays"));
        ServiceReservation serR=new ServiceReservation();
        r.setEtat(serR.getReservationByIdAdmin(r.getId(), 1).getEtat());
        ServicePays serp=new ServicePays();
        r.setNom(serp.getNomById(r.getId_pays()).getNom());
        r.setId_taxi(rs.getInt("id_taxi")); 
        r.setId_pays(rs.getInt("id_pays"));
        ServiceTaxi serV=new ServiceTaxi();
        r.setNom(serV.getTaxiById(r.getId_taxi()).getMatricule());
        r.setPrix(serV.getTaxiById(r.getId_taxi()).getPrix());
        if (r.getEtat()!=null) {
            list.add(r); 
        }
        
        
          
          System.out.println("h");
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceLoc_Voiture.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
    }
    
}
