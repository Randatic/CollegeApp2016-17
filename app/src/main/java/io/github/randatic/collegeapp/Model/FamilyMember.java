package io.github.randatic.collegeapp.Model;

/**
 * Created by Randy Bruner on 12/13/16.
 */
public abstract class FamilyMember {

    protected String firstName;
    protected String lastName;

    public FamilyMember (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //Getters & Setters`
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
}
