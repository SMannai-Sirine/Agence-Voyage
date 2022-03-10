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
public class ReservationCroisiere {
    
    private int idReservationCroisiere;
    private int idUtilisateur;
    private int idCroisiere;

    
    
    public ReservationCroisiere() {
    }

    public ReservationCroisiere(int idReservationCroisiere, int idUtilisateur, int idCroisiere) {
        this.idReservationCroisiere = idReservationCroisiere;
        this.idUtilisateur = idUtilisateur;
        this.idCroisiere = idCroisiere;
    }

    public ReservationCroisiere( int idUtilisateur, int idCroisiere) {
        this.idUtilisateur = idUtilisateur;
        this.idCroisiere = idCroisiere;
    }

    public int getIdReservationCroisiere() {
        return idReservationCroisiere;
    }

    

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public int getIdCroisiere() {
        return idCroisiere;
    }

    public void setIdReservationCroisiere(int idReservationCroisiere) {
        this.idReservationCroisiere = idReservationCroisiere;
    }

    

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public void setIdCroisiere(int idCroisiere) {
        this.idCroisiere = idCroisiere;
    }

    @Override
    public String toString() {
        return "ReservationCroisiere{" + "idReservationCroisiere=" + idReservationCroisiere + ", idUtilisateur=" + idUtilisateur + ", idCroisiere=" + idCroisiere + '}';
    }

    
    
    
    
    
    
}
