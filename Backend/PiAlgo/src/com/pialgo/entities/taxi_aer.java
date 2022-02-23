/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DELL
 */

public class taxi_aer {

    public static void add(taxi_aer taxi_aer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //var
    
    private int idtaxi;
    private String taxi_matr;
    private String heure_arr;
    private String pays_des;
    private float prix;
    
    
    //constructeurs
    
    
    public taxi_aer (){
    
}
            public taxi_aer (int idtaxi, String taxi_matr, String heure_arr, String pays_des, float prix ) {
        this.idtaxi = idtaxi;
        this.taxi_matr = taxi_matr ;
        this.heure_arr = heure_arr;
        this.pays_des = pays_des;
        this.prix = prix;
        }
        
           public taxi_aer (String taxi_matr, String heure_arr, String pays_des, float prix ) {
        this.taxi_matr = taxi_matr ;
        this.heure_arr = heure_arr;
        this.pays_des = pays_des;
        this.prix = prix;
        } 
    //getters w setters 

    public int getIdtaxi() {
        return idtaxi;
    }

    public void setIdtaxi(int idtaxi) {
        this.idtaxi = idtaxi;
    }

    public String getTaxi_matr() {
        return taxi_matr;
    }

    public void setTaxi_matr(String taxi_matr) {
        this.taxi_matr = taxi_matr;
    }

    public String getHeure_arr() {
        return heure_arr;
    }

    public void setHeure_arr(String heure_arr) {
        this.heure_arr = heure_arr;
    }

    public String getPays_des() {
        return pays_des;
    }

    public void setPays_des(String pays_des) {
        this.pays_des = pays_des;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    //affichage

    @Override
    public String toString() {
        return "taxi_aer{" + "idtaxi=" + idtaxi + ", taxi_matr=" + taxi_matr + ", heure_arr=" + heure_arr + ", pays_des=" + pays_des + ", prix=" + prix + '}';
    }

    public void updatetaxi_aer(taxi_aer updated_taxi_aer, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    

}
