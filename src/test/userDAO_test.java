/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;


import DAO.*;
import models.*;
import org.junit.Assert;
import org.junit.Test;
/**
 *
 * @author gn0hp
 */
public class userDAO_test {
    @Test
     public void Test_getUserByID(){
         String ID = "1";
         User usr = UserDAO.getUserByID(ID);
         Assert.assertEquals(3, usr.getRole());
         return ;
         }
}
