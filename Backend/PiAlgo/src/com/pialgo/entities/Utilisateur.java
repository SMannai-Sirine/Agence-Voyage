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
public class Utilisateur {
 private int idU;
    private String nom;
    private String prenom ;
    private String adresse;
    private String email;
    private String motpasse;
    private String photo;
    private role role;

    public Utilisateur() {
    }

    public Utilisateur(int idU, String nom, String prenom, String adresse, String email, String motpasse, String photo, role role) {
        this.idU = idU;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.motpasse = motpasse;
        this.photo = photo;
        this.role = role;
    }

    public Utilisateur(String nom, String prenom, String adresse, String email, String motpasse, String photo, role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.motpasse = motpasse;
        this.photo = photo;
        this.role = role;
    }

    public Utilisateur(String email, String motpasse) {
        this.email = email;
        this.motpasse = motpasse;
    }
    

    public Utilisateur(int idU) {
        this.idU = idU;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotpasse() {
        return motpasse;
    }

    public void setMotpasse(String motpasse) {
        this.motpasse = motpasse;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public role getRole() {
        return role;
    }

    public void setRole(role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "idU=" + idU + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", email=" + email + ", motpasse=" + motpasse + ", photo=" + photo + ", role=" + role + '}';
    }

    
}
   
