/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;


/**
 *
 * @author TemporaryUser
 */
public class ConnectDB {
    private String dbURL = "jdbc:mysql://localhost:3306/cnpm";
    String username = "gn0hp";
    private String pass = "@Pt103682912";
    public ConnectDB(){}
    public Connection connect(){
        Connection conn = null;
         try {
            conn = DriverManager.getConnection(dbURL, username, pass);
            System.out.println("Successfully connect to mysql! Current database: cnpm");
        } catch (SQLException e) {
            e.printStackTrace();
        }
         return conn;
    }
}
