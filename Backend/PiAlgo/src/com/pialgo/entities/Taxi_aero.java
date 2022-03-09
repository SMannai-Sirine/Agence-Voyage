/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Dell
 */
public class Taxi_aero {
    private int id;
    private int id_taxi;
    private int id_pays;
    private String heure;
    private String Nom;
    private String Matricule;
    private float prix;
    private String Etat;

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String Etat) {
        this.Etat = Etat;
    }
    
    

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
    
    

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getMatricule() {
        return Matricule;
    }

    public void setMatricule(String Matricule) {
        this.Matricule = Matricule;
    }
    
    
    

    public Taxi_aero() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_taxi() {
        return id_taxi;
    }

    public void setId_taxi(int id_taxi) {
        this.id_taxi = id_taxi;
    }

    public int getId_pays() {
        return id_pays;
    }

    public void setId_pays(int id_pays) {
        this.id_pays = id_pays;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    @Override
    public String toString() {
        return "Taxi_aero{" + "id=" + id + ", id_taxi=" + id_taxi + ", id_pays=" + id_pays + ", heure=" + heure + '}';
    }
    
    
    
}
