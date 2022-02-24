/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pialgo;

import com.pialgo.bd.Connection_Bd;
import com.pialgo.entities.Administrateur;
import com.pialgo.entities.Client;
import com.pialgo.entities.Evenement;
import com.pialgo.entities.Utilisateur;
import com.pialgo.entities.role;
import com.pialgo.entities.ticket;
import com.pialgo.imservices.ImEvenement;
import com.pialgo.imservices.ImTicket;
import com.pialgo.imservices.ImUtilisateur;
import com.pialgo.imservices.ImtypeEvent;
import javax.management.relation.Role;

/**
 *
 * @author Sirine
 */
public class PiAlgo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ImEvenement im = new ImEvenement();
        
        //----------------------- ajout --------------------
     //im.ajouter(new Evenement(2,"event Tunis", "tunis", "l avenue", "20-02-2022","photo","carnaval"));
    
//----------- supprimer --
// im.supprimer(new Evenement(3));

// im.countUser(new Evenement(1));

//------- affichage -----//

   //     System.out.println(im.Show());
   
   //-------- Modifier------------------ //
   //im.Edit(new Evenement(4,"event Tunis", "tunis", "l avenue", "20-02-2022", 2, "photo"));
   
   
        ImtypeEvent it = new ImtypeEvent();
//-------------ajouter typeevent--// 
 //it.ajouter(new typeEvent("Festivl CArthage"));
//---------------Show-------------------------//        
//System.out.println(it.Show());
//----Edit-------//
//it.Edit(new typeEvent(1,"paris"));
//-----------supprimer---------//
//it.supprimer(new typeEvent(1));


   ImTicket ic = new ImTicket();
   //--------ajout--------//
  //ic.ajouter(new ticket(10.0,"date_tick",3));
   //--------Show--------//
 //  System.out.println(ic.Show());
   //--------Edit---------//
   //ic.Edit(new ticket(1,20,"04-05-1997"));
   //--------supprimer--------------//
   //ic.supprimer(new ticket(1));
   
   
   //------------------------------------------ Utilisateur ----------------------------------------//
   
        ImUtilisateur imu = new ImUtilisateur();    
        //imu.registre(new Utilisateur("oumayma","karoud","Ariana Soghra","sirine@sys.com","ouoom","photo",role.client));
   
  imu.login(new Utilisateur("sirine@sys.com","ouoom"));
 // imu.Supprimer(new Utilisateur(3));
   //imu.Edit(new Utilisateur(1,"oumayma","karoud","la goulette","oum.kra3a@gmail.com","oum","photo"));
 
       // ImAdministrateur ia = new ImAdministrateur();
     // ia.ajouter(new Administrateur(107,"oumayma","karoud","Ariana Soghra","ouma.kra7@gmail.com","oum","photo"));
     
       // System.out.println(ia.Show());
       
      // ia.supprimer(new Administrateur(1));
    
       
    }
    
    
    
    
    
}
