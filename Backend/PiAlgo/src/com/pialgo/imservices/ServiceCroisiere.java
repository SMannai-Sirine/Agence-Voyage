/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Icroisiere;
import java.sql.Connection;
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
            ps.setString(5, c.getDateDepart());
            ps.setString(6, c.getDateArrivee());
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
    public void modifierCroisiere (int id,String newRefBateau,String newCompagnieNavigation,String newPortDepart,String newPortArrivee,String newDateDepart,String newDateArrivee,int newNbCabines,float newPrixCroisiere){
    
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
                croisieres.add(new Croisiere(rs.getInt("idCroisiere"), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt("nbCabines"),rs.getFloat("prixCroisiere")));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return croisieres;
    }
    
    
    public List<Croisiere> rechercheTrieCroisiere(String portDepart,String portArrive,String dateDepart){
        
        List<Croisiere> listCroisieres = new ArrayList<>();
        String Req = "SELECT * FROM  `croisiere`  WHERE ((`portDepart` like '"+portDepart+"') and (`portArrive` like '"+portArrive+"') and (`dateDepart` like '"+dateDepart+"')and (`nbCabines` > 0)) ORDER BY (`prixCroisiere`);";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(Req);
            while (rs.next()) {                
                listCroisieres.add(new Croisiere(rs.getInt("idCroisiere"), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt("nbCabines"),rs.getFloat("prixCroisiere")));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return listCroisieres;
        
        
    }
    
}
