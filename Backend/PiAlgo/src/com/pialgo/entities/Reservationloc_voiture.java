/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DELL
 */
public class Reservationloc_voiture {
     public static void add(Reservationloc_voiture Reservationloc_voiture) {
        throw new UnsupportedOperationException("Not supported yet.");
    
}
//var
    private int idReservationloc_voiture ;
    private String dateReservationloc_voiture ;
    private int idUtilisateur ;
    private int idvoiture ;

    
 //constructors

    public Reservationloc_voiture(int idReservationloc_voiture, String dateReservationloc_voiture, int idUtilisateur, int idvoiture) {
        this.idReservationloc_voiture = idReservationloc_voiture;
        this.dateReservationloc_voiture = dateReservationloc_voiture;
        this.idUtilisateur = idUtilisateur;
        this.idvoiture = idvoiture;
    }

    public Reservationloc_voiture(String dateReservationloc_voiture, int idUtilisateur, int idvoiture) {
        this.dateReservationloc_voiture = dateReservationloc_voiture;
        this.idUtilisateur = idUtilisateur;
        this.idvoiture = idvoiture;
    }

   
    
//getters w setters

    public int getIdReservationloc_voiture() {
        return idReservationloc_voiture;
    }

    public void setIdReservationloc_voiture(int idReservationloc_voiture) {
        this.idReservationloc_voiture = idReservationloc_voiture;
    }

    public String getDateReservationloc_voiture() {
        return dateReservationloc_voiture;
    }

    public void setDateReservationloc_voiture(String dateReservationloc_voiture) {
        this.dateReservationloc_voiture = dateReservationloc_voiture;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public int getIdvoiture() {
        return idvoiture;
    }

    public void setIdvoiture(int idvoiture) {
        this.idvoiture = idvoiture;
    }






}
    

    