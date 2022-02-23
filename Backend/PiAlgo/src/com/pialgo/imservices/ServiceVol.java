/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Ivol;
import java.sql.Connection;
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
            ps.setString(5, v.getDateDepart());
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
    public void modifierVol (int idVol,String newRefAvion,String newCompagnieAerienne,String newAeroDepart,String newAeroArrivee,String newDateDepart,float newDuree,int newNbSieges,float newPrix){
    
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
                vols.add(new Vol(rs.getInt("idVol"), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getFloat("duree"),rs.getInt("nbSieges"),rs.getFloat("prix")));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return vols;
    }
    
    
    
    public List<Vol> rechercheTrieVol(String aeroDepart,String aeroArrive,String dateDepart){
        
        List<Vol> listVols = new ArrayList<>();
        String Req = "SELECT * FROM  `vol`  WHERE ((`aeroDepart` like '"+aeroDepart+"') and (`aeroArrive` like '"+aeroArrive+"') and (`dateDepart` like '"+dateDepart+"')and (`nbSieges` > 0)) ORDER BY (`prix`);";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(Req);
            while (rs.next()) {                
                listVols.add(new Vol(rs.getInt("idVol"), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getFloat("duree"),rs.getInt("nbSieges"),rs.getFloat("prix")));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return listVols;
        
        
    }
}
