/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.security.auth.login.Configuration;
import org.hibernate.SessionFactory;

/**
 *
 * @author Selinam
 */
public class VoteConnection {
    
    public Connection getConnection()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("#################");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/evoting","root","");
            
            return conn;
        } catch (Exception e) {
        }
        return null;
    }
}
