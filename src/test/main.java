/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import org.junit.runner.Result;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;


/**
 *
 * @author gn0hp
 */
public class main {
    public static void main(String[] args) {
        try{
        Result res = JUnitCore.runClasses(userDAO_test.class, FilmDAO_test.class, RoomDAO_test.class, FilmSetDAO_test.class);
        for(Failure fail: res.getFailures()){
            System.out.println(fail.toString());
        }
        System.out.println(res.wasSuccessful());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
