/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.ReservationVol;


/**
 *
 * @author Sémia
 */
public interface IreservationVol {
    
    //Add
    public void ajouterReservationVol(ReservationVol rV);
    
    public void modifierReservationVol (int idReservationVol,int newIdVol);
    //delete
    public void supprimerReservationVol (int idReservationVol);
    //List
    public List<ReservationVol> afficherReservationVol();
   
    
}
