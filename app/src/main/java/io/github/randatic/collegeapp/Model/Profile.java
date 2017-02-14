package io.github.randatic.collegeapp.Model;

import java.util.Date;

/**
 * Created by Randy Bruner on 12/7/16.
 */

public class Profile {
    private String firstName, lastName;
    private Date birthdate;

    private String objectId;

    public Profile (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        birthdate = new Date();
    }

    public Profile (String firstName, String lastName, Date birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
    }



    //Getters & Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }



}
