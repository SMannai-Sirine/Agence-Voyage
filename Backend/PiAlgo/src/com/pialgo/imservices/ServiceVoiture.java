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
import jdk.nashorn.internal.runtime.Debug;
import model.Taxi;
import model.Voiture;
import util.maConnexion;

/**
 *
 * @author Dell
 */
public class ServiceVoiture implements IService<Voiture>{
    Connection cnx;

    public ServiceVoiture() {
        cnx = maConnexion.getInstance().getCnx();
    }
    

    @Override
    public void ajout(Voiture t) {
        try {
        String req = "insert into voiture (model,type,prix,id_pays) "
                + "values"+"('"+t.getModel()+"','"+ t.getType()+"',"+ t.getPrix()+","+t.getId_pays()+")";
        Statement st=cnx.createStatement();
        st.executeUpdate(req);
    } catch (SQLException ex) {
        Logger.getLogger(ServiceVoiture.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void modifier(Voiture t) {
       try {
        String req ="update voiture set model= ?,type= ?,prix= ? , id_pays= ? where id= ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1,t.getModel());
        ps.setString(2,t.getType());
        ps.setFloat(3, t.getPrix());
        ps.setInt(4, t.getId_pays());
        ps.setInt(5,t.getId());
        
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(ServiceVoiture.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void supprime(int id) {
         try {
        String req ="delete from voiture where id=?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1,id);
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(ServiceTaxi_aero.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }

    @Override
    public List<Voiture> affiche() {
        List<Voiture> list =new ArrayList<>();
        try{
            String req ="select * from voiture";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
        Voiture r =new Voiture();
        r.setId(rs.getInt("id"));
        r.setModel(rs.getString("model"));
        r.setType(rs.getString("type"));
        r.setPrix(rs.getFloat("prix"));
        r.setId_pays(rs.getInt("id_pays"));
        ServicePays serp=new ServicePays();
        r.setNom(serp.getNomById(r.getId_pays()).getNom());
        
        
          list.add(r); 
          System.out.println("h");
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceVoiture.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
    }
    
    public List<Voiture> getVoitureByPays(int id) {
        List<Voiture> list =new ArrayList<>();
        try{
            String req ="select * from voiture where id_pays="+id+"";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
        Voiture r =new Voiture();
        r.setId(rs.getInt("id"));
        r.setModel(rs.getString("model"));
        r.setType(rs.getString("type"));
        r.setPrix(rs.getFloat("prix"));
        r.setId_pays(rs.getInt("id_pays"));
        ServicePays serp=new ServicePays();
        r.setNom(serp.getNomById(r.getId_pays()).getNom());
        
        
          list.add(r); 
          
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceTaxi.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
    }

    public Voiture getVoitureByModel(String value,int id) {
        Voiture r =new Voiture();
        try{
            String req ="select * from voiture where model='"+value+"' and id_pays="+id+"";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
        
        r.setId(rs.getInt("id"));
        r.setModel(rs.getString("model"));
        r.setType(rs.getString("type"));
        r.setPrix(rs.getFloat("prix"));
        
        
           
          
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceTaxi.class.getName()).log(Level.SEVERE, null, ex);
    }
    return r;
    }
    
   public Voiture getVoitureById(int id){
       Voiture r =new Voiture();
        try{
            String req ="select * from voiture where id="+id+"";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
        
        r.setId(rs.getInt("id"));
        r.setModel(rs.getString("model"));
        r.setType(rs.getString("type"));
        r.setPrix(rs.getFloat("prix"));
        
        
           
          
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceTaxi.class.getName()).log(Level.SEVERE, null, ex);
    }
    return r;
   }
    
}
