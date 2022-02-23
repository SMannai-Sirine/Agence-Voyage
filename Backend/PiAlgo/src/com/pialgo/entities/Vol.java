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
public class Vol {
    //var
    private int idVol;
    private String refAvion;
    private String CompagnieAerienne;
    private String aeroDepart;
    private String aeroArrive;
    private String dateDepart;
    private float duree;
    private int nbSieges;
    private float prix;

    
    
    public Vol() {
    }

    public Vol(int idVol, String refAvion, String CompagnieAerienne, String aeroDepart, String aeroArrive, String dateDepart, float duree, int nbSieges, float prix) {
        this.idVol = idVol;
        this.refAvion = refAvion;
        this.CompagnieAerienne = CompagnieAerienne;
        this.aeroDepart = aeroDepart;
        this.aeroArrive = aeroArrive;
        this.dateDepart = dateDepart;
        this.duree = duree;
        this.nbSieges = nbSieges;
        this.prix = prix;
    }

    public Vol(String refAvion, String CompagnieAerienne, String aeroDepart, String aeroArrive, String dateDepart, float duree, int nbSieges, float prix) {
        this.refAvion = refAvion;
        this.CompagnieAerienne = CompagnieAerienne;
        this.aeroDepart = aeroDepart;
        this.aeroArrive = aeroArrive;
        this.dateDepart = dateDepart;
        this.duree = duree;
        this.nbSieges = nbSieges;
        this.prix = prix;
    }

    
    
    public int getIdVol() {
        return idVol;
    }

    public String getRefAvion() {
        return refAvion;
    }

    public String getCompagnieAerienne() {
        return CompagnieAerienne;
    }

    public String getAeroDepart() {
        return aeroDepart;
    }

    public String getAeroArrive() {
        return aeroArrive;
    }

    public String getDateDepart() {
        return dateDepart;
    }

    public float getDuree() {
        return duree;
    }

    public int getNbSieges() {
        return nbSieges;
    }

    public float getPrix() {
        return prix;
    }

    public void setIdVol(int idVol) {
        this.idVol = idVol;
    }

    public void setRefAvion(String refAvion) {
        this.refAvion = refAvion;
    }

    public void setCompagnieAerienne(String CompagnieAerienne) {
        this.CompagnieAerienne = CompagnieAerienne;
    }

    public void setAeroDepart(String aeroDepart) {
        this.aeroDepart = aeroDepart;
    }

    public void setAeroArrive(String aeroArrive) {
        this.aeroArrive = aeroArrive;
    }

    public void setDateDepart(String dateDepart) {
        this.dateDepart = dateDepart;
    }

    public void setDuree(float duree) {
        this.duree = duree;
    }

    public void setNbSieges(int nbSieges) {
        this.nbSieges = nbSieges;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Vol{" + "idVol=" + idVol + ", refAvion=" + refAvion + ", CompagnieAerienne=" + CompagnieAerienne + ", aeroDepart=" + aeroDepart + ", aeroArrive=" + aeroArrive + ", dateDepart=" + dateDepart + ", duree=" + duree + ", nbSieges=" + nbSieges + ", prix=" + prix + '}';
    }
     
    
    
}
