/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.entities;

/**
 *
 * @author 21658
 */
public class Restaurant {
    private int id_rest;
    private String nom_rest;
    private long numtel_rest;
     private String adresse_rest;
    private String ville_rest;
    private int nbtable_rest;
    private String type_rest;
        
    
    public Restaurant(){
        
    }

    public int getId_rest() {
        return id_rest;
    }

    public void setId_rest(int id_rest) {
        this.id_rest = id_rest;
    }

    public String getNom_rest() {
        return nom_rest;
    }

    public void setNom_rest(String nom_rest) {
        this.nom_rest = nom_rest;
    }

    public long getNumtel_rest() {
        return numtel_rest;
    }

    public void setNumtel_rest(long numtel_rest) {
        this.numtel_rest = numtel_rest;
    }

    public String getAdresse_rest() {
        return adresse_rest;
    }

    public void setAdresse_rest(String adresse_rest) {
        this.adresse_rest = adresse_rest;
    }

    public String getVille_rest() {
        return ville_rest;
    }

    public void setVille_rest(String ville_rest) {
        this.ville_rest = ville_rest;
    }

    public int getNbtable_rest() {
        return nbtable_rest;
    }

    public void setNbtable_rest(int nbtable_rest) {
        this.nbtable_rest = nbtable_rest;
    }

    public String getType_rest() {
        return type_rest;
    }

    public void setType_rest(String type_rest) {
        this.type_rest = type_rest;
    }

    public Restaurant(int id_rest, String nom_rest, long numtel_rest, String adresse_rest, String ville_rest, int nbtable_rest, String type_rest) {
        this.id_rest = id_rest;
        this.nom_rest = nom_rest;
        this.numtel_rest = numtel_rest;
        this.adresse_rest = adresse_rest;
        this.ville_rest = ville_rest;
        this.nbtable_rest = nbtable_rest;
        this.type_rest = type_rest;
    }

    public Restaurant(String nom_rest, long numtel_rest, String adresse_rest, String ville_rest, int nbtable_rest, String type_rest) {
        this.nom_rest = nom_rest;
        this.numtel_rest = numtel_rest;
        this.adresse_rest = adresse_rest;
        this.ville_rest = ville_rest;
        this.nbtable_rest = nbtable_rest;
        this.type_rest = type_rest;
    }
    

    
    
    
   
    
}
