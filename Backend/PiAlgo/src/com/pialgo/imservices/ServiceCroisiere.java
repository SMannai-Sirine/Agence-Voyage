/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Icroisiere;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Croisiere;
import util.maConnexion;

/**
 *
 * @author Sémia
 */
public class ServiceCroisiere implements Icroisiere{
    
      //var
    Connection cnx = maConnexion.getInstance().getCnx();


    /*@Override
    public void ajouterCroisiere(Croisiere c) {
        
        String request = "INSERT INTO `croisiere`(`refBateau`, `compagnieNavigation`, `portDepart`, `portArrive`, `dateDepart`, `dateArrivee`, `nbCabines`) VALUES ('"+c.getRefBateau()+"','"+c.getCompagnieNavigation()+"','"+c.getPortDepart()+"','"+c.getPortArrive()+"','"+c.getDateDepart()+"','"+c.getDateArrivee()+"','"+c.getNbCabines()+"')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(request);
            System.out.println("Croisière ajoutée avec succès");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("La croisière n'a pas été ajoutée");
        }
        
    }*/
    
    
    @Override
    public void ajouterCroisiere2(Croisiere c) {
        
        String Req = "INSERT INTO `croisiere`(`refBateau`, `CompagnieNavigation`, `portDepart`, `portArrive`, `dateDepart`, `dateArrivee`, `nbCabines`, `prixCroisiere`) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(Req);
            ps.setString(1, c.getRefBateau());
            ps.setString(2, c.getCompagnieNavigation());
            ps.setString(3, c.getPortDepart());
            ps.setString(4, c.getPortArrive());
            ps.setDate(5, c.getDateDepart());
            ps.setDate(6, c.getDateArrivee());
            ps.setInt(7, c.getNbCabines());
            ps.setFloat(8, c.getPrixCroisiere());
            ps.execute();
            System.out.println("Croisière ajoutée avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("La croisière n'a pas été ajouté");
        }
    }
    
    
    @Override
    public void modifierCroisiere (int id,String newRefBateau,String newCompagnieNavigation,String newPortDepart,String newPortArrivee,Date newDateDepart,Date newDateArrivee,int newNbCabines,float newPrixCroisiere){
    
        String request = "UPDATE `croisiere` SET `refBateau`='"+newRefBateau+"',`CompagnieNavigation`='"+newCompagnieNavigation+"',`portDepart`='"+newPortDepart+"',`portArrive`='"+newPortArrivee+"',`dateDepart`='"+newDateDepart+"',`dateArrivee`='"+newDateArrivee+"',`nbCabines`='"+newNbCabines+"',`prixCroisiere`='"+newPrixCroisiere+"' WHERE(`idCroisiere`= "+id+")";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(request);
            System.out.println("Croisière modifiée avec succès");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("La croisière n'a pas été modifiée");
        }
    }
    
     @Override
    public void supprimerCroisiere (int id){
    
        String requ = "DELETE FROM `Croisiere` WHERE (`idCroisiere`= "+id+")";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(requ);
            System.out.println("Croisière supprimée avec succès");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("La croisière n'a pas été supprimée");
        }
    
    
    }
    
    
    @Override
    public List<Croisiere> afficherCroisiere() {
        List<Croisiere> croisieres = new ArrayList<>();
        
        String query = "SELECT * FROM croisiere";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                croisieres.add(new Croisiere(rs.getInt("idCroisiere"), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getDate(6),rs.getDate(7),rs.getInt("nbCabines"),rs.getFloat("prixCroisiere")));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return croisieres;
    }
    
    
    /*public List<Croisiere> rechercheTrieCroisiere(String portDepart,String portArrive,Date dateDepart){
        
        List<Croisiere> listCroisieres = new ArrayList<>();
        String Req = "SELECT * FROM  `croisiere`  WHERE ((`portDepart` like '"+portDepart+"') and (`portArrive` like '"+portArrive+"') and (`dateDepart` like '"+dateDepart+"')and (`nbCabines` > 0)) ORDER BY (`prixCroisiere`);";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(Req);
            while (rs.next()) {                
                listCroisieres.add(new Croisiere(rs.getInt("idCroisiere"), rs.getString("refBateau"), rs.getString("compagnieNavivation"), rs.getString("portDepart"), rs.getString("portArrive"),rs.getDate("dateDepart"),rs.getDate("dateArrive"),rs.getInt("nbCabines"),rs.getFloat("prixCroisiere")));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return listCroisieres;
        
        
    }*/
    
    
    public List<Croisiere> rechercheCroisiere(String refBateau,String compagnieNavigation,String portDepart,String portArrive,String dateDepart,String dateArrivee,String nbCabines,String prix){   
        List<Croisiere> listCroisieres = new ArrayList<>();
        
        String Req = "SELECT * FROM  `croisiere` ";// WHERE ((`refAvion` like '"+refAvion+"') and (`compagnieAerienne` like '"+compagnieAerienne+"') and (`aeroDepart` like '"+aeroDepart+"') and (`aeroArrive` like '"+aeroArrive+"') and (`dateDepart` = '"+dateDepart+"')and (`duree` = '"+duree+"')and (`nbSieges` = '"+nbSieges+"')and (`prix` = '"+prix+"'));";
         int nbparam=0;
        if(!refBateau.equals(""))
        {
            if(nbparam==0) {Req=Req+"WHERE (";nbparam++;}
            else {Req=Req+" and ";nbparam++;}
            Req=Req+"(`refBateau` like '"+refBateau+"') ";
        }
        if(!compagnieNavigation.equals(""))
        {
            if(nbparam==0) {Req=Req+"WHERE (";nbparam++;}
            else {Req=Req+" and ";nbparam++;}
            Req=Req+"(`compagnieNavigation` like '"+compagnieNavigation+"')";
        }
        
        if(!portDepart.equals(""))
        {
            if(nbparam==0) {Req=Req+"WHERE (";nbparam++;}
            else {Req=Req+" and ";nbparam++;}
            Req=Req+"(`portDepart` like '"+portDepart+"')";
        }
        if(!portArrive.equals(""))
        {
            if(nbparam==0) {Req=Req+"WHERE (";nbparam++;}
            else {Req=Req+" and ";nbparam++;}
            Req=Req+"(`portArrive` like '"+portArrive+"')";
        }
         if(!dateDepart.equals(""))
        {Date myDate = Date.valueOf(dateDepart);
            if(nbparam==0) {Req=Req+"WHERE (";nbparam++;}
            else {Req=Req+" and ";nbparam++;}
            Req=Req+"(`dateDepart` = '"+myDate+"')";
        }
         if(!dateArrivee.equals(""))
        {Date myDate2 = Date.valueOf(dateArrivee);
            if(nbparam==0) {Req=Req+"WHERE (";nbparam++;}
            else {Req=Req+" and ";nbparam++;}
            Req=Req+"(`dateArrivee` = '"+myDate2+"')";
        } 
          if(!nbCabines.equals(""))
        {
            if(nbparam==0) {Req=Req+"WHERE (";nbparam++;}
            else {Req=Req+" and ";nbparam++;}
            Req=Req+"(`nbCabines` = '"+Integer.parseInt(nbCabines)+"')";
        }
         if(!prix.equals(""))
        {
            if(nbparam==0) {Req=Req+"WHERE (";nbparam++;}
            else {Req=Req+" and ";nbparam++;}
            Req=Req+"(`prixCroisiere` = '"+Float.parseFloat(prix)+"')";
        } 
        if(nbparam>0)
        Req=Req+")";
        System.out.println(Req);
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(Req);
            while (rs.next()) {                
                listCroisieres.add(new Croisiere(rs.getInt("idCroisiere"), rs.getString("refBateau"), rs.getString("compagnieNavigation"), rs.getString("portDepart"), rs.getString("portArrive"),rs.getDate("DateDepart"),rs.getDate("DateArrivee"),rs.getInt("nbCabines"),rs.getFloat("prixCroisiere")));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return listCroisieres;
        
        
    }
    
    
    
    @Override
     public List<Croisiere> rechercheCroisiereTrie(String compagnieNavigation,String portDepart,String portArrive,String dateDepart,String dateArrivee){   
        List<Croisiere> listCroisieres = new ArrayList<>();
        
        String Req = "SELECT * FROM  `croisiere` ";// WHERE ((`refAvion` like '"+refAvion+"') and (`compagnieAerienne` like '"+compagnieAerienne+"') and (`aeroDepart` like '"+aeroDepart+"') and (`aeroArrive` like '"+aeroArrive+"') and (`dateDepart` = '"+dateDepart+"')and (`duree` = '"+duree+"')and (`nbSieges` = '"+nbSieges+"')and (`prix` = '"+prix+"'));";
         int nbparam=0;
        
        if(!compagnieNavigation.equals(""))
        {
            if(nbparam==0) {Req=Req+"WHERE (";nbparam++;}
            else {Req=Req+" and ";nbparam++;}
            Req=Req+"(`compagnieNavigation` like '"+compagnieNavigation+"')";
        }
        if(!portDepart.equals(""))
        {
            if(nbparam==0) {Req=Req+"WHERE (";nbparam++;}
            else {Req=Req+" and ";nbparam++;}
            Req=Req+"(`portDepart` like '"+portDepart+"')";
        }
        if(!portArrive.equals(""))
        {
            if(nbparam==0) {Req=Req+"WHERE (";nbparam++;}
            else {Req=Req+" and ";nbparam++;}
            Req=Req+"(`portArrive` like '"+portArrive+"')";
        }
         if(!dateDepart.equals(""))
        {Date myDate = Date.valueOf(dateDepart);
            if(nbparam==0) {Req=Req+"WHERE (";nbparam++;}
            else {Req=Req+" and ";nbparam++;}
            Req=Req+"(`dateDepart` = '"+myDate+"')";
        }
          if(!dateArrivee.equals(""))
        {Date myDate1 = Date.valueOf(dateArrivee);
            if(nbparam==0) {Req=Req+"WHERE (";nbparam++;}
            else {Req=Req+" and ";nbparam++;}
            Req=Req+"(`dateArrivee` = '"+myDate1+"')";
        }
        if(nbparam>0)
        Req=Req+"and (`nbCabines` > 0)) ORDER BY (`prix`)";
        //System.out.println(Req);
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(Req);
            while (rs.next()) {                
                listCroisieres.add(new Croisiere(rs.getInt("idCroisiere"), rs.getString("refBateau"), rs.getString("compagnieNavigation"), rs.getString("portDepart"), rs.getString("portArrive"),rs.getDate("dateDepart"),rs.getDate("dateArrivee"),rs.getInt("nbCabines"),rs.getFloat("prixCroisiere")));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return listCroisieres;
        
        
    }
}
