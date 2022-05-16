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
    private int idhotel;
    private String nomreservation;
    private int chambreres;
    private Date date;
    
    public Reservation(){
        
    }

    public Reservation(int idhotel, String nomreservation, int chambreres, Date date) {
        this.idhotel = idhotel;
        this.nomreservation = nomreservation;
        this.chambreres = chambreres;
        this.date = date;
    }

    public Reservation(int id, int idhotel, String nomreservation, int chambreres, Date date) {
        this.id = id;
        this.idhotel = idhotel;
        this.nomreservation = nomreservation;
        this.chambreres = chambreres;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdhotel() {
        return idhotel;
    }

    public void setIdhotel(int idhotel) {
        this.idhotel = idhotel;
    }

    public String getNomreservation() {
        return nomreservation;
    }

    public void setNomreservation(String nomreservation) {
        this.nomreservation = nomreservation;
    }

    public int getChambreres() {
        return chambreres;
    }

    public void setChambreres(int chambreres) {
        this.chambreres = chambreres;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", idhotel=" + idhotel + ", nomreservation=" + nomreservation + ", chambreres=" + chambreres + ", date=" + date + '}';
    }

  
    
    
    
}
