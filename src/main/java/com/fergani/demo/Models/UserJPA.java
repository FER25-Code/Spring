package com.fergani.demo.Models;
import javax.persistence.*;


/**
 * Created By ${
 * FERGANI DIA EL EDDINE
 * }  On
 * 19
 * sept.
 * 2020
 */

@Entity
public class UserJPA {
@Id
@GeneratedValue(strategy= GenerationType.AUTO)
private int Id;

private String firstName ;
private String lastName;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        lastName = lastName;
    }

    public UserJPA() {

    }

    public UserJPA(int id, String firstName, String lastName) {
        Id = id;
        firstName = firstName;
        lastName = lastName;
    }
}
