/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.ReservationCroisiere;

/**
 *
 * @author Sémia
 */
public interface IreservationCroisiere {
    
    
    //Add
    public void ajouterReservationCroisiere(ReservationCroisiere rC);
    
    public void modifierReservationCroisiere (int idReservationCroisiere,int newIdCroisiere);
    //delete
    public void supprimerReservationCroisiere (int idReservationCroisiere);
    //List
    public List<ReservationCroisiere> afficherReservationCroisiere();
    
}
