/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import models.*;
/**
 *
 * @author TemporaryUser
 */
public class UserDAO {
    private User user;
    public UserDAO(User u){
        this.user = u;
    }
    public boolean checkLogin(User u){
        return u.getName().equals(this.user.getName()) && u.getPassword().equals(this.user.getPassword());
    }
}
