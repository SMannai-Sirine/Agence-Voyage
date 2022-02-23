/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import model.Reservationloc_voiture;

/**
 *
 * @author DELL
 */
public interface IReservationloc_voiture {
    


public void ajouterReservationloc_voiture (Reservationloc_voiture rlv) ;
public void deleteReservationloc_voiture (int idReservationloc_voiture) ;
public void modifierReservationloc_voiture (Reservationloc_voiture rlv, int idReservationloc_voiture) ;





}