package com.fergani.demo.Models;

public class User {
    private int id ;
    private String FirstName ;
    private String Lastname ;

    public User(int id, String firstName, String lastname) {
        this.id = id;
        FirstName = firstName;
        Lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }
}
