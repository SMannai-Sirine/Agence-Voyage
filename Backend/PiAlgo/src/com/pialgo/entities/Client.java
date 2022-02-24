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
public class Client extends Utilisateur{
    
    private int idClient;
    private String pays;

    public Client() {
    }

    public Client(int idClient, String pays, int idU, String nom, String prenom, String adresse, String email, String motpasse, String photo, com.pialgo.entities.role role) {
        super(idU, nom, prenom, adresse, email, motpasse, photo, role);
        this.idClient = idClient;
        this.pays = pays;
    }

    public Client(String pays, int idU, String nom, String prenom, String adresse, String email, String motpasse, String photo, com.pialgo.entities.role role) {
        super(idU, nom, prenom, adresse, email, motpasse, photo, role);
        this.pays = pays;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public String toString() {
        return "Client{" + "idClient=" + idClient + ", pays=" + pays + '}';
    }
    
    
    
}
