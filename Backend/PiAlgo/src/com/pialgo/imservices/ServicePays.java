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
import model.Pays;
import util.maConnexion;

/**
 *
 * @author Dell
 */
public class ServicePays implements IService<Pays>{
    Connection cnx;

    public ServicePays() {
        cnx = maConnexion.getInstance().getCnx();
    }
    

    @Override
    public void ajout(Pays t) {
        try {
        String req = "insert into pays (nom) "
                + "values"+"('"+t.getNom()+"')";
        Statement st=cnx.createStatement();
        st.executeUpdate(req);
    } catch (SQLException ex) {
        Logger.getLogger(ServicePays.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }

    @Override
    public void modifier(Pays t) {
       try {
        String req ="update pays set nom= ? where id= ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1,t.getNom());
        ps.setInt(2,t.getId());
        
       
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(ServicePays.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void supprime(int id) {
        try {
        String req ="delete from pays where id=?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1,id);
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(ServicePays.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public List<Pays> affiche() {
        List<Pays> list =new ArrayList<>();
        try{
            String req ="select * from pays";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
        Pays r =new Pays();
        r.setId(rs.getInt("id"));
        r.setNom(rs.getString("nom"));
        
        
          list.add(r); 
          
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServicePays.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
    }
    
    public int getIdPays(String nom){
        
        Pays r =new Pays();
        try{
            String req ="select * from pays where nom='"+nom+"'";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
        
        r.setId(rs.getInt("id"));
        
        
        
         
          
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServicePays.class.getName()).log(Level.SEVERE, null, ex);
    }
    return r.getId();
    }

    public Pays getNomById(int id) {
        
        Pays r =new Pays();
        try{
            String req ="select * from pays where id="+id+"";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
        
        r.setNom(rs.getString("nom"));
        
        
        
         
          
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServicePays.class.getName()).log(Level.SEVERE, null, ex);
    }
    return r;
    }
    
}
