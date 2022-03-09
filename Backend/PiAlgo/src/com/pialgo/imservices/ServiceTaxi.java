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
import model.Taxi;
import util.maConnexion;

/**
 *
 * @author Dell
 */
public class ServiceTaxi implements IService<Taxi>{
    Connection cnx;

    public ServiceTaxi() {
        cnx = maConnexion.getInstance().getCnx();
    }
    
    

    @Override
    public void ajout(Taxi t) {
        try {
        String req = "insert into taxi (matricule,prix,id_pays) "
                + "values"+"('"+t.getMatricule()+"',"+ t.getPrix()+","+t.getId_pays()+")";
        Statement st=cnx.createStatement();
        st.executeUpdate(req);
    } catch (SQLException ex) {
        Logger.getLogger(ServiceTaxi.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void modifier(Taxi t) {
        try {
        String req ="update taxi set matricule=? , prix=? , id_pays= ? WHERE id= ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1,t.getMatricule());
        ps.setFloat(2,t.getPrix());
        ps.setInt(3, t.getId_pays());
        ps.setInt(4, t.getId());
        
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(ServiceTaxi.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void supprime(int id) {
         try {
        String req ="delete from taxi where id=?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1,id);
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(ServiceTaxi.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public List<Taxi> affiche() {
        List<Taxi> list =new ArrayList<>();
        try{
            String req ="select * from taxi";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
        Taxi r =new Taxi();
        r.setId(rs.getInt("id"));
        r.setMatricule(rs.getString("matricule"));
        r.setPrix(rs.getFloat("prix"));
        r.setId_pays(rs.getInt("id_pays"));
        ServicePays serp=new ServicePays();
        r.setNom(serp.getNomById(r.getId_pays()).getNom());
          list.add(r); 
          System.out.println("h");
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceTaxi.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
    }
    public List<Taxi> getTaxiByPays(int id) {
        List<Taxi> list =new ArrayList<>();
        try{
            String req ="select * from taxi where id_pays="+id+"";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
        Taxi r =new Taxi();
        r.setId(rs.getInt("id"));
        r.setMatricule(rs.getString("matricule"));
        r.setPrix(rs.getFloat("prix"));
        
        
          list.add(r); 
          
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceTaxi.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
    }
    public Taxi getTaxiByMatricule(String mat) {
        Taxi r =new Taxi();
        try{
            String req ="select * from taxi where matricule='"+mat+"'";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
        
        r.setId(rs.getInt("id"));
        r.setMatricule(rs.getString("matricule"));
        r.setPrix(rs.getFloat("prix"));
        
        
           
          
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceTaxi.class.getName()).log(Level.SEVERE, null, ex);
    }
    return r;
    }

    public Taxi getTaxiById(int id_taxi) {
      Taxi r =new Taxi();
        try{
            String req ="select * from taxi where id="+id_taxi+"";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
        
        r.setId(rs.getInt("id"));
        r.setMatricule(rs.getString("matricule"));
        r.setPrix(rs.getFloat("prix"));
        
        
           
          
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceTaxi.class.getName()).log(Level.SEVERE, null, ex);
    }
    return r;
    }
    
   
    
}
