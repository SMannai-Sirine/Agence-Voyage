/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.entities;

import java.sql.Date;

/**
 *
 * @author 21658
 */
public class Reservation {
    private int id;
    private Date date_reservaion;
    private int id_Hotel_Restaurant;
    private int id_client;
    private String nom_Hotel_restaurant;
    
    public Reservation(){
        
    }

    public Reservation(int id, Date date_reservaion, int id_Hotel_Restaurant, int id_client) {
        this.id = id;
        this.date_reservaion = date_reservaion;
        this.id_Hotel_Restaurant = id_Hotel_Restaurant;
        this.id_client = id_client;
        this.nom_Hotel_restaurant = nom_Hotel_restaurant;

    }

    public Reservation(Date date_reservaion, int id_Hotel_Restaurant, int id_client) {
        this.date_reservaion = date_reservaion;
        this.id_Hotel_Restaurant = id_Hotel_Restaurant;
        this.id_client = id_client;
                this.nom_Hotel_restaurant = nom_Hotel_restaurant;

    }

    public Reservation(int i, String string, int i0, int i1, String malek) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public Date getDate_reservaion() {
        return date_reservaion;
    }

    public int getId_Hotel_Restaurant() {
        return id_Hotel_Restaurant;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_Hotel_restaurant() {
        return nom_Hotel_restaurant;
    }
    

    public void setDate_reservaion(Date date_reservaion) {
        this.date_reservaion = date_reservaion;
    }

    public void setId_Hotel_Restaurant(int id_Hotel_Restaurant) {
        this.id_Hotel_Restaurant = id_Hotel_Restaurant;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public void setNom_Hotel_restaurant(String nom_Hotel_restaurant) {
        this.nom_Hotel_restaurant = nom_Hotel_restaurant;
    }
    

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", date_reservaion=" + date_reservaion + ", id_Hotel_Restaurant=" + id_Hotel_Restaurant + ", id_client=" + id_client + "nom_Hotel_restaurant" +nom_Hotel_restaurant + '}';
    }
    
    
    
}
