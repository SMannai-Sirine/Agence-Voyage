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
    private String dateReservationCroisiere;
    private int idUtilisateur;
    private int idCroisiere;

    
    
    public ReservationCroisiere() {
    }

    public ReservationCroisiere(int idReservationCroisiere, String dateReservationCroisiere, int idUtilisateur, int idCroisiere) {
        this.idReservationCroisiere = idReservationCroisiere;
        this.dateReservationCroisiere = dateReservationCroisiere;
        this.idUtilisateur = idUtilisateur;
        this.idCroisiere = idCroisiere;
    }

    public ReservationCroisiere(String dateReservationCroisiere, int idUtilisateur, int idCroisiere) {
        this.dateReservationCroisiere = dateReservationCroisiere;
        this.idUtilisateur = idUtilisateur;
        this.idCroisiere = idCroisiere;
    }

    public int getIdReservationCroisiere() {
        return idReservationCroisiere;
    }

    public String getDateReservationCroisiere() {
        return dateReservationCroisiere;
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

    public void setDateReservationCroisiere(String dateReservationCroisiere) {
        this.dateReservationCroisiere = dateReservationCroisiere;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public void setIdCroisiere(int idCroisiere) {
        this.idCroisiere = idCroisiere;
    }

    @Override
    public String toString() {
        return "ReservationCroisiere{" + "idReservationCroisiere=" + idReservationCroisiere + ", dateReservationCroisiere=" + dateReservationCroisiere + ", idUtilisateur=" + idUtilisateur + ", idCroisiere=" + idCroisiere + '}';
    }
    
    
    
    
    
}
