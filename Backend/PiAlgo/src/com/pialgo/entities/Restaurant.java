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
    private int id;
    private String nom;
    private long num_tel;
     private String adresse;
    private String ville;
    private int nb_table;
    private String type;
    
    
    public Restaurant(){
        
    }
    

    
    public Restaurant(int id, String nom, long num_tel, String adresse, String ville, int nb_table, String type) {
        this.id = id;
        this.nom = nom;
        this.num_tel = num_tel;
        this.adresse = adresse;
        this.ville = ville;
        this.nb_table = nb_table;
        this.type = type;
    }

    public Restaurant(String nom, long num_tel, String adresse, String ville, int nb_table, String type) {
        this.nom = nom;
        this.num_tel = num_tel;
        this.adresse = adresse;
        this.ville = ville;
        this.nb_table = nb_table;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public long getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(long num_tel) {
        this.num_tel = num_tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getNb_table() {
        return nb_table;
    }

    public void setNb_table(int nb_table) {
        this.nb_table = nb_table;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Restaurant{" + "id=" + id + ", nom=" + nom + ", num_tel=" + num_tel + ", adresse=" + adresse + ", ville=" + ville + ", nb_table=" + nb_table + ", type=" + type + '}';
    }
    
    
   
    
}
