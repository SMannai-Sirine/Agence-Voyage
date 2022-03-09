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
public class Loc_voiture {
    private int id;
    private int id_voiture;
    private int id_pays;
    private Date date_res;
    private int duree_res;
    private Boolean remise;
    private int taux_remise;
    private String pay;
    private String nom;
    private Float prix;
    private String etat;

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    
    

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    
    public Loc_voiture() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_voiture() {
        return id_voiture;
    }

    public void setId_voiture(int id_voiture) {
        this.id_voiture = id_voiture;
    }

    public int getId_pays() {
        return id_pays;
    }

    public void setId_pays(int id_pays) {
        this.id_pays = id_pays;
    }

    public Date getDate_res() {
        return date_res;
    }

    public void setDate_res(Date date_res) {
        this.date_res = date_res;
    }

    public int getDuree_res() {
        return duree_res;
    }

    public void setDuree_res(int duree_res) {
        this.duree_res = duree_res;
    }

    public Boolean getRemise() {
        return remise;
    }

    public void setRemise(Boolean remise) {
        this.remise = remise;
    }

    public int getTaux_remise() {
        return taux_remise;
    }

    public void setTaux_remise(int taux_remise) {
        this.taux_remise = taux_remise;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    
    
    @Override
    public String toString() {
        return "Loc_voiture{" + "id=" + id + ", id_voiture=" + id_voiture + ", id_pays=" + id_pays + ", date_res=" + date_res + ", duree_res=" + duree_res + ", remise=" + remise + ", taux_remise=" + taux_remise + '}';
    }
    
    
    
    
}
