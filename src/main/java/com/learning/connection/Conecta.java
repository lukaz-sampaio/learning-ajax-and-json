package com.learning.connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author lucas
 */
public class Conecta {

    private static Connection instance;
    private Conecta(){}
    
    private Connection getConnection(){
        Connection conn = null;
        final String DRIVER = "org.postgresql.Driver";
        final String USER = "postgres";
        final String PASS = "toor";
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/banco_teste", USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public static Connection getInstance(){
        if(instance == null){
            Conecta conecta = new Conecta();
            instance = conecta.getConnection();
        }
        return instance;
    }
}