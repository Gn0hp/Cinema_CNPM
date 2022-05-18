/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author TemporaryUser
 */
public class FilmSet {
    private String ID;
    private int cost;
    private String startTime;
    private Room room;
    private Film film;
    private User user;
    
    public FilmSet(){}
    public FilmSet(String ID, int cost, String startTime, Room room, Film film) {
        this.ID = ID;
        this.cost = cost;
        this.startTime = startTime;
        this.room = room;
        this.film = film;
    }

    public FilmSet(String ID, int cost, String startTime, Room room, Film film, User user) {
        this.ID = ID;
        this.cost = cost;
        this.startTime = startTime;
        this.room = room;
        this.film = film;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    
    
    
}
