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
import models.*;
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
        String query = "Select * from tblFilmSet where tbRoomID=?";
        PreparedStatement stm = null;
         try{
            stm = conn.prepareStatement(query);
            stm.setString(1,roomId);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
               res.add(new FilmSet(rs.getString("ID"), rs.getInt("cost"), rs.getString("startTime"), DAO.RoomDAO.getRoomByID(rs.getString("tbRoomID")),
                       FilmDAO.getFilmByID(rs.getString("tblFilmID")), UserDAO.getUserByID(rs.getString("tblUserID")))
               );
            }
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return res;
    }
    public static FilmSet getFilmSetByID(String id){
        FilmSet res = new FilmSet();
        ConnectDB connectDB = new ConnectDB();
        Connection conn = connectDB.connect();
        String query = "Select * from tblFilmSet where id=?";
        PreparedStatement stm = null;
         try{
            stm = conn.prepareStatement(query);
            stm.setString(1,id);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("tblScheduleID"));
                System.out.println(rs.getString("tblFilmID"));
               return new FilmSet(rs.getString("ID"), rs.getInt("cost"), rs.getString("startTime"), DAO.RoomDAO.getRoomByID(rs.getString("tbRoomID")),
                       FilmDAO.getFilmByID(rs.getString("tblFilmID")));
              
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }   
         return res;
    }
    public static ArrayList<FilmSet> getAllFilmSet(){
        ArrayList<FilmSet> res = new ArrayList<>();
        ConnectDB connectDB = new ConnectDB();
        Connection conn = connectDB.connect();
        String query = "Select * from tblFilmSet";
        PreparedStatement stm = null;
         try{
            stm = conn.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
               res.add(new FilmSet(rs.getString("ID"), rs.getInt("cost"), rs.getString("startTime"), DAO.RoomDAO.getRoomByID(rs.getString("tbRoomID")),
                       FilmDAO.getFilmByID(rs.getString("tblFilmID")), UserDAO.getUserByID(rs.getString("tblUserID")))
               );
            }
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return res;
    }
    public static int addFilmSet(Room _room, Film _film){
        int seats = _room.getSeats();
        int giave = 0;
        try{
            String sql = "insert into tblFilmSet values(?,?,?,?,?,?)";
            ConnectDB connectDB = new ConnectDB();
            Connection conn = connectDB.connect();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, Integer.toString(getAllFilmSet().size()+1));  // ID
            stm.setInt(2, seats * 1000);   //cost
            stm.setString(3, "21:00");  // starttime
            stm.setString(4, _room.getID()); //room
            stm.setString(5, _film.getID()); //film
            stm.setString(6, "1"); //
            stm.execute();
            giave = 50000/seats;
        }
        catch(SQLException e){
            e.printStackTrace();
        } 
        return giave;
    }
    
}
