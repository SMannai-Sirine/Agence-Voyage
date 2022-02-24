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
public class Administrateur extends Utilisateur{
    private int idAdmin;
    private float Salaire;

    public Administrateur() {
    }

    public Administrateur(int idAdmin, float Salaire, int idU, String nom, String prenom, String adresse, String email, String motpasse, String photo, com.pialgo.entities.role role) {
        super(idU, nom, prenom, adresse, email, motpasse, photo, role);
        this.idAdmin = idAdmin;
        this.Salaire = Salaire;
    }

    public Administrateur(float Salaire, int idU, String nom, String prenom, String adresse, String email, String motpasse, String photo, com.pialgo.entities.role role) {
        super(idU, nom, prenom, adresse, email, motpasse, photo, role);
        this.Salaire = Salaire;
    }

    public Administrateur(float aFloat, String string, String string0, String string1, String string2, String string3, String string4) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public float getSalaire() {
        return Salaire;
    }

    public void setSalaire(float Salaire) {
        this.Salaire = Salaire;
    }

    @Override
    public String toString() {
        return "Administrateur{" + "idAdmin=" + idAdmin + ", Salaire=" + Salaire + '}';
    }

   
}
