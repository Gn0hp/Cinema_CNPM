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
import models.Schedule;
/**
 *
 * @author gn0hp
 */
public class ScheduleDAO {
    private Schedule schedule;
    
    public ScheduleDAO(Schedule u){
        this.schedule = u;
    }
    public static Schedule getScheduleByID(String id){
         Schedule res = new Schedule();
        ConnectDB connectDB = new ConnectDB();
        Connection conn = connectDB.connect();
        String query = "Select * from tblschedule where id=?";
        PreparedStatement stm = null;
         try{
            stm = conn.prepareStatement(query);
            stm.setString(1,id);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
               return new Schedule(rs.getString("ID"), UserDAO.getUserByID(rs.getString("tbleUserID")), rs.getDate("time"));
            }
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }   
         return res;
    }
}
