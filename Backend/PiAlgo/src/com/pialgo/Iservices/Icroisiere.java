/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;


import java.util.List;
import model.Croisiere;

/**
 *
 * @author Sémia
 */
public interface Icroisiere {
    //Add
    //public void ajouterCroisiere(Croisiere c);
    public void ajouterCroisiere2(Croisiere c);
    public void modifierCroisiere (int id,String newRefBateau,String newCompagnieNavivation,String newPortDepart,String newPortArrivee,String newDateDepart,String newDateArrivee,int newNbCabines,float newPrixCroisiere);
    //delete
    public void supprimerCroisiere (int idCroisiere);
    //List
    public List<Croisiere> afficherCroisiere();
    
    public List<Croisiere> rechercheTrieCroisiere(String portDepart,String portArrive,String dateDepart);
    
}
