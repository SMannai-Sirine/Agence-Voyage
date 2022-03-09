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
import model.Voiture;
import util.maConnexion;

/**
 *
 * @author Dell
 */
public class ServiceLoc_Voiture implements IService<Loc_voiture>{
    Connection cnx;

    public ServiceLoc_Voiture() {
        cnx = maConnexion.getInstance().getCnx();
    }
    


    @Override
    public void ajout(Loc_voiture t) {
       try {
        String req = "insert into loc_voiture (id_pays,id_voiture,date_res,duree_res,remise,taux_remise) "
                + "values"+"("+ t.getId_pays()+","+ t.getId_voiture()+",'"+ t.getDate_res()+"',"+
                t.getDuree_res()+","+t.getRemise()+","+ t.getTaux_remise()+")";
        Statement st=cnx.createStatement();
        st.executeUpdate(req);
    } catch (SQLException ex) {
        Logger.getLogger(ServiceLoc_Voiture.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void modifier(Loc_voiture t) {
       try {
        String req ="update loc_voiture set id_pays= ?,id_voiture= ?,date_res= ?,duree_res= ? ,remise= ?,taux_remise= ? where id= ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1,t.getId_pays());
        ps.setInt(2,t.getId_voiture());
        ps.setDate(3, t.getDate_res());
        ps.setInt(4,t.getDuree_res());
        ps.setBoolean(5, t.getRemise());
        ps.setInt(6, t.getTaux_remise());
        ps.setInt(7,t.getId());
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(ServiceLoc_Voiture.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void supprime(int id) {
         try {
        String req ="delete from loc_voiture where id=?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1,id);
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(ServiceLoc_Voiture.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public List<Loc_voiture> affiche() {
        List<Loc_voiture> list =new ArrayList<>();
        try{
            String req ="select * from loc_voiture ";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
        Loc_voiture r =new Loc_voiture();
        r.setId(rs.getInt("id"));
        r.setDate_res(rs.getDate("date_res"));
        r.setDuree_res(rs.getInt("duree_res"));
        r.setId_pays(rs.getInt("id_pays"));
        ServiceReservation serR=new ServiceReservation();
        r.setEtat(serR.getReservationById(r.getId(), 0).getEtat());
        ServicePays serp=new ServicePays();
        r.setPay(serp.getNomById(r.getId_pays()).getNom());
        r.setId_voiture(rs.getInt("id_voiture")); 
        r.setRemise(rs.getBoolean("remise"));
        r.setId_pays(rs.getInt("id_pays"));
        ServiceVoiture serV=new ServiceVoiture();
        r.setNom(serV.getVoitureById(r.getId_voiture()).getModel());
        r.setPrix(serV.getVoitureById(r.getId_voiture()).getPrix()*r.getDuree_res());
        r.setTaux_remise(rs.getInt("taux_remise"));
        
        
          list.add(r); 
          System.out.println("h");
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceLoc_Voiture.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
    }

    public int getLastId() {
        int id=0;
        try{
            String req ="SELECT MAX(id) AS last_id FROM loc_voiture";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
        
        id=(rs.getInt("last_id"));
        
        
          
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceTaxi.class.getName()).log(Level.SEVERE, null, ex);
    }
    return id;
    }
    
    public List<Loc_voiture> afficheAdmin() {
        List<Loc_voiture> list =new ArrayList<>();
        try{
            String req ="select * from loc_voiture ";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
        Loc_voiture r =new Loc_voiture();
        r.setId(rs.getInt("id"));
        r.setDate_res(rs.getDate("date_res"));
        r.setDuree_res(rs.getInt("duree_res"));
        r.setId_pays(rs.getInt("id_pays"));
        ServiceReservation serR=new ServiceReservation();
        r.setEtat(serR.getReservationByIdAdmin(r.getId(), 0).getEtat());
        ServicePays serp=new ServicePays();
        r.setPay(serp.getNomById(r.getId_pays()).getNom());
        r.setId_voiture(rs.getInt("id_voiture")); 
        r.setRemise(rs.getBoolean("remise"));
        r.setId_pays(rs.getInt("id_pays"));
        ServiceVoiture serV=new ServiceVoiture();
        r.setNom(serV.getVoitureById(r.getId_voiture()).getModel());
        r.setPrix(serV.getVoitureById(r.getId_voiture()).getPrix()*r.getDuree_res());
        r.setTaux_remise(rs.getInt("taux_remise"));
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
    
    
    public Loc_voiture getLocByDate(String Date){
        Loc_voiture r =new Loc_voiture();
        try{
            String req ="select * from loc_voiture where date_res='"+Date+"' LIMIT 1";
            System.out.println(req);
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
        
        r.setId(rs.getInt("id"));
        r.setDate_res(rs.getDate("date_res"));
        r.setDuree_res(rs.getInt("duree_res"));
        r.setId_pays(rs.getInt("id_pays"));
        ServiceReservation serR=new ServiceReservation();
        r.setEtat(serR.getReservationById(r.getId(), 0).getEtat());
        ServicePays serp=new ServicePays();
        r.setPay(serp.getNomById(r.getId_pays()).getNom());
        r.setId_voiture(rs.getInt("id_voiture")); 
        r.setRemise(rs.getBoolean("remise"));
        r.setId_pays(rs.getInt("id_pays"));
        ServiceVoiture serV=new ServiceVoiture();
        r.setNom(serV.getVoitureById(r.getId_voiture()).getModel());
        r.setPrix(serV.getVoitureById(r.getId_voiture()).getPrix()*r.getDuree_res());
        r.setTaux_remise(rs.getInt("taux_remise"));
        
        
          
          System.out.println("h");
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceLoc_Voiture.class.getName()).log(Level.SEVERE, null, ex);
    }
    return r;
    }
}
