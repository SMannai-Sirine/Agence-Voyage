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
public class Hotel {
    
   private int idhotel;
   private String nom_hotel;
   private int nbetoile;
   private int nbchambre;
   private int nbrestaurant;
   private int nbpiscine;
   private String adresse_rest;
   private String villehotel;
   
   public Hotel(){

}

    public Hotel(int idhotel, String nom_hotel, int nbetoile, int nbchambre, int nbrestaurant, int nbpiscine, String adresse_rest, String villehotel) {
        this.idhotel = idhotel;
        this.nom_hotel = nom_hotel;
        this.nbetoile = nbetoile;
        this.nbchambre = nbchambre;
        this.nbrestaurant = nbrestaurant;
        this.nbpiscine = nbpiscine;
        this.adresse_rest = adresse_rest;
        this.villehotel = villehotel;
    }

    public Hotel(String nom_hotel, int nbetoile, int nbchambre, int nbrestaurant, int nbpiscine, String adresse_rest, String villehotel) {
        this.nom_hotel = nom_hotel;
        this.nbetoile = nbetoile;
        this.nbchambre = nbchambre;
        this.nbrestaurant = nbrestaurant;
        this.nbpiscine = nbpiscine;
        this.adresse_rest = adresse_rest;
        this.villehotel = villehotel;
    }

    public int getIdhotel() {
        return idhotel;
    }

    public void setIdhotel(int idhotel) {
        this.idhotel = idhotel;
    }

    public String getNom_hotel() {
        return nom_hotel;
    }

    public void setNom_hotel(String nom_hotel) {
        this.nom_hotel = nom_hotel;
    }

    public int getNbetoile() {
        return nbetoile;
    }

    public void setNbetoile(int nbetoile) {
        this.nbetoile = nbetoile;
    }

    public int getNbchambre() {
        return nbchambre;
    }

    public void setNbchambre(int nbchambre) {
        this.nbchambre = nbchambre;
    }

    public int getNbrestaurant() {
        return nbrestaurant;
    }

    public void setNbrestaurant(int nbrestaurant) {
        this.nbrestaurant = nbrestaurant;
    }

    public int getNbpiscine() {
        return nbpiscine;
    }

    public void setNbpiscine(int nbpiscine) {
        this.nbpiscine = nbpiscine;
    }

    public String getAdresse_rest() {
        return adresse_rest;
    }

    public void setAdresse_rest(String adresse_rest) {
        this.adresse_rest = adresse_rest;
    }

    public String getVillehotel() {
        return villehotel;
    }

    public void setVillehotel(String villehotel) {
        this.villehotel = villehotel;
    }

    @Override
    public String toString() {
        return "Hotel{" + "idhotel=" + idhotel + ", nom_hotel=" + nom_hotel + ", nbetoile=" + nbetoile + ", nbchambre=" + nbchambre + ", nbrestaurant=" + nbrestaurant + ", nbpiscine=" + nbpiscine + ", adresse_rest=" + adresse_rest + ", villehotel=" + villehotel + '}';
    }
   

    
}
