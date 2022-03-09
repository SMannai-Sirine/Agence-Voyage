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
public class Taxi {
    private int id;
    private String matricule;
    private float prix;
    private int id_pays;
    private String nom;
    

    public Taxi() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getId_pays() {
        return id_pays;
    }

    public void setId_pays(int id_pays) {
        this.id_pays = id_pays;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    
    @Override
    public String toString() {
        return "Taxi{" + "id=" + id + ", matricule=" + matricule + ", prix=" + prix + ", id_pays=" + id_pays + '}';
    }

    
    
}
