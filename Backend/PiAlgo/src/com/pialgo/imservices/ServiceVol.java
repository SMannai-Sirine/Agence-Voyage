/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Ivol;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Vol;
import util.maConnexion;

/**
 *
 * @author Sémia
 */
public class ServiceVol implements Ivol {
 
    //var
    Connection cnx = maConnexion.getInstance().getCnx();


    /*@Override
    public void ajouterVol(Vol v) {
        
        String request = "INSERT INTO `vol`(`refAvion`, `compagnieAerienne`, `aeroDepart`, `aeroArrive`, `dateDepart`, `dateArrivee`, `nbSieges`) VALUES ('"+v.getRefAvion()+"','"+v.getCompanie()+"','"+v.getAeroDepart()+"','"+v.getAeroArrive()+"','"+v.getDateDepart()+"','"+v.getDateArrivee()+"','"+v.getNbSieges()+"')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(request);
            System.out.println("Vol ajouté avec succès");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Le vol n'a pas été ajouté");
        }
        
    }*/
    
    
    @Override
    public void ajouterVol2(Vol v) {
        
        String Req = "INSERT INTO `vol`(`refAvion`, `compagnieAerienne`, `aeroDepart`, `aeroArrive`, `dateDepart`, `duree`, `nbSieges`, `prix` ) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(Req);
            ps.setString(1, v.getRefAvion());
            ps.setString(2, v.getCompagnieAerienne());
            ps.setString(3, v.getAeroDepart());
            ps.setString(4, v.getAeroArrive());
            ps.setDate(5, v.getDateDepart());
            ps.setFloat(6, v.getDuree());
            ps.setInt(7, v.getNbSieges());
            ps.setFloat(8, v.getPrix());
            ps.execute();
            System.out.println("Vol ajouté avec succès");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Le vol n'a pas été ajouté");
        }
    }
    
    @Override
    public void modifierVol (int idVol,String newRefAvion,String newCompagnieAerienne,String newAeroDepart,String newAeroArrivee,Date newDateDepart,float newDuree,int newNbSieges,float newPrix){
    
        String request = "UPDATE `vol` SET `refAvion` ='"+newRefAvion+"',`compagnieAerienne`='"+newCompagnieAerienne+"',`aeroDepart`='"+newAeroDepart+"',`aeroArrive`='"+newAeroArrivee+"',`dateDepart`= '"+newDateDepart+"',`duree`='"+newDuree+"',`nbSieges`='"+newNbSieges+"',`prix`='"+newPrix+"' WHERE(`idVol`= "+idVol+")";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(request);
            System.out.println("Vol modifié avec succès");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Le vol n'a pas été modifié");
        }
    }
    
    
    @Override
    public void supprimerVol (int id){
    
        String requ = "DELETE FROM `vol` WHERE (`idVol`= "+id+")";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(requ);
            System.out.println("Vol supprimé avec succès");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Le vol n'a pas été supprimé");
        }
    
    
    }
    
   
    @Override
    public List<Vol> afficherVol() {
        List<Vol> vols = new ArrayList<>();
        
        String query = "SELECT * FROM vol";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                vols.add(new Vol(rs.getInt("idVol"),rs.getString("refAvion"), rs.getString("compagnieAerienne"), rs.getString("aeroDepart"), rs.getString("aeroArrive"),rs.getDate("dateDepart"),rs.getFloat("duree"),rs.getInt("nbSieges"),rs.getFloat("prix")));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return vols;
    }
    
    
    
    /*public List<Vol> rechercheTrieVol(String aeroDepart,String aeroArrive,Date dateDepart){
        
        List<Vol> listVols = new ArrayList<>();
       
        String Req = "SELECT * FROM  `vol`  WHERE ((`aeroDepart` like '"+aeroDepart+"') and (`aeroArrive` like '"+aeroArrive+"') and (`dateDepart` like '"+dateDepart+"')and (`nbSieges` > 0)) ORDER BY (`prix`);";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(Req);
            while (rs.next()) {                
                listVols.add(new Vol(rs.getInt("idVol"), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getDate(6),rs.getFloat("duree"),rs.getInt("nbSieges"),rs.getFloat("prix")));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return listVols;
        
        
    }*/
    
   // public List<Vol> rechercheVol(String refAvion,String compagnieAerienne,String aeroDepart,String aeroArrive,Date dateDepart,float duree,int nbSieges,float prix){
     public List<Vol> rechercheVol(String refAvion,String compagnieAerienne,String aeroDepart,String aeroArrive,String dateDepart,String duree,String nbSieges,String prix){   
        List<Vol> listVols = new ArrayList<>();
        
        String Req = "SELECT * FROM  `vol` ";// WHERE ((`refAvion` like '"+refAvion+"') and (`compagnieAerienne` like '"+compagnieAerienne+"') and (`aeroDepart` like '"+aeroDepart+"') and (`aeroArrive` like '"+aeroArrive+"') and (`dateDepart` = '"+dateDepart+"')and (`duree` = '"+duree+"')and (`nbSieges` = '"+nbSieges+"')and (`prix` = '"+prix+"'));";
         int nbparam=0;
        if(!refAvion.equals(""))
        {
            if(nbparam==0) {Req=Req+"WHERE (";nbparam++;}
            else {Req=Req+" and ";nbparam++;}
            Req=Req+"(`refAvion` like '"+refAvion+"') ";
        }
        if(!compagnieAerienne.equals(""))
        {
            if(nbparam==0) {Req=Req+"WHERE (";nbparam++;}
            else {Req=Req+" and ";nbparam++;}
            Req=Req+"(`compagnieAerienne` like '"+compagnieAerienne+"')";
        }
        
        if(!aeroDepart.equals(""))
        {
            if(nbparam==0) {Req=Req+"WHERE (";nbparam++;}
            else {Req=Req+" and ";nbparam++;}
            Req=Req+"(`aeroDepart` like '"+aeroDepart+"')";
        }
        if(!aeroArrive.equals(""))
        {
            if(nbparam==0) {Req=Req+"WHERE (";nbparam++;}
            else {Req=Req+" and ";nbparam++;}
            Req=Req+"(`aeroArrive` like '"+aeroArrive+"')";
        }
         if(!dateDepart.equals(""))
        {Date myDate = Date.valueOf(dateDepart);
            if(nbparam==0) {Req=Req+"WHERE (";nbparam++;}
            else {Req=Req+" and ";nbparam++;}
            Req=Req+"(`dateDepart` = '"+myDate+"')";
        }
          if(!duree.equals(""))
        {
            if(nbparam==0) {Req=Req+"WHERE (";nbparam++;}
            else {Req=Req+" and ";nbparam++;}
            Req=Req+"(`duree` = '"+Float.parseFloat(duree)+"')";
        } 
          if(!nbSieges.equals(""))
        {
            if(nbparam==0) {Req=Req+"WHERE (";nbparam++;}
            else {Req=Req+" and ";nbparam++;}
            Req=Req+"(`nbSieges` = '"+Integer.parseInt(nbSieges)+"')";
        }
         if(!prix.equals(""))
        {
            if(nbparam==0) {Req=Req+"WHERE (";nbparam++;}
            else {Req=Req+" and ";nbparam++;}
            Req=Req+"(`prix` = '"+Float.parseFloat(prix)+"')";
        } 
        if(nbparam>0)
        Req=Req+")";
        System.out.println(Req);
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(Req);
            while (rs.next()) {                
                listVols.add(new Vol(rs.getInt("idVol"), rs.getString("refAvion"), rs.getString("compagnieAerienne"), rs.getString("aeroDepart"), rs.getString("AeroArrive"),rs.getDate("DateDepart"),rs.getFloat("duree"),rs.getInt("nbSieges"),rs.getFloat("prix")));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return listVols;
        
        
    }
     
     
     @Override
     public List<Vol> rechercheVolTrie(String compagnieAerienne,String aeroDepart,String aeroArrive,String dateDepart){   
        List<Vol> listVols = new ArrayList<>();
        
        String Req = "SELECT * FROM  `vol` ";// WHERE ((`refAvion` like '"+refAvion+"') and (`compagnieAerienne` like '"+compagnieAerienne+"') and (`aeroDepart` like '"+aeroDepart+"') and (`aeroArrive` like '"+aeroArrive+"') and (`dateDepart` = '"+dateDepart+"')and (`duree` = '"+duree+"')and (`nbSieges` = '"+nbSieges+"')and (`prix` = '"+prix+"'));";
         int nbparam=0;
        
        if(!compagnieAerienne.equals(""))
        {
            if(nbparam==0) {Req=Req+"WHERE (";nbparam++;}
            else {Req=Req+" and ";nbparam++;}
            Req=Req+"(`compagnieAerienne` like '"+compagnieAerienne+"')";
        }
        if(!aeroDepart.equals(""))
        {
            if(nbparam==0) {Req=Req+"WHERE (";nbparam++;}
            else {Req=Req+" and ";nbparam++;}
            Req=Req+"(`aeroDepart` like '"+aeroDepart+"')";
        }
        if(!aeroArrive.equals(""))
        {
            if(nbparam==0) {Req=Req+"WHERE (";nbparam++;}
            else {Req=Req+" and ";nbparam++;}
            Req=Req+"(`aeroArrive` like '"+aeroArrive+"')";
        }
         if(!dateDepart.equals(""))
        {Date myDate = Date.valueOf(dateDepart);
            if(nbparam==0) {Req=Req+"WHERE (";nbparam++;}
            else {Req=Req+" and ";nbparam++;}
            Req=Req+"(`dateDepart` = '"+myDate+"')";
        }
        if(nbparam>0)
        Req=Req+"and (`nbSieges` > 0)) ORDER BY (`prix`)";
        //System.out.println(Req);
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(Req);
            while (rs.next()) {                
                listVols.add(new Vol(rs.getInt("idVol"), rs.getString("refAvion"), rs.getString("compagnieAerienne"), rs.getString("aeroDepart"), rs.getString("aeroArrive"),rs.getDate("dateDepart"),rs.getFloat("duree"),rs.getInt("nbSieges"),rs.getFloat("prix")));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return listVols;
        
        
    }
}
