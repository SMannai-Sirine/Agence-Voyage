/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Sémia
 */
public class ReservationVol {
    
    //var
    private int idReservationVol;
    private String dateReservation;
    private int idUtilisateur;
    private int idVol;
    
    
    //Constructor

    public ReservationVol() {
    }

    public ReservationVol(int idReservationVol, String dateReservation, int idUtilisateur, int idVol) {
        this.idReservationVol = idReservationVol;
        this.dateReservation = dateReservation;
        this.idUtilisateur = idUtilisateur;
        this.idVol = idVol;
    }

    public ReservationVol(String dateReservation, int idUtilisateur, int idVol) {
        this.dateReservation = dateReservation;
        this.idUtilisateur = idUtilisateur;
        this.idVol = idVol;
    }
    
    
    //Getters & Setters
    public int getIdReservationVol() {
        return idReservationVol;
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public int getIdVol() {
        return idVol;
    }

    public void setIdReservationVol(int idReservationVol) {
        this.idReservationVol = idReservationVol;
    }

    public void setDateReservation(String dateReservation) {
        this.dateReservation = dateReservation;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public void setIdVol(int idVol) {
        this.idVol = idVol;
    }
    
    
     //Affichage
    @Override
    public String toString() {
        return "ReservationVol{" + "idReservationVol=" + idReservationVol + ", dateReservation=" + dateReservation + ", idUtilisateur=" + idUtilisateur + ", idVol=" + idVol + '}';
    }

    

    
    
    
    
}
