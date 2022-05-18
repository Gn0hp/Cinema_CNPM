/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.*;
/**
 *
 * @author TemporaryUser
 */
public class UserDAO {
    private User user;
    public UserDAO(User u){
        this.user = u;
    }
    public boolean checkLogin(User u){
        return u.getName().equals(this.user.getName()) && u.getPassword().equals(this.user.getPassword());
    }
    public static User getUserByID(String id){
        User res = new User();
        ConnectDB connectDB = new ConnectDB();
        Connection conn = connectDB.connect();
        String query = "Select * from tblUser where id=?";
        PreparedStatement stm = null;
         try{
            stm = conn.prepareStatement(query);
            stm.setString(1,id);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
               return new User(rs.getString("ID"), rs.getString("name"), rs.getString("password"), rs.getInt("role"));
            }
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }   
         return res;
    }
}

