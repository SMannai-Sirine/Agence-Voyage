/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;


import java.sql.Date;
import java.util.List;
import model.Vol;

/**
 *
 * @author Sémia
 */
public interface Ivol {
    //Add
    //public void ajouterVol(Vol v);
    public void ajouterVol2(Vol v);
    public void modifierVol (int idVol,String newRefAvion,String newCompagnieAerienne,String newAeroDepart,String newAeroArrivee,Date newDateDepart,float newDuree,int newNbSieges,float newPrix);
    //delete
    public void supprimerVol (int id);
    //List
    public List<Vol> afficherVol();
    
    //public List<Vol> rechercheTrieVol(String aeroDepart,String aeroArrive,Date dateDepart);
    
    public List<Vol> rechercheVol(String refAvion,String compagnieAerienne,String aeroDepart,String aeroArrive,String dateDepart,String duree,String nbSieges,String prix);
    public List<Vol> rechercheVolTrie(String compagnieAerienne,String aeroDepart,String aeroArrive,String dateDepart);
    
}
