/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pialgo.bd;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author Sirine
 */
public class Connection_Bd {
    private static Connection_Bd instance;
    private Connection cnx;
    
    private final String URL = "jdbc:mysql://localhost:3306/pialgo";
    private final String USER = "root";
    private final String PASSWORD = "";
    
    private Connection_Bd() {
        try {
            cnx = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connecting !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static Connection_Bd getInstance() {
        if(instance == null)
            instance = new Connection_Bd();
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
}
