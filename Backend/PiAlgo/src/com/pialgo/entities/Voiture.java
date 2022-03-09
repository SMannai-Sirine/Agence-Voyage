/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dell
 */
public class Voiture {
    private int id;
    private String model;
    private String type;
    private float prix;
    private int id_pays;
    private String nom;

    public Voiture() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return "Voiture{" + "id=" + id + ", model=" + model + ", type=" + type + ", prix=" + prix + ", id_pays=" + id_pays + '}';
    }

    
    
    
    
    
}
