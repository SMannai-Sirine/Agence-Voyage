/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Sémia
 */
public class ReservationVol {
    
    //var
    private int idReservationVol;
    private int idUtilisateur;
    private int idVol;
    
    
    //Constructor

    public ReservationVol() {
    }

    public ReservationVol(int idReservationVol, int idUtilisateur, int idVol) {
        this.idReservationVol = idReservationVol;
        this.idUtilisateur = idUtilisateur;
        this.idVol = idVol;
    }

    public ReservationVol(int idUtilisateur, int idVol) {
        this.idUtilisateur = idUtilisateur;
        this.idVol = idVol;
    }
   
    
    //Getters & Setters
    public int getIdReservationVol() {
        return idReservationVol;
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

    

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public void setIdVol(int idVol) {
        this.idVol = idVol;
    }

    

    
    
    
    
     //Affichage

    @Override
    public String toString() {
        return "ReservationVol{" + "idReservationVol=" + idReservationVol + ", idUtilisateur=" + idUtilisateur + ", idVol=" + idVol + '}';
    }

    

    

    
    
    
    
}
