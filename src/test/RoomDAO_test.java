/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import DAO.RoomDAO;
import java.util.ArrayList;
import models.Room;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author gn0hp
 */
public class RoomDAO_test {
    
     @Test
     public void Test_getRoomByID(){
         String ID = "5";
         Room room = RoomDAO.getRoomByID(ID);
         Assert.assertEquals("quia", room.getName());
         }
      @Test
     public void Test_getRoomData(){
         ArrayList<Room> expecteds = new ArrayList<>();
         expecteds.add(new Room("1", "voluptas", "3D", 16));
         expecteds.add(new Room("2", "veritatis", "VIP", 16));
         expecteds.add(new Room("3", "sint", "2D", 19));
         expecteds.add(new Room("4", "voluptas", "3D", 20));
         expecteds.add(new Room("5", "quia", "2D", 20));
         ArrayList<Room> arr = RoomDAO.getRoomData();
         Assert.assertNotNull(arr);
         Assert.assertEquals(5, arr.size());
         Assert.assertEquals("veritatis", arr.get(1).getName());
         //Assert.assertArrayEquals(expecteds.toArray(), arr.toArray());
         return ;
         
         }
}
