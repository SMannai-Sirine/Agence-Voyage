/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.loc_voiture;

/**
 *
 * @author DELL
 */
public interface Iloc_voiture {
     
//add/ajout
    public void ajouterloc_voiture(loc_voiture v);
    public void ajouterloc_voiture2(loc_voiture v);
    
    //afficher
    public void afficherloc_voiture(loc_voiture v);
        //delete
    public void deleteloc_voiture(int idvoiture);
     //update
    public void modifierloc_voiture  (loc_voiture v ,int idvoiture);
    
     //list
    public List<loc_voiture> afficherloc_voiture();
    
}
