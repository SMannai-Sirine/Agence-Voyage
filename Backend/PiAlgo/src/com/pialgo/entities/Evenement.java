/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pialgo.entities;


/**
 *
 * @author Sirine
 */
public class Evenement {
    private int idEvent;
    private String intitule;
    private String paysEvent;
    private String adresse;
    private String dateEvent;
    private String typeEvent;
    private String photo;

    public Evenement() {
    }

    public Evenement(int idEvent, String intitule, String paysEvent, String adresse, String dateEvent, String typeEvent, String photo) {
        this.idEvent = idEvent;
        this.intitule = intitule;
        this.paysEvent = paysEvent;
        this.adresse = adresse;
        this.dateEvent = dateEvent;
        this.typeEvent = typeEvent;
        this.photo = photo;
    }

    public Evenement(String intitule, String paysEvent, String adresse, String dateEvent, String typeEvent, String photo) {
        this.intitule = intitule;
        this.paysEvent = paysEvent;
        this.adresse = adresse;
        this.dateEvent = dateEvent;
        this.typeEvent = typeEvent;
        this.photo = photo;
    }

    public Evenement(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getPaysEvent() {
        return paysEvent;
    }

    public void setPaysEvent(String paysEvent) {
        this.paysEvent = paysEvent;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(String dateEvent) {
        this.dateEvent = dateEvent;
    }

    public String getTypeEvent() {
        return typeEvent;
    }

    public void setTypeEvent(String typeEvent) {
        this.typeEvent = typeEvent;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Evenement{" + "idEvent=" + idEvent + ", intitule=" + intitule + ", paysEvent=" + paysEvent + ", adresse=" + adresse + ", dateEvent=" + dateEvent + ", typeEvent=" + typeEvent + ", photo=" + photo + '}';
    }

}
