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
public class Reservationtaxi_aer {
     public static void add(Reservationtaxi_aer Reservationtaxi_aer) {
        throw new UnsupportedOperationException("Not supported yet.");
    
}
//var
    private int idReservationtaxi_aer ;
    private String dateReservationtaxi_aer ;
    private int idU ;
    private int idtaxi ;

    public Reservationtaxi_aer(int idReservationtaxi_aer, String dateReservationtaxi_aer, int idU, int idtaxi) {
        this.idReservationtaxi_aer = idReservationtaxi_aer;
        this.dateReservationtaxi_aer = dateReservationtaxi_aer;
        this.idU = idU;
        this.idtaxi = idtaxi;
    }

    public Reservationtaxi_aer(String dateReservationtaxi_aer, int idU, int idtaxi) {
        this.dateReservationtaxi_aer = dateReservationtaxi_aer;
        this.idU = idU;
        this.idtaxi = idtaxi;
    }

    public int getIdReservationtaxi_aer() {
        return idReservationtaxi_aer;
    }

    public void setIdReservationtaxi_aer(int idReservationtaxi_aer) {
        this.idReservationtaxi_aer = idReservationtaxi_aer;
    }

    public String getDateReservationtaxi_aer() {
        return dateReservationtaxi_aer;
    }

    public void setDateReservationtaxi_aer(String dateReservationtaxi_aer) {
        this.dateReservationtaxi_aer = dateReservationtaxi_aer;
    }

    public int getIdUtilisateur() {
        return idU;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idU = idU;
    }

    public int getIdtaxi() {
        return idtaxi;
    }

    public void setIdtaxi(int idtaxi) {
        this.idtaxi = idtaxi;
    }

    public int getIdU() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}

