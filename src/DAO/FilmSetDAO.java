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
import models.FilmSet;
import java.util.*;
import models.Room;
import DAO.*;
/**
 *
 * @author gn0hp
 */
public class FilmSetDAO {
    private FilmSet filmSet;
    public FilmSetDAO(FilmSet u){
        this.filmSet = u;
    }
    public static ArrayList<FilmSet> getFilmSetByRoom(String roomId){
        ArrayList<FilmSet> res = new ArrayList<>();
        ConnectDB connectDB = new ConnectDB();
        Connection conn = connectDB.connect();
        String query = "Select * from tblFilmSet where tbRoomid=?";
        PreparedStatement stm = null;
         try{
            stm = conn.prepareStatement(query);
            stm.setString(1,roomId);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
               res.add(new FilmSet(rs.getString("ID"), rs.getInt("cost"), rs.getString("startTime"), DAO.RoomDAO.getRoomByID(rs.getString("tbRoomID")),
                       FilmDAO.getFilmByID(rs.getString("tblFilmID")), ScheduleDAO.getScheduleByID(rs.getString("tblScheduleID"))
               ));
            }
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return res;
    }
}
