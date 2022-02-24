/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pialgo.Iservices;

import java.util.List;

/**
 *
 * @author Sirine
 */
public interface Iservices<T> {
    
    public void ajouter(T t);
    public void Edit(T t);
    public List<T> Show();
    public void supprimer(T t);
    
}
