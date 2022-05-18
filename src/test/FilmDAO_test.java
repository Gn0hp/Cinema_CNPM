/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import DAO.FilmDAO;
import models.Film;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

/**
 *
 * @author gn0hp
 */
public class FilmDAO_test {
    
     @Test
     public void Test_getFilmByID(){
         String ID = "1";
         Film film = FilmDAO.getFilmByID(ID);
         Assert.assertEquals("JUSTICE LEAGUE", film.getName());
         }
      @Test
     public void Test_getAllFilm(){
         ArrayList<Film> arr = FilmDAO.getAllFilm();
         Assert.assertNotNull(arr);
         Assert.assertEquals(5, arr.size());
         return ;
         }
}
