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
import java.sql.Statement;
import java.util.ArrayList;
import models.Film;
import models.Room;

/**
 *
 * @author gn0hp
 */
public class FilmDAO {
    private Film film;
    public FilmDAO(Film u){
        this.film = u;
    }
    public static Film getFilmByID(String filmID){
        Film res = new Film();
        ConnectDB connectDB = new ConnectDB();
        Connection conn = connectDB.connect();
        String query = "Select * from tblFilm where id=?";
        PreparedStatement stm = null;
         try{
            stm = conn.prepareStatement(query);
            stm.setString(1,filmID);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
               return new Film(rs.getString("ID"), rs.getString("name"), rs.getString("type"), rs.getInt("year"), rs.getString("studio"), rs.getInt("ageLimit"));
            }
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }   
         return res;
    }
    public static ArrayList<Film> getAllFilm(){
        ArrayList<Film> arrFilm = new ArrayList<>();
        ConnectDB connectDB = new ConnectDB();
        Connection conn = connectDB.connect();
        String query = "Select * from tblFilm" ;
        try{
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                arrFilm.add(new Film(rs.getString("ID"), rs.getString("name"), rs.getString("type"), rs.getInt("year"), rs.getString("studio"), rs.getInt("ageLimit")));
            }
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return arrFilm;
    }
}
