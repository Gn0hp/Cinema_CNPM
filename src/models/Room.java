/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author TemporaryUser
 */
public class Room {
    private String ID;
    private String name;
    private String type;
    private int seats;

    public Room(String ID, String name, String type, int seats) {
        this.ID = ID;
        this.name = name;
        this.type = type;
        this.seats = seats;
    }
    public Room(){}

    public String getID() {
        return ID;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
    
}
