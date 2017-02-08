package io.github.randatic.collegeapp.Model;

/**
 * Created by Randy Bruner on 12/13/16.
 */
public abstract class FamilyMember implements Comparable<FamilyMember> {

    protected String firstName;
    protected String lastName;

    public FamilyMember() {
        firstName = "Avery";
        lastName = "Jackson";
    }

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

    @Override
    public int compareTo(FamilyMember other) {
        return firstName.compareTo(other.getFirstName());
    }
}
