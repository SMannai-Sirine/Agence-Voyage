/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.taxi_aer;

/**
 *
 * @author DELL
 */
public interface Itaxi_aer {
    
   
     
//add/ajout
    public void ajoutertaxi_aer(taxi_aer t);
    public void ajoutertaxi_aer2(taxi_aer t);
   //afficher
    public void affichertaxi_aer(taxi_aer t);
    //delete
    public void deletetaxi_aer(int idtaxi);
    //update
    public void modifiertaxi_aer (taxi_aer t ,int idtaxi);
     //list
    public List<taxi_aer> affichertaxi_aer();
}
    
