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

public class loc_voiture {

    public static void add(loc_voiture loc_voiture) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //var
    
    private int idvoiture;
    private String date_res;
    private String dure_res;
    private String pays_des;
    private String type_dem;
    private float prix;
    
    
    //constructeurs
    
    
    public loc_voiture (){
    
}
            public loc_voiture (int idvoiture, String date_res, String dure_res, String pays_des, String type_dem , float prix ) {
        this.idvoiture = idvoiture;
        this.date_res = date_res ;
        this.dure_res = dure_res;
        this.pays_des = pays_des;
        this.type_dem = type_dem;
        this.prix = prix;
        }
        
            public loc_voiture (String date_res, String dure_res, String pays_des, String type_dem , float prix ) {
        this.date_res = date_res ;
        this.dure_res = dure_res;
        this.pays_des = pays_des;
        this.type_dem = type_dem;
        this.prix = prix; 
        }
            
    //getters w setters 

    public int getIdvoiture() {
        return idvoiture;
    }

    public void setIdvoiture(int idvoiture) {
        this.idvoiture = idvoiture;
    }

    public String getDate_res() {
        return date_res;
    }

    public void setDate_res(String date_res) {
        this.date_res = date_res;
    }

    public String getDure_res() {
        return dure_res;
    }

    public void setDure_res(String dure_res) {
        this.dure_res = dure_res;
    }

    public String getPays_des() {
        return pays_des;
    }

    public void setPays_des(String pays_des) {
        this.pays_des = pays_des;
    }

    public String getType_dem() {
        return type_dem;
    }

    public void setType_dem(String type_dem) {
        this.type_dem = type_dem;
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
        return "loc_voiture{" + "idvoiture=" + idvoiture + ", date_res=" + date_res + ", dure_res=" + dure_res + ", pays_des=" + pays_des + ", type_dem=" + type_dem + ", prix=" + prix + '}';
    }
    
    
    

}