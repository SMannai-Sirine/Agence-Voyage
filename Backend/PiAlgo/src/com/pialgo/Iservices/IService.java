/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;

/**
 *
 * @author Dell
 * @param <T>
 */
public interface IService<T> {
    
    public void ajout(T t);
    public void modifier(T t);
    public void supprime(int id);
    public List<T> affiche();
    
}
