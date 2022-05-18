/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import DAO.FilmSetDAO;
import java.util.ArrayList;
import models.FilmSet;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author gn0hp
 */
public class FilmSetDAO_test {
    
     @Test
     public void Test_getFilmSetByRoom(){
         String ID = "1";
         ArrayList<FilmSet> filmSet = FilmSetDAO.getFilmSetByRoom(ID);
         Assert.assertNotNull(filmSet);
         Assert.assertEquals(1, filmSet.size());
         Assert.assertEquals("AQUAMAN", filmSet.get(0).getFilm().getName());
         Assert.assertNotEquals("WANDA VISION", filmSet.get(0).getFilm().getName());
        }
     
}
