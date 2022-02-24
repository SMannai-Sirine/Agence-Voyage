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
public interface IserviceUtil<T>  {

    public void registre(T t);
    public void login(T t);
    public List<T> affiche();
    public void Supprimer(T t);
    public void modifier(T t);
    
}
