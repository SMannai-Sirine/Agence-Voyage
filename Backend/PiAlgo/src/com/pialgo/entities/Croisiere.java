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
public class Croisiere {
    
    //var
    private int idCroisiere;
    private String refBateau;
    private String CompagnieNavigation;
    private String portDepart;
    private String portArrive;
    private String dateDepart;
    private String dateArrivee;
    private int nbCabines;
    private float prixCroisiere;

    
    
    public Croisiere() {
    }

    public Croisiere(int idCroisiere, String refBateau, String CompagnieNavigation, String portDepart, String portArrive, String dateDepart, String dateArrivee, int nbCabines, float prixCroisiere) {
        this.idCroisiere = idCroisiere;
        this.refBateau = refBateau;
        this.CompagnieNavigation = CompagnieNavigation;
        this.portDepart = portDepart;
        this.portArrive = portArrive;
        this.dateDepart = dateDepart;
        this.dateArrivee = dateArrivee;
        this.nbCabines = nbCabines;
        this.prixCroisiere = prixCroisiere;
    }

    public Croisiere(String refBateau, String CompagnieNavigation, String portDepart, String portArrive, String dateDepart, String dateArrivee, int nbCabines, float prixCroisiere) {
        this.refBateau = refBateau;
        this.CompagnieNavigation = CompagnieNavigation;
        this.portDepart = portDepart;
        this.portArrive = portArrive;
        this.dateDepart = dateDepart;
        this.dateArrivee = dateArrivee;
        this.nbCabines = nbCabines;
        this.prixCroisiere = prixCroisiere;
    }

    public int getIdCroisiere() {
        return idCroisiere;
    }

    public String getRefBateau() {
        return refBateau;
    }

    public String getCompagnieNavigation() {
        return CompagnieNavigation;
    }

    public String getPortDepart() {
        return portDepart;
    }

    public String getPortArrive() {
        return portArrive;
    }

    public String getDateDepart() {
        return dateDepart;
    }

    public String getDateArrivee() {
        return dateArrivee;
    }

    public int getNbCabines() {
        return nbCabines;
    }

    public float getPrixCroisiere() {
        return prixCroisiere;
    }

    public void setIdCroisiere(int idCroisiere) {
        this.idCroisiere = idCroisiere;
    }

    public void setRefBateau(String refBateau) {
        this.refBateau = refBateau;
    }

    public void setCompagnieNavigation(String CompagnieNavigation) {
        this.CompagnieNavigation = CompagnieNavigation;
    }

    public void setPortDepart(String portDepart) {
        this.portDepart = portDepart;
    }

    public void setPortArrive(String portArrive) {
        this.portArrive = portArrive;
    }

    public void setDateDepart(String dateDepart) {
        this.dateDepart = dateDepart;
    }

    public void setDateArrivee(String dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public void setNbCabines(int nbCabines) {
        this.nbCabines = nbCabines;
    }

    public void setPrixCroisiere(float prixCroisiere) {
        this.prixCroisiere = prixCroisiere;
    }

    
    
    @Override
    public String toString() {
        return "Croisiere{" + "idCroisiere=" + idCroisiere + ", refBateau=" + refBateau + ", CompagnieNavigation=" + CompagnieNavigation + ", portDepart=" + portDepart + ", portArrive=" + portArrive + ", dateDepart=" + dateDepart + ", dateArrivee=" + dateArrivee + ", nbCabines=" + nbCabines + ", prixCroisiere=" + prixCroisiere + '}';
    }
    
    
    
    
    
    
    
    

    
    
    
}
