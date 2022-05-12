/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import cinema.ManagerHomeFrm;
import database.ConnectDB;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Room;
import models.User;
import java.util.ArrayList;
/**
 *
 * @author gn0hp
 */
public class RoomDAO {
    private Room room;
    public RoomDAO(Room u){
        this.room = u;
    }
    public static ArrayList<Room> getRoomData(){
        ArrayList<Room> roomArr = new ArrayList<>();
        ConnectDB connectDB = new ConnectDB();
        Connection conn = connectDB.connect();
        String query = "Select * from tblRoom" ;
        try{
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                roomArr.add(new Room(rs.getString("ID"), rs.getString("name"), rs.getString("type"), rs.getInt("seats")));
            }
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return roomArr;
    }
    public static Room getRoomByID(String id){
        Room res = new Room();
        ConnectDB connectDB = new ConnectDB();
        Connection conn = connectDB.connect();
        String query = "Select * from tblRoom where id=?";
        PreparedStatement stm = null;
         try{
            stm = conn.prepareStatement(query);
            stm.setString(1,id);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
               return new Room(rs.getString("ID"), rs.getString("name"), rs.getString("type"), rs.getInt("seats"));
            }
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }   
         return res;
    }
}
